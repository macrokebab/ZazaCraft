package com.macrokebab.zazacraft.block;

import com.macrokebab.zazacraft.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import net.minecraft.core.registries.BuiltInRegistries;

public class BongBlock extends Block implements EntityBlock {

    public BongBlock() {
        super(Properties.copy(Blocks.GLASS)
                .strength(0.5f)
                .noOcclusion()
                .isRedstoneConductor((state, level, pos) -> false)); // Esto evita el renderizado sólido
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof BongBlockEntity bong) {
                ItemStack heldItem = player.getItemInHand(hand);
                if (heldItem.is(ModItems.ZAZA_DSTR.get())) {
                    if (bong.addZaza()) {
                        heldItem.shrink(1);
                        level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
                        return InteractionResult.SUCCESS;
                    }
                } else {
                    if (bong.getZazaCount() > 0) {
                        applyRandomEffect(player);
                        level.playSound(null, pos, SoundEvents.SMOKER_SMOKE, SoundSource.BLOCKS, 1.0f, 1.0f);
                        bong.removeZaza();
                    } else {
                        explode(level, pos);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }



    private void applyRandomEffect(Player player) {
        RandomSource random = RandomSource.create();
        int effectCount = BuiltInRegistries.MOB_EFFECT.size(); // Número total de efectos de poción disponibles
        MobEffect randomEffect = BuiltInRegistries.MOB_EFFECT.byId(random.nextInt(effectCount));
        player.addEffect(new MobEffectInstance(randomEffect, 300, 0)); // Duración 300 ticks y amplificador 0
    }

    private void explode(Level level, BlockPos pos) {
        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 4.0f, Level.ExplosionInteraction.NONE);
        level.playSound(null, pos, SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 1.0f, 1.0f);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BongBlockEntity(pos, state);
    }

}