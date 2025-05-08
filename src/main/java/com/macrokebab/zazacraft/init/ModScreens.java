package com.macrokebab.zazacraft.init;

import com.macrokebab.zazacraft.client.gui.GuidestructorScreen;
import com.macrokebab.zazacraft.client.gui.GuirinoneraScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModScreens {
    @SubscribeEvent
    public static void clientLoad(RegisterMenuScreensEvent event) {
        event.register(ModMenus.GUI_RINONERA.get(), GuirinoneraScreen::new);
        event.register(ModMenus.GUIDESTRUCTOR.get(), GuidestructorScreen::new);
    }
}
