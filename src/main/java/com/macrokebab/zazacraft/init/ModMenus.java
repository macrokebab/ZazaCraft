package com.macrokebab.zazacraft.init;

import com.macrokebab.zazacraft.ZazacraftMod;
import com.macrokebab.zazacraft.world.inventory.DestructorguiMenu;
import com.macrokebab.zazacraft.world.inventory.RinoneraguiMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ZazacraftMod.MODID);
    public static final RegistryObject<MenuType<RinoneraguiMenu>> RINONERAGUI = REGISTRY.register("rinoneragui", () -> IForgeMenuType.create(RinoneraguiMenu::new));
    public static final RegistryObject<MenuType<DestructorguiMenu>> DESTRUCTOR_GUI = REGISTRY.register("destructor_gui", () -> IForgeMenuType.create(DestructorguiMenu::new));


}
