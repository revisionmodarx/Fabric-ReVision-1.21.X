package net.arx.revision.item;

import net.arx.revision.ReVision;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));

    public static final Item AMULET = registerItem("amulet", new Item(new Item.Settings()));

    public static final Item MANGO = registerItem("mango", new Item(new Item.Settings().food(ModFoodComponents.MANGO)));
    public static final Item GOLDEN_MANGO = registerItem("golden_mango", new Item(new Item.Settings().food(ModFoodComponents.GOLDEN_MANGO)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ReVision.MOD_ID, name), item);
    }

    public static void registerModItems(){
        ReVision.LOGGER.info("Registering Mod Items for " + ReVision.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(RUBY);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(AMULET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(MANGO);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(GOLDEN_MANGO);
        });
    }
}