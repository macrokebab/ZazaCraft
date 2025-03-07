package com.macrokebab.zazacraft.init;

import com.macrokebab.zazacraft.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.macrokebab.zazacraft.ZazacraftMod.MODID;

public class ModBlocks {
    // Create a Deferred Register to hold BLOCKS which will all be registered under the "zazacraft" namespace
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    // Registro de bloques
    public static final RegistryObject<Block> TOBANIA_CULTIVO = REGISTRY.register("tobania_cultivo",
            () -> new TobaniaCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> ZAZA_CULTIVO = REGISTRY.register("zaza_cultivo",
            () -> new ZazaCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> WILD_TOBANIA = REGISTRY.register("tobania_wild", () -> new WildTobania());

    public static final RegistryObject<Block> WILD_ZAZA = REGISTRY.register("zaza_wild", () -> new WildZaza());

    public static final RegistryObject<Block> BONG = REGISTRY.register("bong", () -> new BongBlock());

    public static final RegistryObject<Block> DESTRUCTOR = REGISTRY.register("destructor", () -> new DestructorBlock());

    public static final RegistryObject<Block> DESTRUCTOR_MAGICO = REGISTRY.register("destructor_magico", () -> new DestructormagicoBlock());

    public static final RegistryObject<Block> BANDEJA = REGISTRY.register("bandeja", () -> new BandejaBlock());

}