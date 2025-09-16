package net.arx.revision;

import net.arx.revision.block.ModBlocks;
import net.arx.revision.item.ModItemGroups;
import net.arx.revision.item.ModItems;
import net.arx.revision.recipe.ModRecipes;
import net.arx.revision.screen.ModScreenHandlers;
import net.arx.revision.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReVision implements ModInitializer {
    public static final String MOD_ID = "revision";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        System.out.println("[ReVision] Initializing mod");

        // Register content
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModBlocks.registerFlammableBlocks();

        // Register screens and recipes
        ModScreenHandlers.registerScreenHandlers();
        ModRecipes.registerRecipes();

        // Loot tables
        ModLootTableModifiers.modifyLootTables();

        System.out.println("[ReVision] Initialization complete");
    }
}
