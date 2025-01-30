package com.macrokebab.zazacraft.init;

import com.macrokebab.zazacraft.block.BongBlockEntity;
import com.macrokebab.zazacraft.init.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "zazacraft");

    public static final RegistryObject<BlockEntityType<BongBlockEntity>> BONG = BLOCK_ENTITY_TYPES.register("bong",
            () -> BlockEntityType.Builder.of(BongBlockEntity::new, ModBlocks.BONG.get()).build(null));
}