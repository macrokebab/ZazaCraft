package com.macrokebab.zazacraft.procedures;

import net.minecraft.world.entity.Entity;

import com.macrokebab.zazacraft.network.ModVariables;

public class DestructorAlJugadorDestruirElBloqueProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        {
            double _setval = 0;
            entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.giros = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
    }
}
