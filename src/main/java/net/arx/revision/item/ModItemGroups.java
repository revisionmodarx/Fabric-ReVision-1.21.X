package net.arx.revision.item;

import net.arx.revision.ReVision;
import net.arx.revision.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ReVision.MOD_ID, "re-vision"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.AMULET))
                    .displayName(Text.translatable("itemgroup.revision.revision"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.OAK_PANELLING);
                        entries.add(ModBlocks.SPRUCE_PANELLING);
                        entries.add(ModBlocks.BIRCH_PANELLING);
                        entries.add(ModBlocks.JUNGLE_PANELLING);
                        entries.add(ModBlocks.ACACIA_PANELLING);
                        entries.add(ModBlocks.DARK_OAK_PANELLING);
                        entries.add(ModBlocks.MANGROVE_PANELLING);
                        entries.add(ModBlocks.CHERRY_PANELLING);
                        entries.add(ModBlocks.BAMBOO_PANELLING);
                        entries.add(ModBlocks.PALE_PANELLING);
                        entries.add(ModBlocks.CRIMSON_PANELLING);
                        entries.add(ModBlocks.WARPED_PANELLING);
                        entries.add(ModItems.RUBY);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModItems.AMULET);
                        entries.add(ModItems.MANGO);
                        entries.add(ModItems.GOLDEN_MANGO);
                       // entries.add(ModBlocks.SAWMILL);
                    }).build());

    public static void registerItemGroups() {
        ReVision.LOGGER.info("Registering Item Groups for " + ReVision.MOD_ID);
    }
}


