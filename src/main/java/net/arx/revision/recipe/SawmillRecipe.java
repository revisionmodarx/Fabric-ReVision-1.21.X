package net.arx.revision.recipe;

import net.arx.revision.block.ModBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;

public class SawmillRecipe extends CuttingRecipe {

    public SawmillRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(ModRecipes.SAWMILL_TYPE, ModRecipes.SAWMILL_SERIALIZER, group, ingredient, result);
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        return this.ingredient.test(input.item()); // ✅ use .item() instead of .stack()
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModBlocks.SAWMILL); // TODO: replace with your sawmill block once registered
    }
}
