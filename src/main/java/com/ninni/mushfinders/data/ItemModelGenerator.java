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
    }
}
