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

public class PorroItem extends Item {

    private static final int COOLDOWN = 60 * 20; // 30 seconds in ticks

    public PorroItem(Item.Properties properties) {
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
            stack.shrink(1); // Reduce the stack size by 1

            // Effects added to the player
            player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 600, 1)); // 30 seconds of hunger
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600, 0)); // 30 seconds of slow falling
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 1)); // 30 seconds of speed

            if (level.random.nextFloat() < 0.35) {
                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300, 0)); // 15 seconds of nausea
            }
            if (level.random.nextFloat() < 0.75) {
                player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 300, 0)); // 15 seconds of levitation
            }
            if (level.random.nextFloat() < 0.10) {
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0)); // 30 seconds of night vision
            }
            if (level.random.nextFloat() < 0.05) {
                player.addEffect(new MobEffectInstance(MobEffects.LUCK, 600, 0)); // 30 seconds of luck
            }
        }

        return InteractionResultHolder.success(stack);
    }
}