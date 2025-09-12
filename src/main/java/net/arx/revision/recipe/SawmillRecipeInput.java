package net.arx.revision.recipe;

import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;

/**
 * Simple wrapper for sawmill recipe input.
 * Essentially just a single-slot inventory wrapper.
 */
public class SawmillRecipeInput extends SimpleInventory {
    public SawmillRecipeInput(ItemStack stack) {
        super(1);
        this.setStack(0, stack);
    }

    public static SawmillRecipeInput of(ItemStack stack) {
        return new SawmillRecipeInput(stack);
    }

    public ItemStack getInputStack() {
        return this.getStack(0);
    }

    public void setInputStack(ItemStack stack) {
        this.setStack(0, stack);
    }
}
