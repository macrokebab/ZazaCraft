package com.macrokebab.zazacraft.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.macrokebab.zazacraft.ZazacraftMod.MODID;
import static com.macrokebab.zazacraft.init.ModItems.ZAZA_HOJA;

public class ModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ZAZATAB = CREATIVE_MODE_TABS.register("zazatab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.zazacraft")).withTabsBefore(CreativeModeTabs.COMBAT).icon(() -> ZAZA_HOJA.get().getDefaultInstance()).displayItems((parameters, output) -> {
                        output.accept(ModBlocks.BONG.get().asItem());
                        output.accept(ModBlocks.DESTRUCTOR.get().asItem());
                        output.accept(ModBlocks.DESTRUCTOR_MAGICO.get().asItem());
                        output.accept(ModBlocks.BANDEJA.get().asItem());
                        output.accept(ModBlocks.TOBANIA_CULTIVO.get().asItem());
                        output.accept(ModBlocks.ZAZA_CULTIVO.get().asItem());
                        output.accept(ModItems.ZAZA_DSTR.get());
                        output.accept(ZAZA_HOJA.get());
                        output.accept(ModItems.ZAZA_POLVO.get());
                        output.accept(ModItems.ZAZA_ROCA.get());
                        output.accept(ModItems.ZAZA_TRIGO.get());
                        output.accept(ModItems.ZAZA_TOBANIA.get());
                        output.accept(ModItems.COGOLLO.get());
                        output.accept(ModItems.PAPELOTE.get());
                        output.accept(ModItems.SOSTENEDOR.get());
                        output.accept(ModItems.TOBANIA_HOJA.get());
                        output.accept(ModItems.VARITA_CANARIA.get());
                        output.accept(ModItems.VERDE.get());
                        output.accept(ModItems.PORRO.get());
                        output.accept(ModItems.RINONERA.get());
                        output.accept(ModItems.VARITA.get());
                        output.accept(ModItems.ELIXIR_ZAZA.get());
                        output.accept(ModItems.PASTEL.get());
                        output.accept(ModItems.TOBANIA_SEMILLAS.get());
                        output.accept(ModItems.ZAZA_SEMILLAS.get());

                    })
                    .build());
}
