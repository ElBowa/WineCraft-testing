package com.elbowa.winecraft.block.custom;

import com.elbowa.winecraft.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class GrapevineBlock extends CropBlock {

    public GrapevineBlock(Properties p_49795_) {
        super(p_49795_);
    }

    private static final VoxelShape[] SHAPE_BY_AGE=
            new VoxelShape[]{Block.box(0,0,0,16,32,16),
                    Block.box(0,0,0,16,32,16),
                    Block.box(0,0,0,16,32,16),
                    Block.box(0,0,0,16,32,16)};




    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_BY_AGE[pState.getValue(this.getAgeProperty())];}
    @Override
    public int getMaxAge() {return 3;}
    @Override
    public IntegerProperty getAgeProperty() {return AGE;}
    @Override
    protected int getAge(BlockState pState) {return pState.getValue(this.getAgeProperty());}
    @Override
    public BlockState getStateForAge(int pAge){
        return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(pAge));}
    @Override
    public boolean isMaxAge(BlockState pState) {
        return pState.getValue(this.getAgeProperty()) >= this.getMaxAge();}

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
