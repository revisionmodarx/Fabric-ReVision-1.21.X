package net.arx.revision.recipe;

import net.arx.revision.ReVision;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeType<SawmillRecipe> SAWMILL_RECIPE_TYPE =
            Registry.register(Registries.RECIPE_TYPE,
                    new Identifier(ReVision.MOD_ID, "sawmill"),
                    new RecipeType<>() {
                        @Override
                        public String toString() {
                            return ReVision.MOD_ID + ":sawmill";
                        }
                    });

    public static final RecipeSerializer<SawmillRecipe> SAWMILL_RECIPE_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER,
                    new Identifier(ReVision.MOD_ID, "sawmill"),
                    new SawmillRecipe.Serializer());

    public static void registerRecipes() {
        ReVision.LOGGER.info("Registering Recipes for " + ReVision.MOD_ID);
    }
}
