package com.ninni.mushfinders.data;

import net.moddingplayground.frame.api.toymaker.v0.generator.model.block.AbstractStateModelGenerator;

import static com.ninni.mushfinders.block.MushfindersBlocks.*;
import static net.moddingplayground.frame.api.toymaker.v0.generator.model.InheritingModelGen.*;

public class StateModelGenerator extends AbstractStateModelGenerator {
    public StateModelGenerator(String modId) {
        super(modId);
    }

    @Override
    public void generate() {
        this.add(WHITE_PILLUP, b -> this.simple(name(b), cross(name(b))));
        this.add(BROWN_PILLUP, b -> this.simple(name(b), cross(name(b))));
        this.add(CRIMSON_PLUMP, b -> this.simple(name(b), cross(name(b))));
        this.add(DISHCAP, b -> this.simple(name(b), cross(name(b))));
        this.add(GOADSTOOL, b -> this.simple(name(b), cross(name(b))));
        this.add(HELBRIM, b -> this.simple(name(b), cross(name(b))));
        this.add(ROYAL_BEND, b -> this.simple(name(b), cross(name(b))));
        this.add(SULFUR_BOLETE, b -> this.simple(name(b), cross(name(b))));
        this.add(TOQUESWAB, b -> this.simple(name(b), cross(name(b))));
        this.add(WARPFUNNEL, b -> this.simple(name(b), cross(name(b))));
        this.add(AZURE_SKIRT, b -> this.simple(name(b), cross(name(b))));
        this.add(CATSBANE, b -> this.simple(name(b), cross(name(b))));
        this.add(DUKES_PLUMP, b -> this.simple(name(b), cross(name(b))));
        this.add(DUNGWILT, b -> this.simple(name(b), cross(name(b))));
        this.add(GNOME_HEAD, b -> this.simple(name(b), cross(name(b))));
        this.add(HEDGEKING, b -> this.simple(name(b), cross(name(b))));
        this.add(INKWEEP, b -> this.simple(name(b), cross(name(b))));
        this.add(MARITOLD, b -> this.simple(name(b), cross(name(b))));
        this.add(SALMONOKI, b -> this.simple(name(b), cross(name(b))));
        this.add(SNAGGLEHORN, b -> this.simple(name(b), cross(name(b))));
        this.add(STRIPED_LUMINO, b -> this.simple(name(b), cross(name(b))));
        this.add(SWINGBULB, b -> this.simple(name(b), cross(name(b))));
        this.add(THROATBINDER, b -> this.simple(name(b), cross(name(b))));
        this.add(WAX_STACK, b -> this.simple(name(b), cross(name(b))));

        this.add(POTTED_WHITE_PILLUP, b -> this.simple(name(b), flowerPotCross(name(WHITE_PILLUP))));
        this.add(POTTED_BROWN_PILLUP, b -> this.simple(name(b), flowerPotCross(name(BROWN_PILLUP))));
        this.add(POTTED_CRIMSON_PLUMP, b -> this.simple(name(b), flowerPotCross(name(CRIMSON_PLUMP))));
        this.add(POTTED_DISHCAP, b -> this.simple(name(b), flowerPotCross(name(DISHCAP))));
        this.add(POTTED_GOADSTOOL, b -> this.simple(name(b), flowerPotCross(name(GOADSTOOL))));
        this.add(POTTED_HELBRIM, b -> this.simple(name(b), flowerPotCross(name(POTTED_HELBRIM))));
        this.add(POTTED_ROYAL_BEND, b -> this.simple(name(b), flowerPotCross(name(ROYAL_BEND))));
        this.add(POTTED_SULFUR_BOLETE, b -> this.simple(name(b), flowerPotCross(name(SULFUR_BOLETE))));
        this.add(POTTED_TOQUESWAB, b -> this.simple(name(b), flowerPotCross(name(TOQUESWAB))));
        this.add(POTTED_WARPFUNNEL, b -> this.simple(name(b), flowerPotCross(name(WARPFUNNEL))));
        this.add(POTTED_AZURE_SKIRT, b -> this.simple(name(b), flowerPotCross(name(AZURE_SKIRT))));
        this.add(POTTED_CATSBANE, b -> this.simple(name(b), flowerPotCross(name(CATSBANE))));
        this.add(POTTED_DUKES_PLUMP, b -> this.simple(name(b), flowerPotCross(name(DUKES_PLUMP))));
        this.add(POTTED_DUNGWILT, b -> this.simple(name(b), flowerPotCross(name(DUNGWILT))));
        this.add(POTTED_GNOME_HEAD , b -> this.simple(name(b), flowerPotCross(name(GNOME_HEAD))));
        this.add(POTTED_HEDGEKING, b -> this.simple(name(b), flowerPotCross(name(HEDGEKING))));
        this.add(POTTED_INKWEEP, b -> this.simple(name(b), flowerPotCross(name(INKWEEP))));
        this.add(POTTED_MARITOLD, b -> this.simple(name(b), flowerPotCross(name(MARITOLD))));
        this.add(POTTED_SALMONOKI, b -> this.simple(name(b), flowerPotCross(name(SALMONOKI))));
        this.add(POTTED_SNAGGLEHORN, b -> this.simple(name(b), flowerPotCross(name(SNAGGLEHORN))));
        this.add(POTTED_STRIPED_LUMINO, b -> this.simple(name(b), flowerPotCross(name(STRIPED_LUMINO))));
        this.add(POTTED_SWINGBULB, b -> this.simple(name(b), flowerPotCross(name(SWINGBULB))));
        this.add(POTTED_THROATBINDER, b -> this.simple(name(b), flowerPotCross(name(THROATBINDER))));
        this.add(POTTED_WAX_STACK, b -> this.simple(name(b), flowerPotCross(name(WAX_STACK))));
    }
}
