package net.arx.revision.block;

import net.arx.revision.ReVision;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //                      ----- WOOD PANELLING BLOCKS -----
    public static final Block OAK_PANELLING = registerBlock("oak_panelling",
            new Block(AbstractBlock.Settings.create().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable().instrument(NoteBlockInstrument.BASS)
            )
    );

    public static final Block SPRUCE_PANELLING = registerBlock("spruce_panelling",
            new Block(AbstractBlock.Settings.create().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable().instrument(NoteBlockInstrument.BASS)
            )
    );

    public static final Block BIRCH_PANELLING = registerBlock("birch_panelling",
            new Block(AbstractBlock.Settings.create().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable().instrument(NoteBlockInstrument.BASS)
            )
    );

    public static final Block JUNGLE_PANELLING = registerBlock("jungle_panelling",
            new Block(AbstractBlock.Settings.create().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable().instrument(NoteBlockInstrument.BASS)
            )
    );

    public static final Block ACACIA_PANELLING = registerBlock("acacia_panelling",
            new Block(AbstractBlock.Settings.create().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable().instrument(NoteBlockInstrument.BASS)
            )
    );

    public static final Block DARK_OAK_PANELLING = registerBlock("dark_oak_panelling",
            new Block(AbstractBlock.Settings.create().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable().instrument(NoteBlockInstrument.BASS)
            )
    );

    public static final Block MANGROVE_PANELLING = registerBlock("mangrove_panelling",
            new Block(AbstractBlock.Settings.create().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable().instrument(NoteBlockInstrument.BASS)
            )
    );

    public static final Block CHERRY_PANELLING = registerBlock("cherry_panelling",
            new Block(AbstractBlock.Settings.create().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable().instrument(NoteBlockInstrument.BASS)
            )
    );

    public static final Block BAMBOO_PANELLING = registerBlock("bamboo_panelling",
            new Block(AbstractBlock.Settings.create().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable().instrument(NoteBlockInstrument.BASS)
            )
    );

    public static final Block PALE_OAK_PANELLING = registerBlock("pale_panelling",
            new Block(AbstractBlock.Settings.create().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable().instrument(NoteBlockInstrument.BASS)
            )
    );

    public static final Block CRIMSON_PANELLING = registerBlock("crimson_panelling",
            new Block(AbstractBlock.Settings.create().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).instrument(NoteBlockInstrument.BASS)
            )
    );

    public static final Block WARPED_PANELLING = registerBlock("warped_panelling",
            new Block(AbstractBlock.Settings.create().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).instrument(NoteBlockInstrument.BASS)
            )
    );
   //                       ----- END OF WOOD PANELLING BLOCKS -----

    //                              ----- RUBY BLOCKS -----
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL).requiresTool().instrument(NoteBlockInstrument.HARP)
            )
    );

    //                          ----- END OF RUBY BLOCKS -----

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
        registry.add(PALE_OAK_PANELLING, 5, 20);
    }


    public static void registerModBlocks() {
        ReVision.LOGGER.info("Registering Mod Blocks for" + ReVision.MOD_ID);

        //                      ----- WOOD PANELLING BLOCKS -----
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(OAK_PANELLING);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(SPRUCE_PANELLING);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(BIRCH_PANELLING);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(JUNGLE_PANELLING);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ACACIA_PANELLING);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(DARK_OAK_PANELLING);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(MANGROVE_PANELLING);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(CHERRY_PANELLING);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(BAMBOO_PANELLING);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(PALE_OAK_PANELLING);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(CRIMSON_PANELLING);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(WARPED_PANELLING);
        });
        //                       -----END OF WOOD PANELLING BLOCKS -----

        //                      ----- WOOD PANELLING BLOCKS -----
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(RUBY_BLOCK);
        });
        //                       -----END OF WOOD PANELLING BLOCKS -----
    }
}
