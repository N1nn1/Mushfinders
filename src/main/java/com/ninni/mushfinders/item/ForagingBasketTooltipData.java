package com.ninni.mushfinders.item;

import net.minecraft.client.item.BundleTooltipData;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class ForagingBasketTooltipData extends BundleTooltipData {
    public ForagingBasketTooltipData(DefaultedList<ItemStack> inventory, int bundleOccupancy) {
        super(inventory, bundleOccupancy);
    }
}
