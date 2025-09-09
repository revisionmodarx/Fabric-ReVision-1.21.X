package net.arx.revision;

import net.arx.revision.block.ModBlocks;
import net.arx.revision.item.ModItemGroups;
import net.arx.revision.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReVision implements ModInitializer {
	public static final String MOD_ID = "revision";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModBlocks.registerFlammableBlocks(); // 🔥 make panelling burnable
	}
}