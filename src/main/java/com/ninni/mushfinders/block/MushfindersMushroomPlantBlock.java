package com.ninni.mushfinders.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

import java.util.Random;

@SuppressWarnings("deprecation")
public class MushfindersMushroomPlantBlock extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5, 0, 5, 11, 10, 11);

    protected MushfindersMushroomPlantBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d offset = state.getModelOffset(world, pos);
        return SHAPE.offset(offset.x, offset.y, offset.z);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(25) == 0) {
            int hits = 5;

            for (BlockPos ipos : BlockPos.iterate(pos.add(-4, -1, -4), pos.add(4, 1, 4))) {
                if (world.getBlockState(ipos).isOf(this)) if (hits-- <= 0) return;
            }

            BlockPos opos = pos.add(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);

            for (int i = 0; i < 4; ++i) {
                if (world.isAir(opos) && this.canSpreadAt(world, opos)) pos = opos;
                opos = pos.add(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);
            }

            if (world.isAir(opos) && this.canSpreadAt(world, opos)) world.setBlockState(opos, state, 2);
        }
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOpaqueFullCube(world, pos);
    }

    public boolean canSpreadAt(WorldView world, BlockPos pos) {
        BlockPos dpos = pos.down();
        BlockState state = world.getBlockState(dpos);
        if (state.isIn(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return true;
        } else return world.getBaseLightLevel(pos, 0) < 13 && this.canPlantOnTop(state, world, dpos);
    }
}
