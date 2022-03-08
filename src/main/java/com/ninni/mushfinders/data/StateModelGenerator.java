package com.ninni.mushfinders.data;

import com.ninni.mushfinders.Mushfinders;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.moddingplayground.frame.api.toymaker.v0.generator.model.block.AbstractStateModelGenerator;

import java.util.List;

import static com.ninni.mushfinders.block.MushfindersBlocks.*;
import static net.moddingplayground.frame.api.toymaker.v0.generator.model.InheritingModelGen.*;

public class StateModelGenerator extends AbstractStateModelGenerator {
    public StateModelGenerator(String modId) {
        super(modId);
    }

    @Override
    public void generate() {
        List.of(
            WHITE_PILLUP, BROWN_PILLUP, CRIMSON_PLUMP, DISHCAP,
            GOADSTOOL, HELBRIM, ROYAL_BEND, SULFUR_BOLETE, TOQUESWAB,
            WARPFUNNEL, AZURE_SKIRT, CATSBANE, DUKES_PLUMP, DUNGWILT,
            GNOME_HEAD, HEDGEKING, INKWEEP, MARITOLD, SALMONOKI,
            SNAGGLEHORN, STRIPED_LUMINO, SWINGBULB, THROATBINDER,
            WAX_STACK
        ).forEach(block -> this.add(block, b -> simple(name(b), cross(name(b)))));

        List<Block> pottedTextures = List.of(POTTED_HELBRIM);
        for (Block block : Registry.BLOCK) {
            Identifier id = Registry.BLOCK.getId(block);
            if (id.getNamespace().equals(Mushfinders.MOD_ID)) {
                if (block instanceof FlowerPotBlock pot) {
                    Block flower = pot.getContent();
                    this.add(pot, b -> simple(name(b), flowerPotCross(name(pottedTextures.contains(block) ? b : flower))));
                }
            }
        }
    }
}
