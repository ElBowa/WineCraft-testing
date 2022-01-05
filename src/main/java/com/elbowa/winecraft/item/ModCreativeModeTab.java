package com.elbowa.winecraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab WINECRAFT_TAB = new CreativeModeTab("winecraftModTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.WINE_BOT.get());
        }
    };
}
