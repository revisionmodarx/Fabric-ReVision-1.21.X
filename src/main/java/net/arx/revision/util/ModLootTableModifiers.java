package net.arx.revision.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.arx.revision.item.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier JUNGLE_LEAVES_ID =
            Identifier.of("minecraft", "blocks/jungle_leaves");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
            if (JUNGLE_LEAVES_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f)) // 10% chance, adjust as you like
                        .with(ItemEntry.builder(ModItems.MANGO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)));

                tableBuilder.pool(poolBuilder.build());
            }
            if(LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_COMMON_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.MANGO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            //                          ----- GOLDEN MANGOES STRUCTURE -----
            if(LootTables.JUNGLE_TEMPLE_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.GOLDEN_MANGO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(LootTables.SIMPLE_DUNGEON_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.GOLDEN_MANGO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_COMMON_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.22f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.GOLDEN_MANGO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            //                      ----- END OF GOLDEN MANGOES STRUCTURE -----

        });
    }
}
