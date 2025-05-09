package com.macrokebab.zazacraft.procedures;

import com.macrokebab.zazacraft.network.ModVariables;
import net.minecraft.world.entity.Entity;

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
