package net.arx.revision.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public class SawmillRecipe implements Recipe<SingleStackRecipeInput> {
    private final Ingredient input;
    private final ItemStack output;

    public SawmillRecipe(Ingredient input, ItemStack output) {
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
    public boolean matches(SingleStackRecipeInput inv, World world) {
        return this.input.test(inv.item());
    }

    @Override
    public ItemStack craft(SingleStackRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.SAWMILL_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.SAWMILL_TYPE;
    }

    // === Serializer for datapacks + networking ===
    public static class Serializer implements RecipeSerializer<SawmillRecipe> {
        // Datapack JSON <-> Recipe
        public static final MapCodec<SawmillRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
                instance.group(
                        Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(SawmillRecipe::getInput),
                        ItemStack.CODEC.fieldOf("result").forGetter(SawmillRecipe::getOutput)
                ).apply(instance, SawmillRecipe::new)
        );

        // Networking (client sync)
        public static final PacketCodec<RegistryByteBuf, SawmillRecipe> PACKET_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, SawmillRecipe::getInput,
                        ItemStack.PACKET_CODEC, SawmillRecipe::getOutput,
                        SawmillRecipe::new
                );

        @Override
        public MapCodec<SawmillRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, SawmillRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}
