package com.ninni.mushfinders.data;

import com.ninni.mushfinders.block.MushfindersBlocks;
import net.moddingplayground.frame.api.toymaker.v0.generator.model.item.AbstractItemModelGenerator;

public class ItemModelGenerator extends AbstractItemModelGenerator {
    public ItemModelGenerator(String modId) {
        super(modId);
    }

    @Override
    public void generate() {
        this.generated(MushfindersBlocks.WHITE_PILLUP);
    }
}
