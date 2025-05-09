package com.macrokebab.zazacraft.init;

import com.macrokebab.zazacraft.client.gui.DestructorguiScreen;
import com.macrokebab.zazacraft.client.gui.RinoneraguiScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModScreens {

    @SubscribeEvent
    public static void clientLoad(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(ModMenus.RINONERAGUI.get(), RinoneraguiScreen::new);
            MenuScreens.register(ModMenus.DESTRUCTOR_GUI.get(), DestructorguiScreen::new);
        });
    }
}