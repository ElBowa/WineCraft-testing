package com.elbowa.winecraft.block;

import com.elbowa.winecraft.WineCraft;
//import com.elbowa.winecraft.block.custom.GrapevineBlock;
import com.elbowa.winecraft.block.custom.GrapevineBlock;
import com.elbowa.winecraft.item.ModCreativeModeTab;
import com.elbowa.winecraft.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, WineCraft.MOD_ID);

    public static final RegistryObject<Block> BUILD_BRICK = registerBlock("build_brick",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .explosionResistance(6f)
            .destroyTime(12f)
            .sound(SoundType.AMETHYST_CLUSTER)));



    //La vite
    public static final RegistryObject<Block>  GRAPEVINE= BLOCKS.register("grapevine",
            ()-> new GrapevineBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)
            .sound(SoundType.SWEET_BERRY_BUSH).jumpFactor((float) 0.6).instabreak()));

    public static final RegistryObject<Block> GLASSBOT= BLOCKS.register("glassbot",
            ()-> new Block(BlockBehaviour.Properties.of(Material.GLASS)
                    .destroyTime(1f)
                    .sound(SoundType.GLASS)));


    // i Register
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        RegistryBlockItem(name, toReturn);
        return  toReturn;
    }

    private static <T extends Block> void RegistryBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModeTab.WINECRAFT_TAB)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
