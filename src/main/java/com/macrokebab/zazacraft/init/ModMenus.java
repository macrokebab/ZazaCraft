package com.macrokebab.zazacraft.init;

import com.macrokebab.zazacraft.ZazacraftMod;
import com.macrokebab.zazacraft.world.inventory.GuidestructorMenu;
import com.macrokebab.zazacraft.world.inventory.GuirinoneraMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, ZazacraftMod.MODID);
    public static final DeferredHolder<MenuType<?>, MenuType<GuirinoneraMenu>> GUI_RINONERA = REGISTRY.register("gui_rinonera", () -> IMenuTypeExtension.create(GuirinoneraMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<GuidestructorMenu>> GUIDESTRUCTOR = REGISTRY.register("guidestructor", () -> IMenuTypeExtension.create(GuidestructorMenu::new));
}