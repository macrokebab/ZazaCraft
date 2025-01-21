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
    // Create a Deferred Register to hold Blocks which will all be registered under the "zazacraft" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    // Registro de bloques
    public static final RegistryObject<Block> TOBANIA_CULTIVO = BLOCKS.register("tobania_cultivo",
            () -> new TobaniaCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> ZAZA_CULTIVO = BLOCKS.register("zaza_cultivo",
            () -> new ZazaCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> WILD_TOBANIA = BLOCKS.register("tobania_wild", () -> new WildTobania());

    public static final RegistryObject<Block> WILD_ZAZA = BLOCKS.register("zaza_wild", () -> new WildZaza());

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}