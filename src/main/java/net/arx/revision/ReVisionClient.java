package net.arx.revision;

import net.arx.revision.screen.ModScreenHandlers;
import net.arx.revision.screen.SawmillScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ReVisionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Register Sawmill GUI
        HandledScreens.register(ModScreenHandlers.SAWMILL_SCREEN_HANDLER, SawmillScreen::new);

        System.out.println("[ReVision] Registered client screens");
    }
}
