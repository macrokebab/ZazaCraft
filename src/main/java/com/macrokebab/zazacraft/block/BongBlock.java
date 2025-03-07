package com.macrokebab.zazacraft.block;

import com.macrokebab.zazacraft.block.entity.BongBlockEntity;
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

/**
 * Bloque personalizado que representa una pipa de agua (bong) con funcionalidad interactiva.
 * Permite cargar con hierba (ZAZA) y aplicar efectos aleatorios al usarla.
 * Implementa EntityBlock para tener asociada una entidad de bloque que almacena estado.
 */
public class BongBlock extends Block implements EntityBlock {

    /**
     * Constructor que configura las propiedades del bloque.
     * Hereda propiedades del vidrio pero con:
     * - Resistencia reducida (0.5)
     * - Sin oclusión (permite ver a través del bloque)
     * - No conduce redstone
     */
    public BongBlock() {
        super(Properties.copy(Blocks.GLASS)
                .strength(0.5f)
                .noOcclusion()  // Permite ver a través del bloque
                .isRedstoneConductor((state, level, pos) -> false)); // No bloquea señales de redstone
    }

    /**
     * Maneja la interacción del jugador con el bloque.
     * Se ejecuta tanto en cliente como servidor, pero la lógica principal solo en servidor.
     */
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {  // Solo ejecutar en servidor
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof BongBlockEntity bong) {  // Verificar si la entidad es del tipo correcto
                ItemStack heldItem = player.getItemInHand(hand);

                // Si el jugador tiene ZAZA en la mano
                if (heldItem.is(ModItems.ZAZA_DSTR.get())) {
                    if (bong.addZaza()) {  // Intentar añadir ZAZA al bong
                        heldItem.shrink(1);  // Reducir cantidad del item
                        level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
                        return InteractionResult.SUCCESS;
                    }
                } else {
                    // Si el bong tiene ZAZA cargado
                    if (bong.getZazaCount() > 0) {
                        applyRandomEffect(player);  // Aplicar efecto aleatorio
                        level.playSound(null, pos, SoundEvents.SMOKER_SMOKE, SoundSource.BLOCKS, 1.0f, 1.0f);
                        bong.removeZaza();  // Consumir una carga
                    } else {
                        explode(level, pos);  // Explotar si no hay ZAZA
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }

    /**
     * Aplica un efecto de poción aleatorio al jugador.
     * @param player Jugador al que se aplicará el efecto
     */
    private void applyRandomEffect(Player player) {
        RandomSource random = RandomSource.create();
        // Obtener todos los efectos de poción registrados en el juego
        int effectCount = BuiltInRegistries.MOB_EFFECT.size();
        // Seleccionar un efecto aleatorio
        MobEffect randomEffect = BuiltInRegistries.MOB_EFFECT.byId(random.nextInt(effectCount));
        // Aplicar efecto durante 15 segundos (300 ticks) sin amplificación
        player.addEffect(new MobEffectInstance(randomEffect, 300, 0));
    }

    /**
     * Hace explotar el bloque con una potencia moderada.
     * @param level Mundo donde ocurre la explosión
     * @param pos Posición del bloque
     */
    private void explode(Level level, BlockPos pos) {
        // Crear explosión de fuerza 4 sin dañar bloques (ExplosionInteraction.NONE)
        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 4.0f, Level.ExplosionInteraction.NONE);
        level.playSound(null, pos, SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 1.0f, 1.0f);
    }

    /**
     * Crea una nueva entidad de bloque asociada a este bloque.
     * Requerido por la interfaz EntityBlock.
     */
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BongBlockEntity(pos, state);  // Instancia de la entidad que almacena el estado del bong
    }
}