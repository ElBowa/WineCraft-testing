package com.elbowa.winecraft.item;

import com.elbowa.winecraft.WineCraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WineCraft.MOD_ID);

public static final RegistryObject<Item> EM_BOT = ITEMS.register("em_bot",
        ()-> new Item(new Item.Properties().tab(CreativeModeTab.TAB_BREWING)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
