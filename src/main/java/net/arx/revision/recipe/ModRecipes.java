package net.arx.revision.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    // Define recipe type
    public static final RecipeType<SawmillRecipe> SAWMILL_TYPE =
            Registry.register(Registries.RECIPE_TYPE,
                    Identifier.of("revision", "sawmilling"),
                    new RecipeType<>() { public String toString() { return "revision:sawmilling"; } });


    // Define serializer
    public static final RecipeSerializer<SawmillRecipe> SAWMILL_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER,
                    Identifier.of("revision", "sawmilling"),
                    new SawmillRecipe.Serializer());

    public static void registerRecipes() {
        // Call in your mod initializer
    }
}
