package com.macrokebab.zazacraft.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class VaritaItem extends Item {

    private static final int MAX_USES = 16;
    private static final int COOLDOWN = 30 * 20; // 30 segundos en ticks

    public VaritaItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            if (player.getCooldowns().isOnCooldown(this)) {
                return InteractionResultHolder.fail(stack);
            }

            player.getCooldowns().addCooldown(this, COOLDOWN);
            stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));

            player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 600, 1)); // 30 segundos de hambre
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600, 0)); // 30 segundos de caída lenta

            if (level.random.nextFloat() < 0.20) {
                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300, 0)); // 15 segundos de náusea
            }
            if (level.random.nextFloat() < 0.075) {
                player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 300, 0)); // 15 segundos de levitación
            }
            if (level.random.nextFloat() < 0.40) {
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0)); // 30 segundos de visión nocturna
            }
        }

        return InteractionResultHolder.success(stack);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return MAX_USES;
    }
}