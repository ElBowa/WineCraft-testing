package com.elbowa.winecraft.item;

import com.elbowa.winecraft.WineCraft;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WineCraft.MOD_ID);

//Registra la bottiglia vuota
public static final RegistryObject<Item> EM_BOT = ITEMS.register("em_bot",
        ()-> new Item(new Item.Properties()
                .tab(ModCreativeModeTab.WINECRAFT_TAB)
                .rarity(Rarity.COMMON)
                .stacksTo(4)));

//Registra il grappolo d'uva rossa
public static final RegistryObject<Item> RED_GRAPE = ITEMS.register("red_grape",
        ()-> new Item((new Item.Properties()
        .tab(ModCreativeModeTab.WINECRAFT_TAB)
        .stacksTo(64)
        .rarity(Rarity.COMMON)
        .food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.5f)
                .fast()
                .build()))));

//Registra la bottiglia di vino rosso
public static final RegistryObject<Item> WINE_BOT = ITEMS.register("wine_bot",
        ()-> new Item(new Item.Properties().rarity(Rarity.COMMON).stacksTo(4).tab(ModCreativeModeTab.WINECRAFT_TAB).food(
                new FoodProperties.Builder()
                        .effect(()-> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,70,2), 100)
                        .effect(()-> new MobEffectInstance(MobEffects.CONFUSION,50,3), 100)
                        .saturationMod(0.3f)
                        .nutrition(0)
                        .build())));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}