package com.elbowa.winecraft.block.custom;

import com.elbowa.winecraft.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class GrapevineBlock extends CropBlock {

    public GrapevineBlock(Properties p_49795_) {
        super(p_49795_);
    }

    private static final VoxelShape GRAPEVINESHAPE= Block.box(0,0,0,16,32,16);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return GRAPEVINESHAPE;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.RED_GRAPE.get();
    }



    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(Blocks.GRASS_BLOCK)||
                pState.is(Blocks.DIRT)||
                pState.is(Blocks.ROOTED_DIRT);
    }
}
