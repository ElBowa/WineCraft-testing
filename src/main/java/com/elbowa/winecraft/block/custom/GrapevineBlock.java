package com.elbowa.winecraft.block.custom;

import com.elbowa.winecraft.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class GrapevineBlock extends CropBlock {
    public GrapevineBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.RED_GRAPE.get();
    }
}
