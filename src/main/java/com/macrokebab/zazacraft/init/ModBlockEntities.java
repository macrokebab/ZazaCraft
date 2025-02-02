package com.macrokebab.zazacraft.init;

import com.macrokebab.zazacraft.block.BongBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.world.level.block.Block;

import com.macrokebab.zazacraft.block.entity.DestructorBlockEntity;


public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "zazacraft");

    public static final RegistryObject<BlockEntityType<BongBlockEntity>> BONG = BLOCK_ENTITY_TYPES.register("bong",
            () -> BlockEntityType.Builder.of(BongBlockEntity::new, ModBlocks.BONG.get()).build(null));

    public static final RegistryObject<BlockEntityType<?>> DESTRUCTOR = register("destructor", ModBlocks.DESTRUCTOR, DestructorBlockEntity::new);

    // Start of user code block custom block entities
    // End of user code block custom block entities
    private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
        return BLOCK_ENTITY_TYPES.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
    }


}