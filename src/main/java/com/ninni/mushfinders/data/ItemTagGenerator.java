package com.ninni.mushfinders.data;

import com.ninni.mushfinders.block.MushfindersBlocks;
import com.ninni.mushfinders.tag.MushfindersItemTags;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.registry.Registry;
import net.moddingplayground.frame.api.toymaker.v0.generator.tag.AbstractTagGenerator;

public class ItemTagGenerator extends AbstractTagGenerator<Item> {
    public ItemTagGenerator(String modId) {
        super(modId, Registry.ITEM);
    }

    @Override
    public void generate() {
        this.add(MushfindersItemTags.FORAGEABLES,
            Items.DEAD_BUSH,
            Items.VINE,
            Items.GRASS,
            Items.FERN,
            Items.WEEPING_VINES,
            Items.TWISTING_VINES,
            Items.NETHER_SPROUTS,
            Items.WARPED_ROOTS,
            Items.CRIMSON_ROOTS,
            Items.HANGING_ROOTS,
            Items.RED_MUSHROOM,
            Items.BROWN_MUSHROOM,
            Items.CRIMSON_FUNGUS,
            Items.WARPED_FUNGUS,
            Items.TALL_GRASS,
            Items.LARGE_FERN,
            MushfindersBlocks.WHITE_PILLUP.asItem()
        ).add(ItemTags.SAPLINGS, ItemTags.SMALL_FLOWERS, ItemTags.TALL_FLOWERS);
    }
}
