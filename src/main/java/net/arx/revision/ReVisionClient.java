package net.arx.revision;

import net.arx.revision.block.ModBlocks;
import net.arx.revision.screen.ModScreenHandlers;
import net.arx.revision.screen.custom.SawmillScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class ReVisionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAWMILL, RenderLayer.getCutout());
        HandledScreens.register(ModScreenHandlers.SAWMILL_SCREEN_HANDLER, SawmillScreen::new);
        System.out.println("[ReVision] Registered client screens");
    }
}
