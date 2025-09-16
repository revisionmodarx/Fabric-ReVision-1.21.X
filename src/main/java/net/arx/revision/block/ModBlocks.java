package net.arx.revision.block;

import net.arx.revision.ReVision;
import net.arx.revision.block.custom.SawmillBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // WOOD PANELLING BLOCKS
    public static final Block OAK_PANELLING = registerBlock("oak_panelling",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .instrument(NoteBlockInstrument.BASS)
                    .requiresTool()
                    .mapColor(MapColor.OAK_TAN)
            )
    );

    public static final Block SPRUCE_PANELLING = registerBlock("spruce_panelling",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .instrument(NoteBlockInstrument.BASS)
                    .mapColor(MapColor.SPRUCE_BROWN)
            )
    );

    public static final Block BIRCH_PANELLING = registerBlock("birch_panelling",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .instrument(NoteBlockInstrument.BASS)
                    // ⚠️ you set mapColor twice, remove one
                    .mapColor(MapColor.PALE_YELLOW)
            )
    );

    public static final Block JUNGLE_PANELLING = registerBlock("jungle_panelling",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .instrument(NoteBlockInstrument.BASS)
                    .mapColor(MapColor.DIRT_BROWN)
            )
    );

    public static final Block ACACIA_PANELLING = registerBlock("acacia_panelling",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .instrument(NoteBlockInstrument.BASS)
                    .mapColor(MapColor.ORANGE)
            )
    );

    public static final Block DARK_OAK_PANELLING = registerBlock("dark_oak_panelling",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .instrument(NoteBlockInstrument.BASS)
                    .mapColor(MapColor.BROWN)
            )
    );

    public static final Block MANGROVE_PANELLING = registerBlock("mangrove_panelling",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .instrument(NoteBlockInstrument.BASS)
                    .mapColor(MapColor.RED)
            )
    );

    public static final Block CHERRY_PANELLING = registerBlock("cherry_panelling",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.CHERRY_WOOD)
                    .burnable()
                    .instrument(NoteBlockInstrument.BASS)
                    .mapColor(MapColor.TERRACOTTA_WHITE)
            )
    );

    public static final Block BAMBOO_PANELLING = registerBlock("bamboo_panelling",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .instrument(NoteBlockInstrument.BASS)
                    .mapColor(MapColor.YELLOW)
            )
    );

    public static final Block PALE_PANELLING = registerBlock("pale_panelling",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .instrument(NoteBlockInstrument.BASS)
            )
    );

    public static final Block CRIMSON_PANELLING = registerBlock("crimson_panelling",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.NETHER_WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .mapColor(MapColor.DULL_PINK)
            )
    );

    public static final Block WARPED_PANELLING = registerBlock("warped_panelling",
            new Block(AbstractBlock.Settings.create()
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.NETHER_WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .mapColor(MapColor.DARK_AQUA)
            )
    );
    // END WOOD PANELLING BLOCKS

    // RUBY BLOCKS
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL).requiresTool().instrument(NoteBlockInstrument.HARP))
    );

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new Block(AbstractBlock.Settings.create().strength(3.0f, 3.0f).sounds(BlockSoundGroup.STONE).requiresTool().instrument(NoteBlockInstrument.BASEDRUM))
    );

    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new Block(AbstractBlock.Settings.create().strength(3.0f, 3.0f).sounds(BlockSoundGroup.STONE).requiresTool().instrument(NoteBlockInstrument.BASEDRUM))
    );
    // END RUBY BLOCKS

    // SAWMILL BLOCK
    public static final Block SAWMILL = registerBlock("sawmill",
            new SawmillBlock(AbstractBlock.Settings.copy(Blocks.STONECUTTER)));
    // END OF SAWMILL BLOCK

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ReVision.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ReVision.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        // Panelling blocks burn like planks (5, 20)
        registry.add(OAK_PANELLING, 5, 20);
        registry.add(SPRUCE_PANELLING, 5, 20);
        registry.add(BIRCH_PANELLING, 5, 20);
        registry.add(JUNGLE_PANELLING, 5, 20);
        registry.add(ACACIA_PANELLING, 5, 20);
        registry.add(DARK_OAK_PANELLING, 5, 20);
        registry.add(MANGROVE_PANELLING, 5, 20);
        registry.add(CHERRY_PANELLING, 5, 20);
        registry.add(BAMBOO_PANELLING, 5, 20);
        registry.add(PALE_PANELLING, 5, 20);
    }

    public static void registerModBlocks() {
        ReVision.LOGGER.info("Registering Mod Blocks for " + ReVision.MOD_ID);

        // WOOD PANELLING
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(OAK_PANELLING);
            entries.add(SPRUCE_PANELLING);
            entries.add(BIRCH_PANELLING);
            entries.add(JUNGLE_PANELLING);
            entries.add(ACACIA_PANELLING);
            entries.add(DARK_OAK_PANELLING);
            entries.add(MANGROVE_PANELLING);
            entries.add(CHERRY_PANELLING);
            entries.add(BAMBOO_PANELLING);
            entries.add(PALE_PANELLING);
            entries.add(CRIMSON_PANELLING);
            entries.add(WARPED_PANELLING);
        });

        // RUBY
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries ->
                entries.add(RUBY_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries ->
                entries.add(RUBY_ORE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries ->
                entries.add(DEEPSLATE_RUBY_ORE));

        // SAWMILL
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries ->
                entries.add(SAWMILL));
        // END OF SAWMILL
    }
}
