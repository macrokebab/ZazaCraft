package com.macrokebab.zazacraft.init;

import com.macrokebab.zazacraft.block.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.macrokebab.zazacraft.ZazacraftMod.MODID;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredBlock<Block> TOBANIA_CULTIVO = BLOCKS.register("tobania_semillas", TobaniaCrop::new);

    public static final DeferredBlock<Block> ZAZA_CULTIVO = BLOCKS.register("zaza_semillas", ZazaCrop::new);

    public static final DeferredBlock<Block> WILD_TOBANIA = BLOCKS.register("tobania_wild", WildTobania::new);

    public static final DeferredBlock<Block> WILD_ZAZA = BLOCKS.register("zaza_wild", WildZaza::new);

    public static final DeferredBlock<Block> BONG = BLOCKS.register("bong", BongBlock::new);

    public static final DeferredBlock<Block> DESTRUCTOR = BLOCKS.register("destructor", DestructorBlock::new);

    public static final DeferredBlock<Block> DESTRUCTOR_MAGICO = BLOCKS.register("destructor_magico", DestructormagicoBlock::new);

    public static final DeferredBlock<Block> BANDEJA = BLOCKS.register("bandeja", BandejaBlock::new);

}