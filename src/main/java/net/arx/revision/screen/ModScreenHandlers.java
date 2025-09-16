package net.arx.revision.screen;

import net.arx.revision.ReVision;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.resource.featuretoggle.FeatureFlags;

public class ModScreenHandlers {
    public static final ScreenHandlerType<SawmillScreenHandler> SAWMILL_SCREEN_HANDLER =
            Registry.register(
                    Registries.SCREEN_HANDLER,
                    Identifier.of(ReVision.MOD_ID, "sawmill"),
                    new ScreenHandlerType<>(SawmillScreenHandler::new, FeatureFlags.VANILLA_FEATURES)
            );

    public static void registerScreenHandlers() {
        ReVision.LOGGER.info("Registering Screen Handlers for " + ReVision.MOD_ID);
    }
}
