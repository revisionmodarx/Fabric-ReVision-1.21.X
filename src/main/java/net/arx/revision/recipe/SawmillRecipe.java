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
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record SawmillRecipe(Ingredient inputItem, ItemStack output) implements Recipe<SawmillRecipeInput> {

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    // read Recipe JSON files ---> new SawmillRecipe

    @Override
    public boolean matches(SawmillRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(SawmillRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.SAWMILL_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.SAWMILL_TYPE;
    }

    public static class Serializer implements RecipeSerializer<SawmillRecipe> {
        public static final MapCodec<SawmillRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(SawmillRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(SawmillRecipe::output)
        ).apply(inst, SawmillRecipe::new));

        public static final PacketCodec<RegistryByteBuf, SawmillRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, SawmillRecipe::inputItem,
                        ItemStack.PACKET_CODEC, SawmillRecipe::output,
                        SawmillRecipe::new);

        @Override
        public MapCodec<SawmillRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, SawmillRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}