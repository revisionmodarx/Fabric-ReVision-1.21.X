package net.arx.revision.recipe;

import com.google.gson.JsonObject;
import com.mojang.serialization.MapCodec;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

/**
 * Sawmill Recipe:
 *  - Single input Ingredient
 *  - Single output ItemStack
 */
public class SawmillRecipe implements Recipe<Inventory> {
    private final Identifier id;
    private final Ingredient input;
    private final ItemStack output;

    public SawmillRecipe(Identifier id, Ingredient input, ItemStack output) {
        this.id = id;
        this.input = input;
        this.output = output;
    }

    public Ingredient getInput() {
        return input;
    }

    public ItemStack getOutput() {
        return output;
    }

    @Override
    public boolean matches(Inventory inv, World world) {
        return input.test(inv.getStack(0));
    }

    @Override
    public ItemStack craft(Inventory input, RegistryWrapper.WrapperLookup lookup) {
        return null;
    }

    @Override
    public ItemStack craft(Inventory inv) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return null;
    }

    @Override
    public ItemStack getResult(Inventory inv) {
        return output;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.SAWMILL_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.SAWMILL_RECIPE_TYPE;
    }

    // --- Serializer ---
    public static class Serializer implements RecipeSerializer<SawmillRecipe> {
        @Override
        public SawmillRecipe read(Identifier id, JsonObject json) {
            Ingredient input = Ingredient.fromJson(json.get("ingredient"));
            ItemStack output = net.minecraft.recipe.ShapedRecipe.outputFromJson(json.getAsJsonObject("result"));
            return new SawmillRecipe(id, input, output);
        }

        @Override
        public SawmillRecipe read(Identifier id, PacketByteBuf buf) {
            Ingredient input = Ingredient.fromPacket(buf);
            ItemStack output = buf.readItemStack();
            return new SawmillRecipe(id, input, output);
        }

        @Override
        public void write(PacketByteBuf buf, SawmillRecipe recipe) {
            recipe.input.write(buf);
            buf.writeItemStack(recipe.output);
        }

        @Override
        public MapCodec<SawmillRecipe> codec() {
            return null;
        }

        @Override
        public PacketCodec<RegistryByteBuf, SawmillRecipe> packetCodec() {
            return null;
        }
    }
}
