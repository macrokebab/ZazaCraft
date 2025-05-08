package com.macrokebab.zazacraft.procedures;

import com.macrokebab.zazacraft.init.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Level.ExplosionInteraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BongAlPresionarClickDerechoEnElBloqueProcedure {

    public static void execute(Entity entity) {
        if (entity == null)
            return;

        boolean correctItem = (entity instanceof LivingEntity _livEnt ?
                _livEnt.getMainHandItem() : ItemStack.EMPTY)
                .getItem() == ModItems.ZAZA_DSTR.get();

        if (correctItem) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                // Código de aplicación de efectos
                List<Holder<MobEffect>> allEffects = new ArrayList<>();
                BuiltInRegistries.MOB_EFFECT.holders().forEach(allEffects::add);

                if (!allEffects.isEmpty()) {
                    Random random = new Random();
                    Holder<MobEffect> randomEffect = allEffects.get(random.nextInt(allEffects.size()));
                    _entity.addEffect(new MobEffectInstance(randomEffect, 300, 1));
                }
            }
        } else {
            // Código de explosión
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                Level level = _entity.level();

                // Crear explosión
                level.explode(
                        _entity,
                        _entity.getX(), _entity.getY(), _entity.getZ(),
                        4.0f,
                        true,
                        ExplosionInteraction.NONE
                );

                // Daño al jugador (usando DamageTypes directamente)
                DamageSource damageSource = level.damageSources().onFire();
                _entity.hurt(damageSource, 8.0f);

                // Aplicar fuego (5 segundos = 100 ticks)
                _entity.setRemainingFireTicks(100);
            }
        }
    }
}