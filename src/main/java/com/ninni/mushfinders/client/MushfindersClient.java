package com.ninni.mushfinders.client;

import com.google.common.reflect.Reflection;
import com.ninni.mushfinders.block.MushfindersBlocks;
import com.ninni.mushfinders.client.gui.tooltip.ForagingBasketTooltipComponent;
import com.ninni.mushfinders.client.model.MushfindersEntityModelLayers;
import com.ninni.mushfinders.client.render.item.ForagingBasketItemRenderer;
import com.ninni.mushfinders.item.ForagingBasketTooltipData;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.TooltipComponentCallback;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class MushfindersClient implements ClientModInitializer {

    @SuppressWarnings("UnstableApiUsage")
    @Override
    public void onInitializeClient() {
        Reflection.initialize(MushfindersEntityModelLayers.class);

        ForagingBasketItemRenderer.onInitializeClient();
        TooltipComponentCallback.EVENT.register(data -> data instanceof ForagingBasketTooltipData fdata ? new ForagingBasketTooltipComponent(fdata) : null);

        BlockRenderLayerMap brlm = BlockRenderLayerMap.INSTANCE;
        brlm.putBlocks(RenderLayer.getCutout(),
            MushfindersBlocks.WHITE_PILLUP,
            MushfindersBlocks.BROWN_PILLUP,
            MushfindersBlocks.CRIMSON_PLUMP,
            MushfindersBlocks.DISHCAP,
            MushfindersBlocks.GOADSTOOL,
            MushfindersBlocks.HELBRIM,
            MushfindersBlocks.ROYAL_BEND,
            MushfindersBlocks.SULFUR_BOLETE,
            MushfindersBlocks.TOQUESWAB,
            MushfindersBlocks.WARPFUNNEL,
            MushfindersBlocks.AZURE_SKIRT,
            MushfindersBlocks.CATSBANE,
            MushfindersBlocks.DUKES_PLUMP,
            MushfindersBlocks.DUNGWILT,
            MushfindersBlocks.GNOME_HEAD,
            MushfindersBlocks.HEDGEKING,
            MushfindersBlocks.INKWEEP,
            MushfindersBlocks.MARITOLD ,
            MushfindersBlocks.SALMONOKI,
            MushfindersBlocks.SNAGGLEHORN,
            MushfindersBlocks.STRIPED_LUMINO,
            MushfindersBlocks.SWINGBULB,
            MushfindersBlocks.THROATBINDER,
            MushfindersBlocks.WAX_STACK,

            MushfindersBlocks.POTTED_WHITE_PILLUP,
            MushfindersBlocks.POTTED_BROWN_PILLUP,
            MushfindersBlocks.POTTED_CRIMSON_PLUMP,
            MushfindersBlocks.POTTED_DISHCAP,
            MushfindersBlocks.POTTED_GOADSTOOL,
            MushfindersBlocks.POTTED_HELBRIM,
            MushfindersBlocks.POTTED_ROYAL_BEND,
            MushfindersBlocks.POTTED_SULFUR_BOLETE,
            MushfindersBlocks.POTTED_TOQUESWAB,
            MushfindersBlocks.POTTED_WARPFUNNEL,
            MushfindersBlocks.POTTED_AZURE_SKIRT,
            MushfindersBlocks.POTTED_CATSBANE,
            MushfindersBlocks.POTTED_DUKES_PLUMP,
            MushfindersBlocks.POTTED_DUNGWILT,
            MushfindersBlocks.POTTED_GNOME_HEAD,
            MushfindersBlocks.POTTED_HEDGEKING,
            MushfindersBlocks.POTTED_INKWEEP,
            MushfindersBlocks.POTTED_MARITOLD ,
            MushfindersBlocks.POTTED_SALMONOKI,
            MushfindersBlocks.POTTED_SNAGGLEHORN,
            MushfindersBlocks.POTTED_STRIPED_LUMINO,
            MushfindersBlocks.POTTED_SWINGBULB,
            MushfindersBlocks.POTTED_THROATBINDER,
            MushfindersBlocks.POTTED_WAX_STACK
        );
    }
}
