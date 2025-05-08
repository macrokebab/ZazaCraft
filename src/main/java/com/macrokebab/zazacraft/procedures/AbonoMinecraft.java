package com.macrokebab.zazacraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

public interface AbonoMinecraft extends BonemealableBlock {
    // Métodos default para evitar duplicación
    @Override
    default boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate) {
        return true;
    }

    @Override
    default boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
        return true;
    }

    @Override
    default void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
        // Implementación base vacía
    }
}