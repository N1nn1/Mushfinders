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
        this.add(AZURE_SKIRT);
        this.add(CATSBANE);
        this.add(DUKES_PLUMP);
        this.add(DUNGWILT);
        this.add(GNOME_HEAD);
        this.add(HEDGEKING);
        this.add(INKWEEP);
        this.add(MARITOLD);
        this.add(SALMONOKI);
        this.add(SNAGGLEHORN);
        this.add(STRIPED_LUMINO);
        this.add(SWINGBULB);
        this.add(THROATBINDER);
        this.add(WAX_STACK);

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
        this.add(POTTED_AZURE_SKIRT, block -> this.dropsFlowerPotWithPlant(AZURE_SKIRT));
        this.add(POTTED_CATSBANE, block -> this.dropsFlowerPotWithPlant(CATSBANE));
        this.add(POTTED_DUKES_PLUMP, block -> this.dropsFlowerPotWithPlant(DUKES_PLUMP));
        this.add(POTTED_DUNGWILT, block -> this.dropsFlowerPotWithPlant(DUNGWILT));
        this.add(POTTED_GNOME_HEAD, block -> this.dropsFlowerPotWithPlant(GNOME_HEAD));
        this.add(POTTED_HEDGEKING, block -> this.dropsFlowerPotWithPlant(HEDGEKING));
        this.add(POTTED_INKWEEP, block -> this.dropsFlowerPotWithPlant(INKWEEP));
        this.add(POTTED_MARITOLD, block -> this.dropsFlowerPotWithPlant(MARITOLD));
        this.add(POTTED_SALMONOKI, block -> this.dropsFlowerPotWithPlant(SALMONOKI));
        this.add(POTTED_SNAGGLEHORN, block -> this.dropsFlowerPotWithPlant(SNAGGLEHORN));
        this.add(POTTED_STRIPED_LUMINO, block -> this.dropsFlowerPotWithPlant(STRIPED_LUMINO));
        this.add(POTTED_SWINGBULB, block -> this.dropsFlowerPotWithPlant(SWINGBULB));
        this.add(POTTED_THROATBINDER, block -> this.dropsFlowerPotWithPlant(THROATBINDER));
        this.add(POTTED_WAX_STACK, block -> this.dropsFlowerPotWithPlant(WAX_STACK));
    }
}
