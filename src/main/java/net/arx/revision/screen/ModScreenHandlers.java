package net.arx.revision.screen;

import net.arx.revision.ReVision;
import net.arx.revision.screen.custom.SawmillScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<SawmillScreenHandler> SAWMILL_SCREEN_HANDLER;

    public static void registerScreenHandlers() {
        SAWMILL_SCREEN_HANDLER = Registry.register(
                Registries.SCREEN_HANDLER,
                Identifier.of(ReVision.MOD_ID, "sawmill"),
                new ScreenHandlerType<>(
                        (syncId, inventory) -> new SawmillScreenHandler(syncId, inventory, ScreenHandlerContext.EMPTY),
                        FeatureFlags.VANILLA_FEATURES
                )
        );


        System.out.println("[ReVision] Registered sawmill screen handler");
    }
}
