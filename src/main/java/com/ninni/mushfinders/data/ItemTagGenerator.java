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
            MushfindersBlocks.WHITE_PILLUP.asItem(),
            MushfindersBlocks.BROWN_PILLUP.asItem(),
            MushfindersBlocks.CRIMSON_PLUMP.asItem(),
            MushfindersBlocks.DISHCAP.asItem(),
            MushfindersBlocks.GOADSTOOL.asItem(),
            MushfindersBlocks.HELBRIM.asItem(),
            MushfindersBlocks.ROYAL_BEND.asItem(),
            MushfindersBlocks.SULFUR_BOLETE.asItem(),
            MushfindersBlocks.TOQUESWAB.asItem(),
            MushfindersBlocks.WARPFUNNEL.asItem(),
            MushfindersBlocks.AZURE_SKIRT.asItem(),
            MushfindersBlocks.CATSBANE.asItem(),
            MushfindersBlocks.DUKES_PLUMP.asItem(),
            MushfindersBlocks.DUNGWILT.asItem(),
            MushfindersBlocks.GNOME_HEAD.asItem(),
            MushfindersBlocks.HEDGEKING.asItem(),
            MushfindersBlocks.INKWEEP.asItem(),
            MushfindersBlocks.MARITOLD.asItem(),
            MushfindersBlocks.SALMONOKI.asItem(),
            MushfindersBlocks.SNAGGLEHORN.asItem(),
            MushfindersBlocks.STRIPED_LUMINO.asItem(),
            MushfindersBlocks.SWINGBULB.asItem(),
            MushfindersBlocks.THROATBINDER.asItem(),
            MushfindersBlocks.WAX_STACK.asItem()
        ).add(ItemTags.SAPLINGS, ItemTags.SMALL_FLOWERS, ItemTags.TALL_FLOWERS);
    }
}
