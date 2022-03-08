package com.ninni.mushfinders.data;

import com.ninni.mushfinders.tag.MushfindersItemTags;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.moddingplayground.frame.api.toymaker.v0.generator.tag.AbstractTagGenerator;
import net.moddingplayground.frame.api.toymaker.v0.generator.tag.TagEntryFactory;

import java.util.List;

import static com.ninni.mushfinders.block.MushfindersBlocks.*;
import static net.minecraft.block.Blocks.*;

public class ItemTagGenerator extends AbstractTagGenerator<Item> {
    public ItemTagGenerator(String modId) {
        super(modId, Registry.ITEM);
    }

    @Override
    public void generate() {
        this.add(MushfindersItemTags.FORAGEABLES,
            DEAD_BUSH,
            VINE,
            GRASS,
            FERN,
            WEEPING_VINES,
            TWISTING_VINES,
            NETHER_SPROUTS,
            WARPED_ROOTS,
            CRIMSON_ROOTS,
            HANGING_ROOTS,
            RED_MUSHROOM,
            BROWN_MUSHROOM,
            CRIMSON_FUNGUS,
            WARPED_FUNGUS,
            TALL_GRASS,
            LARGE_FERN
        ).add(ItemTags.SAPLINGS, ItemTags.SMALL_FLOWERS, ItemTags.TALL_FLOWERS);

        List.of(
            WHITE_PILLUP, BROWN_PILLUP, CRIMSON_PLUMP, DISHCAP,
            GOADSTOOL, HELBRIM, ROYAL_BEND, SULFUR_BOLETE, TOQUESWAB,
            WARPFUNNEL, AZURE_SKIRT, CATSBANE, DUKES_PLUMP, DUNGWILT,
            GNOME_HEAD, HEDGEKING, INKWEEP, MARITOLD, SALMONOKI,
            SNAGGLEHORN, STRIPED_LUMINO, SWINGBULB, THROATBINDER,
            WAX_STACK
        ).forEach(block -> {
            this.add(MushfindersItemTags.FORAGEABLES, block);
        });
    }

    public TagEntryFactory<Item> add(TagKey<Item> tag, ItemConvertible... items) {
        TagEntryFactory<Item> factory = this.getOrCreateFactory(tag);
        for (ItemConvertible item : items) factory.add(item.asItem());
        return factory;
    }
}
