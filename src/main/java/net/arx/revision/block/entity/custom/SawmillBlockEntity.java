package net.arx.revision.block.entity.custom;

import net.arx.revision.block.entity.ModBlockEntities;
import net.arx.revision.screen.SawmillScreenHandler;
import net.arx.revision.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

/**
 * Sawmill Block Entity — holds inventory and opens screen.
 *
 * - 1 input slot + 1 result slot
 * - Saves/loads contents
 * - Provides screen handler factory
 * - Drops inventory when broken
 */
public class SawmillBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(2, ItemStack.EMPTY);

    public SawmillBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SAWMILL, pos, state);
    }

    // --- Inventory Handling ---
    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, items);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
    }

    // --- GUI / Screen ---
    @Override
    public Text getDisplayName() {
        return Text.translatable("block.revision.sawmill");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new SawmillScreenHandler(syncId, playerInventory, this);
    }

    // --- Extra Helpers ---
    /**
     * Called from block when broken to drop items.
     */
    public void dropInventory(PlayerEntity player) {
        for (ItemStack stack : items) {
            if (!stack.isEmpty()) {
                player.dropItem(stack, false);
            }
        }
        clear();
    }

    /**
     * Used for comparator output.
     */
    public int getComparatorOutput() {
        int filled = 0;
        int total = items.size();
        for (ItemStack stack : items) {
            if (!stack.isEmpty()) {
                filled++;
            }
        }
        return Math.round((float) filled / (float) total * 15);
    }
}
