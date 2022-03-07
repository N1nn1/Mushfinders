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
        this.add(BROWN_PILLUP);
        this.add(CRIMSON_PLUMP);
        this.add(DISHCAP);
        this.add(GOADSTOOL);
        this.add(HELBRIM);
        this.add(ROYAL_BEND);
        this.add(SULFUR_BOLETE);
        this.add(TOQUESWAB);
        this.add(WARPFUNNEL);

        this.add(POTTED_WHITE_PILLUP, block -> this.dropsFlowerPotWithPlant(WHITE_PILLUP));
        this.add(POTTED_BROWN_PILLUP, block -> this.dropsFlowerPotWithPlant(BROWN_PILLUP));
        this.add(POTTED_CRIMSON_PLUMP, block -> this.dropsFlowerPotWithPlant(CRIMSON_PLUMP));
        this.add(POTTED_DISHCAP, block -> this.dropsFlowerPotWithPlant(DISHCAP));
        this.add(POTTED_GOADSTOOL, block -> this.dropsFlowerPotWithPlant(GOADSTOOL));
        this.add(POTTED_HELBRIM, block -> this.dropsFlowerPotWithPlant(HELBRIM));
        this.add(POTTED_ROYAL_BEND, block -> this.dropsFlowerPotWithPlant(ROYAL_BEND));
        this.add(POTTED_SULFUR_BOLETE, block -> this.dropsFlowerPotWithPlant(SULFUR_BOLETE));
        this.add(POTTED_TOQUESWAB, block -> this.dropsFlowerPotWithPlant(TOQUESWAB));
        this.add(POTTED_WARPFUNNEL, block -> this.dropsFlowerPotWithPlant(WARPFUNNEL));
    }
}
