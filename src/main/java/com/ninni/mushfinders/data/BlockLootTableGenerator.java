package com.ninni.mushfinders.data;

import com.ninni.mushfinders.Mushfinders;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.moddingplayground.frame.api.toymaker.v0.generator.loot.AbstractBlockLootTableGenerator;

import java.util.List;

import static com.ninni.mushfinders.block.MushfindersBlocks.*;

public class BlockLootTableGenerator extends AbstractBlockLootTableGenerator {
    public BlockLootTableGenerator(String modId) {
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
        ).forEach(this::add);

        for (Block block : Registry.BLOCK) {
            Identifier id = Registry.BLOCK.getId(block);
            if (id.getNamespace().equals(Mushfinders.MOD_ID)) {
                if (block instanceof FlowerPotBlock) this.addPottedPlantDrop(block);
            }
        }
    }
}
