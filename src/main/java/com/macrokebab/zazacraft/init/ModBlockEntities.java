package com.macrokebab.zazacraft.init;

import com.macrokebab.zazacraft.block.entity.BongBlockEntity;
import com.macrokebab.zazacraft.block.entity.DestructorBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "zazacraft");

    public static final RegistryObject<BlockEntityType<BongBlockEntity>> BONG = REGISTRY.register("bong",
            () -> BlockEntityType.Builder.of(BongBlockEntity::new, ModBlocks.BONG.get()).build(null));

    public static final RegistryObject<BlockEntityType<?>> DESTRUCTOR = register("destructor", ModBlocks.DESTRUCTOR, DestructorBlockEntity::new);

    public static final RegistryObject<BlockEntityType<?>> DESTRUCTOR_MAGICO = register("destructor_magico", ModBlocks.DESTRUCTOR_MAGICO, DestructorBlockEntity::new);

    // Start of user code block custom block entities
    // End of user code block custom block entities
    private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
        return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
    }


}