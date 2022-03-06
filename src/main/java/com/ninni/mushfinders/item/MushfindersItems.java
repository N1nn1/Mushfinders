package com.ninni.mushfinders.item;

import com.ninni.mushfinders.Mushfinders;
import com.ninni.mushfinders.block.MushfindersBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class MushfindersItems {
    public static final Item FORAGING_BASKET = register("foraging_basket", new ForagingBasketItem(new FabricItemSettings().maxCount(1).group(Mushfinders.ITEM_GROUP)));
    public static final Item WHITE_PILLUP = register("white_pillup", new BlockItem(MushfindersBlocks.WHITE_PILLUP, new FabricItemSettings().group(Mushfinders.ITEM_GROUP)));

    private static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Mushfinders.MOD_ID, id), item);
    }
}

