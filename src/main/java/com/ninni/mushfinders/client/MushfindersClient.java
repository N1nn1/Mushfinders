package com.ninni.mushfinders.client;

import com.ninni.mushfinders.block.MushfindersBlocks;
import com.ninni.mushfinders.client.gui.tooltip.ForagingBasketTooltipComponent;
import com.ninni.mushfinders.item.ForagingBasketTooltipData;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.TooltipComponentCallback;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class MushfindersClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap brlm = BlockRenderLayerMap.INSTANCE;
        brlm.putBlocks(RenderLayer.getCutout(),
            MushfindersBlocks.WHITE_PILLUP,
            MushfindersBlocks.POTTED_WHITE_PILLUP
        );

        TooltipComponentCallback.EVENT.register(data -> data instanceof ForagingBasketTooltipData fdata ? new ForagingBasketTooltipComponent(fdata) : null);
    }
}
