package com.ninni.mushfinders.data;

import com.ninni.mushfinders.tag.MushfindersBlockTags;
import net.minecraft.block.AbstractPlantPartBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FernBlock;
import net.minecraft.block.TallPlantBlock;
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

        for (Block block : Registry.BLOCK) {
            if (block instanceof TallPlantBlock || block instanceof AbstractPlantPartBlock || block instanceof FernBlock) this.add(MushfindersBlockTags.NO_PICKUP_FORAGEABLES, block);
        }
    }
}
