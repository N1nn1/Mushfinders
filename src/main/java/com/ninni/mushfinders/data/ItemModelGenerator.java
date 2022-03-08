package com.ninni.mushfinders.data;

import net.moddingplayground.frame.api.toymaker.v0.generator.model.InheritingModelGen;
import net.moddingplayground.frame.api.toymaker.v0.generator.model.item.AbstractItemModelGenerator;

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

        this.generated(WHITE_PILLUP);
        this.generated(BROWN_PILLUP);
        this.generated(CRIMSON_PLUMP);
        this.generated(DISHCAP);
        this.generated(GOADSTOOL);
        this.generated(HELBRIM);
        this.generated(ROYAL_BEND);
        this.generated(SULFUR_BOLETE);
        this.generated(TOQUESWAB);
        this.generated(WARPFUNNEL);
        this.generated(AZURE_SKIRT);
        this.generated(CATSBANE);
        this.generated(DUKES_PLUMP);
        this.generated(DUNGWILT);
        this.generated(GNOME_HEAD);
        this.generated(HEDGEKING);
        this.generated(INKWEEP);
        this.generated(MARITOLD);
        this.generated(SALMONOKI);
        this.generated(SNAGGLEHORN);
        this.generated(STRIPED_LUMINO);
        this.generated(SWINGBULB);
        this.generated(THROATBINDER);
        this.generated(WAX_STACK);
    }
}
