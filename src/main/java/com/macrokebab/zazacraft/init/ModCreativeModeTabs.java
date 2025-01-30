package com.macrokebab.zazacraft.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.network.chat.Component;


import static com.macrokebab.zazacraft.ZazacraftMod.MODID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModCreativeModeTabs {

    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "zazacraft" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> ZAZATAB = CREATIVE_MODE_TABS.register("zazatab",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.zazacraft.zazatab")).icon(() -> new ItemStack(ModItems.ZAZA_HOJA.get())).displayItems((parameters, tabData) -> {
                tabData.accept(ModBlocks.BONG.get().asItem());
                tabData.accept(ModItems.CANARIA.get());
                tabData.accept(ModItems.COGOLLO.get());
                tabData.accept(ModItems.ELIXIR_ZAZA.get());
                tabData.accept(ModItems.PALITO.get());
                tabData.accept(ModItems.PALITO_LOCO.get());
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
            }).build());

}