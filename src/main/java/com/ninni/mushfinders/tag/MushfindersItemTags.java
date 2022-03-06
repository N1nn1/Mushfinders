package com.ninni.mushfinders.tag;

import com.ninni.mushfinders.Mushfinders;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public interface MushfindersItemTags {
    TagKey<Item> FORAGEABLES = register("forageables");

    private static TagKey<Item> register(String id) {
        return TagKey.of(Registry.ITEM_KEY, new Identifier(Mushfinders.MOD_ID, id));
    }
}
