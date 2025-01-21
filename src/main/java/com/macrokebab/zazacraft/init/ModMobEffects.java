package com.macrokebab.zazacraft.init;

import com.macrokebab.zazacraft.ZazacraftMod;
import com.macrokebab.zazacraft.potion.ZazaEfecto;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ZazacraftMod.MODID);

    public static final RegistryObject<MobEffect> ZAZAEFECTO = MOB_EFFECTS.register("zazaefecto", ZazaEfecto::new);
}