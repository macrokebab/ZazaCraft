package com.macrokebab.zazacraft.init;

import com.macrokebab.zazacraft.block.entity.BongBlockEntity;
import com.macrokebab.zazacraft.block.entity.DestructorBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(net.minecraft.core.registries.Registries.BLOCK_ENTITY_TYPE, "zazacraft");


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BongBlockEntity>> BONG = REGISTRY.register("bong",
            () -> BlockEntityType.Builder.of(BongBlockEntity::new, ModBlocks.BONG.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DestructorBlockEntity>> DESTRUCTOR = register(
            "destructor",
            ModBlocks.DESTRUCTOR,
            DestructorBlockEntity::new);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DestructorBlockEntity>> DESTRUCTOR_MAGICO = register(
            "destructor_magico",
            ModBlocks.DESTRUCTOR_MAGICO,
            DestructorBlockEntity::new);

    private static <E extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<E>> register(
            String name,
            DeferredHolder<Block, ? extends Block> block,
            BlockEntityType.BlockEntitySupplier<E> supplier) {

        return REGISTRY.register(name, () ->
                BlockEntityType.Builder.of(supplier, block.get()).build(null));
    }
}
