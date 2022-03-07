package com.ninni.mushfinders.client.render.item;

import com.ninni.mushfinders.Mushfinders;
import com.ninni.mushfinders.client.model.MushfindersEntityModelLayers;
import com.ninni.mushfinders.client.model.item.ForagingBasketItemModel;
import com.ninni.mushfinders.item.ForagingBasketItem;
import com.ninni.mushfinders.item.MushfindersItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
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
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.registry.Registry;

import java.util.Collection;
import java.util.Collections;

@Environment(EnvType.CLIENT)
public class ForagingBasketItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer, SimpleSynchronousResourceReloadListener {
    public static final ForagingBasketItemRenderer INSTANCE = new ForagingBasketItemRenderer();

    public static final Identifier TEXTURE = new Identifier(Mushfinders.MOD_ID, "textures/entity/foraging_basket/foraging_basket.png");
    public static final Identifier TEXTURE_FILLED = new Identifier(Mushfinders.MOD_ID, "textures/entity/foraging_basket/foraging_basket_filled.png");

    public static final ModelIdentifier MODEL_INVENTORY = makeModel("inventory");
    public static final ModelIdentifier MODEL_INVENTORY_FILLED = makeModel("inventory_filled");

    protected MinecraftClient client;
    protected BakedModel modelInventory, modelInventoryFilled;
    protected ForagingBasketItemModel model;

    public static void onInitializeClient() {
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> {
            out.accept(MODEL_INVENTORY);
            out.accept(MODEL_INVENTORY_FILLED);
        });
        FabricModelPredicateProviderRegistry.register(MushfindersItems.FORAGING_BASKET, new Identifier(Mushfinders.MOD_ID, "foraging_basket_filled"), ForagingBasketItemRenderer::filled);
        BuiltinItemRendererRegistry.INSTANCE.register(MushfindersItems.FORAGING_BASKET, INSTANCE);
        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(INSTANCE);
    }

    @Override
    public Identifier getFabricId() {
        return new Identifier(Mushfinders.MOD_ID, "foraging_basket_renderer");
    }

    @Override
    public void reload(ResourceManager manager) {
        this.client = MinecraftClient.getInstance();

        BakedModelManager models = this.client.getBakedModelManager();
        this.modelInventory = models.getModel(MODEL_INVENTORY);
        this.modelInventoryFilled = models.getModel(MODEL_INVENTORY_FILLED);

        EntityModelLoader modelLoader = this.client.getEntityModelLoader();
        this.model = new ForagingBasketItemModel(modelLoader.getModelPart(MushfindersEntityModelLayers.FORAGING_BASKET));
    }

    @Override
    public Collection<Identifier> getFabricDependencies() {
        return Collections.singletonList(ResourceReloadListenerKeys.MODELS);
    }

    @Override
    public void render(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertices, int light, int overlay) {
        boolean filled = filled(stack);
        if (mode == ModelTransformation.Mode.GUI || mode == ModelTransformation.Mode.GROUND || mode == ModelTransformation.Mode.FIXED) {
            matrices.pop();
            matrices.push();
            ItemRenderer itemRenderer = this.client.getItemRenderer();
            itemRenderer.renderItem(stack, mode, false, matrices, vertices, light, overlay, filled ? this.modelInventoryFilled : this.modelInventory);
        } else {
            matrices.pop();
            matrices.push();

            if (!mode.isFirstPerson()) {
                matrices.multiply(Vec3f.POSITIVE_X.getRadialQuaternion(-90.0F));
                matrices.translate(0.0F, -1.3F, -0.15F);
                matrices.scale(1.15F, 1.15F, 1.15F);
            } else if (mode == ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND){
                matrices.multiply(Vec3f.POSITIVE_X.getRadialQuaternion(198.25F));
                matrices.multiply(Vec3f.NEGATIVE_Y.getRadialQuaternion(0.75F));
                matrices.translate(0.0F, -1.3F, 0.1F);

            } else if (mode == ModelTransformation.Mode.FIRST_PERSON_LEFT_HAND) {
                matrices.multiply(Vec3f.POSITIVE_X.getRadialQuaternion(198.25F));
                matrices.multiply(Vec3f.POSITIVE_Y.getRadialQuaternion(0.75F));
                matrices.translate(0.0F, -1.3F, 0.1F);
            }

            Identifier texture = filled ? TEXTURE_FILLED : TEXTURE;
            VertexConsumer vertex = ItemRenderer.getDirectItemGlintConsumer(vertices, this.model.getLayer(texture), false, stack.hasGlint());
            this.model.render(matrices, vertex, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

            matrices.pop();
            matrices.push();
        }
    }

    public static ModelIdentifier makeModel(String suffix) {
        Identifier id = Registry.ITEM.getId(MushfindersItems.FORAGING_BASKET);
        return new ModelIdentifier("%s_%s".formatted(id, suffix), "inventory");
    }

    public static boolean filled(ItemStack stack) {
        return stack.getItem() instanceof ForagingBasketItem item && item.getStorageOccupancy(stack) > 0;
    }

    public static float filled(ItemStack stack, ClientWorld world, LivingEntity entity, int seed) {
        return filled(stack) ? 1 : 0;
    }
}
