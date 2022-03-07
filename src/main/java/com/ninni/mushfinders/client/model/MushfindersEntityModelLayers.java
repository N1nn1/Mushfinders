package com.ninni.mushfinders.client.model;

import com.ninni.mushfinders.Mushfinders;
import com.ninni.mushfinders.client.model.item.ForagingBasketItemModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public interface MushfindersEntityModelLayers {
    EntityModelLayer FORAGING_BASKET = main("foraging_basket", ForagingBasketItemModel::getTexturedModelData);

    private static EntityModelLayer register(String id, String layer, EntityModelLayerRegistry.TexturedModelDataProvider provider) {
        EntityModelLayer ret = new EntityModelLayer(new Identifier(Mushfinders.MOD_ID, id), layer);
        EntityModelLayerRegistry.registerModelLayer(ret, provider);
        return ret;
    }

    private static EntityModelLayer main(String id, EntityModelLayerRegistry.TexturedModelDataProvider provider) {
        return register(id, "main", provider);
    }
}
