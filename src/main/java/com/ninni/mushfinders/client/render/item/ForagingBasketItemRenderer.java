package com.ninni.mushfinders.client.render.item;

import com.ninni.mushfinders.Mushfinders;
import com.ninni.mushfinders.client.model.MushfindersEntityModelLayers;
import com.ninni.mushfinders.client.model.item.ForagingBasketItemModel;
import com.ninni.mushfinders.item.ForagingBasketItem;
import com.ninni.mushfinders.item.MushfindersItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceReloadListenerKeys;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.registry.Registry;

import java.util.Collection;
import java.util.Collections;

@Environment(EnvType.CLIENT)
public class ForagingBasketItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer, SimpleSynchronousResourceReloadListener {
    public static final Identifier TEXTURE = new Identifier(Mushfinders.MOD_ID, "textures/entity/foraging_basket/foraging_basket.png");
    public static final Identifier TEXTURE_FILLED = new Identifier(Mushfinders.MOD_ID, "textures/entity/foraging_basket/foraging_basket_filled.png");

    protected ItemRenderer itemRenderer;
    protected ForagingBasketItemModel model;
    protected BakedModel modelInventory, modelInventoryFilled;

    public static final ModelIdentifier MODEL_INVENTORY = makeModel("inventory");
    public static final ModelIdentifier MODEL_INVENTORY_FILLED = makeModel("inventory_filled");

    @Override
    public Identifier getFabricId() {
        return new Identifier(Mushfinders.MOD_ID, "foraging_basket_renderer");
    }

    @Override
    public void reload(ResourceManager manager) {
        MinecraftClient client = MinecraftClient.getInstance();
        EntityModelLoader modelLoader = client.getEntityModelLoader();
        BakedModelManager models = client.getBakedModelManager();

        this.itemRenderer = client.getItemRenderer();
        this.model = new ForagingBasketItemModel(modelLoader.getModelPart(MushfindersEntityModelLayers.FORAGING_BASKET));
        this.modelInventory = models.getModel(MODEL_INVENTORY);
        this.modelInventoryFilled = models.getModel(MODEL_INVENTORY_FILLED);
    }

    @Override
    public Collection<Identifier> getFabricDependencies() {
        return Collections.singletonList(ResourceReloadListenerKeys.MODELS);
    }

    @Override
    public void render(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertices, int light, int overlay) {
        boolean filled = filled(stack);
        if (mode == ModelTransformation.Mode.GUI || mode == ModelTransformation.Mode.GROUND || mode == ModelTransformation.Mode.FIXED) {
            matrices.pop(); // cancel the previous transformation and pray that we are not breaking the state
            matrices.push();
            this.itemRenderer.renderItem(stack, mode, false, matrices, vertices, light, overlay, filled ? this.modelInventoryFilled : this.modelInventory);
        } else {
            matrices.pop();
            matrices.push();

            if (!mode.isFirstPerson()) {
                matrices.multiply(Vec3f.POSITIVE_X.getRadialQuaternion(-90.0F));
                matrices.translate(0.0F, -1.1F, -0.2F);
            } else {
                matrices.multiply(Vec3f.POSITIVE_X.getRadialQuaternion(180.0F));
                matrices.translate(0.2F, -1.1F, 0.0F);
            }

            Identifier texture = filled ? TEXTURE_FILLED : TEXTURE;
            VertexConsumer vertex = ItemRenderer.getDirectItemGlintConsumer(vertices, this.model.getLayer(texture), false, stack.hasGlint());
            this.model.render(matrices, vertex, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

            matrices.pop();
            matrices.push();
        }
    }

    public static boolean filled(ItemStack stack) {
        return stack.getItem() instanceof ForagingBasketItem item && item.getStorageOccupancy(stack) > 0;
    }

    public static float filled(ItemStack stack, ClientWorld world, LivingEntity entity, int seed) {
        return filled(stack) ? 1 : 0;
    }

    private static ModelIdentifier makeModel(String suffix) {
        Identifier id = Registry.ITEM.getId(MushfindersItems.FORAGING_BASKET);
        return new ModelIdentifier("%s_%s".formatted(id, suffix), "inventory");
    }
}
