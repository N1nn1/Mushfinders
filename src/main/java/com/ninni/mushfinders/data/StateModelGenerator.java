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
        this.add(POTTED_WHITE_PILLUP, b -> this.simple(name(b), flowerPotCross(name(WHITE_PILLUP))));
    }
}
