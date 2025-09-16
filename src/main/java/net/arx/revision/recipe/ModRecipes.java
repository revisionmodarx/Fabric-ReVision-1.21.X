package net.arx.revision.recipe;

import net.arx.revision.ReVision;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeType<SawmillRecipe> SAWMILL_TYPE =
            Registry.register(Registries.RECIPE_TYPE,
                    Identifier.of(ReVision.MOD_ID, "sawmilling"),
                    new RecipeType<>() {});

    public static final RecipeSerializer<SawmillRecipe> SAWMILL_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER,
                    Identifier.of(ReVision.MOD_ID, "sawmilling"),
                    new SawmillRecipeSerializer());

    public static void registerRecipes() {
        ReVision.LOGGER.info("Registering recipes for " + ReVision.MOD_ID);
    }
}
