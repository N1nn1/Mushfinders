package com.ninni.mushfinders.data;

import net.moddingplayground.frame.api.toymaker.v0.generator.loot.AbstractBlockLootTableGenerator;

import static com.ninni.mushfinders.block.MushfindersBlocks.*;

public class BlockLootTableGenerator extends AbstractBlockLootTableGenerator {
    public BlockLootTableGenerator(String modId) {
        super(modId);
    }

    @Override
    public void generate() {
        this.add(WHITE_PILLUP);
        this.add(POTTED_WHITE_PILLUP, block -> this.dropsFlowerPotWithPlant(WHITE_PILLUP));
    }
}
