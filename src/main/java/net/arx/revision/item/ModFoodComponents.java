package net.arx.revision.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent MANGO = new FoodComponent.Builder()
            .nutrition(4).
            saturationModifier(0.3f).build();
    public static final FoodComponent GOLDEN_MANGO = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(1.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0F)
            .alwaysEdible()
            .build();
}
