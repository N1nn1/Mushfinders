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
    }
}
