package com.macrokebab.zazacraft.procedures;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class FumarVaritaSolProcedure {
    public static void execute(LevelAccessor world, ItemStack itemstack) {
        if (world instanceof ServerLevel _level) {
            itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
            });
        }
    }
}
