package com.ninni.mushfinders.client.model.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

/**
 * Represents the model of a foraging basket.
 *
 * <div class="fabric">
 * <table border=1>
 * <caption>Model parts of this model</caption>
 * <tr>
 *   <th>Part Name</th><th>Parent</th><th>Corresponding Field</th>
 * </tr>
 * <tr>
 *   <td>{@value BASKET}</td><td>{@linkplain #root Root part}</td><td>{@link #basket}</td>
 * </tr>
 * </table>
 * </div>
 */
@Environment(EnvType.CLIENT)
public class ForagingBasketItemModel extends Model {
    public static final String BASKET = "basket";

    private final ModelPart root;
    private final ModelPart basket;

    public ForagingBasketItemModel(ModelPart root) {
        super(RenderLayer::getEntityCutoutNoCull);

        this.root = root;
        this.basket = root.getChild(BASKET);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        ModelPartData root = data.getRoot();

        ModelPartData basket = root.addChild(
            BASKET,
            ModelPartBuilder.create()
                            .uv(0, 0)
                            .mirrored(false)
                            .cuboid(-3.0F, 4.0F, -4.0F, 6.0F, 4.0F, 8.0F)
                            .uv(0, 12)
                            .mirrored(true)
                            .cuboid(-1.0F, 1.0F, -4.0F, 2.0F, 1.0F, 8.0F)
                            .uv(0, 21)
                            .mirrored(false)
                            .cuboid(-1.0F, 2.0F, -4.0F, 2.0F, 2.0F, 1.0F)
                            .uv(0, 24)
                            .mirrored(false)
                            .cuboid(-1.0F, 2.0F, 3.0F, 2.0F, 2.0F, 1.0F),
            ModelTransform.pivot(0.0F, 16.0F, 0.0F)
        );

        return TexturedModelData.of(data, 32, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
