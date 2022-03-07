package com.ninni.mushfinders.client;

import com.google.common.reflect.Reflection;
import com.ninni.mushfinders.Mushfinders;
import com.ninni.mushfinders.block.MushfindersBlocks;
import com.ninni.mushfinders.client.gui.tooltip.ForagingBasketTooltipComponent;
import com.ninni.mushfinders.client.model.MushfindersEntityModelLayers;
import com.ninni.mushfinders.client.render.item.ForagingBasketItemRenderer;
import com.ninni.mushfinders.item.ForagingBasketTooltipData;
import com.ninni.mushfinders.item.MushfindersItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.TooltipComponentCallback;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class MushfindersClient implements ClientModInitializer {

    @SuppressWarnings("UnstableApiUsage")
    @Override
    public void onInitializeClient() {
        Reflection.initialize(MushfindersEntityModelLayers.class);

        ForagingBasketItemRenderer foragingBasketItemRenderer = new ForagingBasketItemRenderer();
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> {
            out.accept(ForagingBasketItemRenderer.MODEL_INVENTORY);
            out.accept(ForagingBasketItemRenderer.MODEL_INVENTORY_FILLED);
        });
        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(foragingBasketItemRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(MushfindersItems.FORAGING_BASKET, foragingBasketItemRenderer);
        FabricModelPredicateProviderRegistry.register(MushfindersItems.FORAGING_BASKET, new Identifier(Mushfinders.MOD_ID, "foraging_basket_filled"), ForagingBasketItemRenderer::filled);

        BlockRenderLayerMap brlm = BlockRenderLayerMap.INSTANCE;
        brlm.putBlocks(RenderLayer.getCutout(),
            MushfindersBlocks.WHITE_PILLUP,
            MushfindersBlocks.POTTED_WHITE_PILLUP
        );

        TooltipComponentCallback.EVENT.register(data -> data instanceof ForagingBasketTooltipData fdata ? new ForagingBasketTooltipComponent(fdata) : null);
    }
}
