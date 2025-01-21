package com.macrokebab.zazacraft.init;

import com.macrokebab.zazacraft.ZazacraftMod;
import com.macrokebab.zazacraft.world.inventory.RinoneraguiMenu;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ZazacraftMod.MODID);
    public static final RegistryObject<MenuType<RinoneraguiMenu>> RINONERAGUI = MENU_TYPES.register("rinoneragui", () -> IForgeMenuType.create(RinoneraguiMenu::new));
}
