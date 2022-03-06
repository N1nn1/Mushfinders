package com.ninni.mushfinders.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.tooltip.BundleTooltipComponent;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Environment(EnvType.CLIENT)
@Mixin(BundleTooltipComponent.class)
public interface BundleTooltipComponentAccessor {
    @Accessor int getOccupancy();
    @Invoker void invokeDrawSlot(int x, int y, int index, boolean shouldBlock, TextRenderer textRenderer, MatrixStack matrices, ItemRenderer itemRenderer, int z);
    @Invoker void invokeDrawOutline(int x, int y, int columns, int rows, MatrixStack matrices, int z);
    @Invoker int invokeGetColumns();
    @Invoker int invokeGetRows();
}
