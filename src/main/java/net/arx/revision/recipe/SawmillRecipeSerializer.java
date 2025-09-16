package net.arx.revision.recipe;

import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.ItemStack;

public class SawmillRecipeSerializer extends CuttingRecipe.Serializer<SawmillRecipe> {
    public SawmillRecipeSerializer() {
        super(SawmillRecipe::new); // we can call protected constructor here
    }
}
