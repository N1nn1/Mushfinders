package com.ninni.mushfinders.client;

import com.ninni.mushfinders.block.MushfindersBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class MushfindersClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap brlm = BlockRenderLayerMap.INSTANCE;
        brlm.putBlocks(
            RenderLayer.getCutout(),

            MushfindersBlocks.WHITE_PILLUP,
            MushfindersBlocks.POTTED_WHITE_PILLUP
        );
    }
}
