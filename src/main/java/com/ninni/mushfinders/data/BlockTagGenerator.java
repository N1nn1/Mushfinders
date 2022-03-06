package com.ninni.mushfinders.data;

import net.minecraft.block.Block;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.registry.Registry;
import net.moddingplayground.frame.api.toymaker.v0.generator.tag.AbstractTagGenerator;

import static com.ninni.mushfinders.block.MushfindersBlocks.*;

public class BlockTagGenerator extends AbstractTagGenerator<Block> {
    public BlockTagGenerator(String modId) {
        super(modId, Registry.BLOCK);
    }

    @Override
    public void generate() {
        this.add(BlockTags.FLOWER_POTS, POTTED_WHITE_PILLUP);
    }
}
