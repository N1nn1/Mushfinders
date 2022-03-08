package com.ninni.mushfinders.data;

import net.moddingplayground.frame.api.toymaker.v0.generator.model.InheritingModelGen;
import net.moddingplayground.frame.api.toymaker.v0.generator.model.item.AbstractItemModelGenerator;

import java.util.List;

import static com.ninni.mushfinders.block.MushfindersBlocks.*;
import static com.ninni.mushfinders.item.MushfindersItems.*;

public class ItemModelGenerator extends AbstractItemModelGenerator {
    public ItemModelGenerator(String modId) {
        super(modId);
    }

    @Override
    public void generate() {
        this.add(name(FORAGING_BASKET, "%s_inventory"), InheritingModelGen.generated(name(FORAGING_BASKET, "item/%s")));
        this.add(name(FORAGING_BASKET, "%s_inventory_filled"), InheritingModelGen.generated(name(FORAGING_BASKET, "item/%s_filled")));

        List.of(
            WHITE_PILLUP, BROWN_PILLUP, CRIMSON_PLUMP, DISHCAP,
            GOADSTOOL, HELBRIM, ROYAL_BEND, SULFUR_BOLETE, TOQUESWAB,
            WARPFUNNEL, AZURE_SKIRT, CATSBANE, DUKES_PLUMP, DUNGWILT,
            GNOME_HEAD, HEDGEKING, INKWEEP, MARITOLD, SALMONOKI,
            SNAGGLEHORN, STRIPED_LUMINO, SWINGBULB, THROATBINDER,
            WAX_STACK
        ).forEach(this::generated);
    }
}
