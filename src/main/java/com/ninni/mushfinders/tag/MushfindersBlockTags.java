package com.ninni.mushfinders.tag;

import com.ninni.mushfinders.Mushfinders;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public interface MushfindersBlockTags {
    TagKey<Block> NO_PICKUP_FORAGEABLES = register("no_pickup_forageables");

    private static TagKey<Block> register(String id) {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(Mushfinders.MOD_ID, id));
    }
}
