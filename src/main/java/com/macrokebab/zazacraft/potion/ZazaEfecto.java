package com.macrokebab.zazacraft.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class ZazaEfecto extends MobEffect {
    public ZazaEfecto() {
        super(MobEffectCategory.NEUTRAL, 0x6A0DAD); // Color púrpura psicodélico
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {
            // Movimiento aleatorio
            randomWalk(entity, amplifier);
        } else {
            // Efectos visuales (cliente)
            spawnWeirdParticles(entity);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true; // Se ejecuta cada tick
    }

    private void spawnWeirdParticles(LivingEntity entity) {
        entity.level().addParticle(
                net.minecraft.core.particles.ParticleTypes.SNEEZE, // Partículas raras
                entity.getX() + entity.getRandom().nextGaussian() * 0.5,
                entity.getY() + entity.getEyeHeight() + entity.getRandom().nextGaussian() * 0.5,
                entity.getZ() + entity.getRandom().nextGaussian() * 0.5,
                0.0, 0.0, 0.0
        );
    }

    private void randomWalk(LivingEntity entity, int amplifier) {
        // Movimiento horizontal aleatorio
        double randomX = (entity.getRandom().nextDouble() - 0.5) * 0.2 * (amplifier + 1);
        double randomZ = (entity.getRandom().nextDouble() - 0.5) * 0.2 * (amplifier + 1);

        // Mantener la velocidad vertical
        entity.setDeltaMovement(
                randomX,
                entity.getDeltaMovement().y,
                randomZ
        );
        entity.hurtMarked = true; // Asegurar que se actualicen los movimientos
    }
}