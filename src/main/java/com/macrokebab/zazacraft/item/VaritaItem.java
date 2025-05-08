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

public class VaritaItem extends Item {

    public VaritaItem(Item.Properties properties) {
        super(properties);

    }

    @Override
    public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
        return 72000; // Duración máxima para mantener presionado
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        ItemStack itemstack = entity.getItemInHand(hand);
        entity.startUsingItem(hand);

        // Aplicar efectos iniciales solo en el servidor
        if (!world.isClientSide()) {
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0)); // Náusea (10 segundos)
            entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0)); // Caída lenta
            entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0)); // Apnea (respiración acuática)
        }

        return InteractionResultHolder.success(itemstack);
    }

    @Override
    public void onUseTick(Level world, LivingEntity entity, ItemStack stack, int remainingTicks) {
        if (!world.isClientSide()) {
            // Aplicar levitación constante
            entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 2, 0));

            // Consumir durabilidad cada segundo (20 ticks)
            if (entity.getTicksUsingItem() % 20 == 0) {
                // Usar la firma correcta: (int damage, LivingEntity, EquipmentSlot)
                stack.hurtAndBreak(
                        1,
                        entity,
                        entity.getUsedItemHand() == InteractionHand.MAIN_HAND
                                ? EquipmentSlot.MAINHAND
                                : EquipmentSlot.OFFHAND
                );
            }
        }
    }

    @Override
    public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
        // No se necesita acción al soltar, pero mantenemos el método vacío
    }
}