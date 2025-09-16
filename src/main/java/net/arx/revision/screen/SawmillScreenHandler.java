package net.arx.revision.screen;

import net.arx.revision.recipe.ModRecipes;
import net.arx.revision.recipe.SawmillRecipe;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;

import java.util.List;

public class SawmillScreenHandler extends ScreenHandler {
    private final Inventory inputInventory = new SimpleInventory(1) {
        @Override
        public void markDirty() {
            super.markDirty();
            SawmillScreenHandler.this.onContentChanged(this);
        }
    };
    private final Inventory resultInventory = new SimpleInventory(1);
    private final ScreenHandlerContext context;
    private final PlayerEntity player;
    private List<RecipeEntry<SawmillRecipe>> availableRecipes = List.of();
    private int selectedRecipe = -1;
    private Runnable contentsChangedListener = () -> {};
    private boolean canCraft;

    public SawmillScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public SawmillScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(ModScreenHandlers.SAWMILL_SCREEN_HANDLER, syncId);
        this.context = context;
        this.player = playerInventory.player;

        // Input slot
        this.addSlot(new Slot(this.inputInventory, 0, 20, 33));

        // Result slot
        this.addSlot(new Slot(this.resultInventory, 0, 143, 33) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });

        // Player inventory
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // Hotbar
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inputInventory.canPlayerUse(player);
    }

    @Override
    public void onContentChanged(Inventory inventory) {
        super.onContentChanged(inventory);
        if (inventory == this.inputInventory) {
            this.updateAvailableRecipes();
        }
        this.contentsChangedListener.run();
    }

    private void updateAvailableRecipes() {
        ItemStack stack = this.inputInventory.getStack(0);
        if (stack.isEmpty()) {
            this.availableRecipes = List.of();
            this.resultInventory.setStack(0, ItemStack.EMPTY);
        } else {
            RecipeManager recipeManager = this.player.getWorld().getRecipeManager();
            this.availableRecipes = recipeManager.listAllOfType(ModRecipes.SAWMILL_TYPE).stream()
                    .filter(recipe -> recipe.value().matches(
                            new net.minecraft.recipe.input.SingleStackRecipeInput(this.inputInventory.getStack(0)),
                            this.player.getWorld()
                    ))
                    .toList();


            if (!this.availableRecipes.isEmpty()) {
                this.selectedRecipe = 0;
                this.craftRecipe();
            } else {
                this.resultInventory.setStack(0, ItemStack.EMPTY);
            }
        }
    }

    private void craftRecipe() {
        if (!this.availableRecipes.isEmpty() && this.selectedRecipe >= 0 && this.selectedRecipe < this.availableRecipes.size()) {
            RecipeEntry<SawmillRecipe> recipe = this.availableRecipes.get(this.selectedRecipe);
            ItemStack result = recipe.value().craft(
                    new net.minecraft.recipe.input.SingleStackRecipeInput(this.inputInventory.getStack(0)),
                    this.player.getWorld().getRegistryManager()
            );

            this.resultInventory.setStack(0, result);
        }
    }

    public List<RecipeEntry<SawmillRecipe>> getAvailableRecipes() {
        return this.availableRecipes;
    }

    public int getAvailableRecipeCount() {
        return this.availableRecipes.size();
    }

    public int getSelectedRecipe() {
        return this.selectedRecipe;
    }

    public boolean canCraft() {
        return this.canCraft && !this.availableRecipes.isEmpty();
    }

    public void setContentsChangedListener(Runnable listener) {
        this.contentsChangedListener = listener;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasStack()) {
            ItemStack original = slot.getStack();
            newStack = original.copy();

            if (index == 1) { // result slot
                if (!this.insertItem(original, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickTransfer(original, newStack);
            } else if (index == 0) { // input slot
                if (!this.insertItem(original, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(original, 0, 1, false)) {
                return ItemStack.EMPTY;
            }

            if (original.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }
}
