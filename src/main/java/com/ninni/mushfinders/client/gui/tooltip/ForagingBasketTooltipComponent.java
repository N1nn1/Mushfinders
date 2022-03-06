package com.ninni.mushfinders.client.gui.tooltip;

import com.ninni.mushfinders.item.ForagingBasketItem;
import com.ninni.mushfinders.mixin.client.BundleTooltipComponentAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.tooltip.BundleTooltipComponent;
import net.minecraft.client.item.BundleTooltipData;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class ForagingBasketTooltipComponent extends BundleTooltipComponent {
    public ForagingBasketTooltipComponent(BundleTooltipData data) {
        super(data);
    }

    @Override
    public void drawItems(TextRenderer textRenderer, int x, int y, MatrixStack matrices, ItemRenderer itemRenderer, int z) {
        BundleTooltipComponentAccessor access = (BundleTooltipComponentAccessor) this;
        int columns = access.invokeGetColumns();
        int rows = access.invokeGetRows();
        boolean blocked = access.getOccupancy() >= ForagingBasketItem.MAX_ITEMS;
        int index = 0;
        for (int row = 0; row < rows; ++row) {
            for (int column = 0; column < columns; ++column) {
                int ix = x + column * 18 + 1;
                int iy = y + row * 20 + 1;
                access.invokeDrawSlot(ix, iy, index++, blocked, textRenderer, matrices, itemRenderer, z);
            }
        }
        access.invokeDrawOutline(x, y, columns, rows, matrices, z);
    }
}
