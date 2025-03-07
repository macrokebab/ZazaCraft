package com.macrokebab.zazacraft.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.network.chat.Component;


import static com.macrokebab.zazacraft.ZazacraftMod.MODID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModCreativeModeTabs {

    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "zazacraft" namespace
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> ZAZATAB = REGISTRY.register("zazatab",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.zazacraft.zazatab")).icon(() -> new ItemStack(ModItems.ZAZA_HOJA.get())).displayItems((parameters, tabData) -> {
                tabData.accept(ModBlocks.BONG.get().asItem());
                tabData.accept(ModItems.CANARIA.get());
                tabData.accept(ModItems.COGOLLO.get());
                tabData.accept(ModItems.ELIXIR_ZAZA.get());
                tabData.accept(ModItems.VERDE.get());
                tabData.accept(ModItems.PORRO.get());
                tabData.accept(ModItems.PAPELOTE.get());
                tabData.accept(ModItems.RINONERA.get());
                tabData.accept(ModItems.SOSTENEDOR.get());
                tabData.accept(ModBlocks.TOBANIA_CULTIVO.get().asItem());
                tabData.accept(ModItems.TOBANIA_HOJA.get());
                tabData.accept(ModItems.VARITA.get());
                tabData.accept(ModBlocks.ZAZA_CULTIVO.get().asItem());
                tabData.accept(ModItems.ZAZA_DSTR.get());
                tabData.accept(ModItems.ZAZA_HOJA.get());
                tabData.accept(ModItems.ZAZA_POLVO.get());
                tabData.accept(ModItems.ZAZA_ROCA.get());
                tabData.accept(ModBlocks.DESTRUCTOR.get().asItem());
                tabData.accept(ModBlocks.BANDEJA.get().asItem());
                tabData.accept(ModItems.POLI_SPAWN_EGG.get());
                tabData.accept(ModItems.ZAZATRIGO.get());
                tabData.accept(ModItems.ZAZATOBANIA.get());
                tabData.accept(ModBlocks.DESTRUCTOR_MAGICO.get().asItem());

            }).build());
}