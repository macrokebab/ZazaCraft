package com.macrokebab.zazacraft.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class VaritacanariaItem extends Item {

    public VaritacanariaItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
        return 1200; // Duración máxima para mantener presionado
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        ItemStack itemstack = entity.getItemInHand(hand);
        entity.startUsingItem(hand);

        // Aplicar efectos iniciales solo en el servidor
        if (!world.isClientSide()) {
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0)); // Náusea (10 segundos)
            entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0)); // Apnea (respiración acuática)
        }

        return InteractionResultHolder.success(itemstack);
    }

    @Override
    public void onUseTick(Level world, LivingEntity entity, ItemStack stack, int remainingTicks) {
        if (!world.isClientSide()) {
            entity.setDeltaMovement(entity.getDeltaMovement().x, 0.5, entity.getDeltaMovement().z); // Elevar al jugador
            entity.hasImpulse = true;
        }
    }


    // Cuando el jugador deja de usar el ítem
    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity entity, int timeLeft) {
        if (!world.isClientSide()) {
            entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0));

            // Solo aplicar daño si se usó durante al menos un tick
            if (timeLeft < 1200) {
                stack.hurtAndBreak(1, entity,
                        entity.getUsedItemHand() == InteractionHand.MAIN_HAND
                                ? EquipmentSlot.MAINHAND
                                : EquipmentSlot.OFFHAND
                );
            }
        }
    }

}