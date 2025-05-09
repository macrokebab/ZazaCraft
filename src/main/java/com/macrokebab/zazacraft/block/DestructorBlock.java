// Define el paquete donde se encuentra esta clase
package com.macrokebab.zazacraft.block;

// Importaciones necesarias para el funcionamiento del bloque

import com.macrokebab.zazacraft.block.entity.DestructorBlockEntity;
import com.macrokebab.zazacraft.procedures.DestructorAlJugadorDestruirElBloqueProcedure;
import com.macrokebab.zazacraft.world.inventory.DestructorguiMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;

// Clase que define un bloque personalizado llamado "DestructorBlock"
// Implementa la interfaz EntityBlock para permitir que el bloque tenga una entidad asociada
public class DestructorBlock extends Block implements EntityBlock {

    // Constructor del bloque
    public DestructorBlock() {
        // Llama al constructor de la clase padre (Block) con propiedades personalizadas
        super(BlockBehaviour.Properties.of()
                .sound(SoundType.METAL) // Define el sonido del bloque (sonido de metal)
                .strength(0f, 10f) // Define la resistencia del bloque (0 de dureza, 10 de resistencia a explosiones)
                .noCollission() // El bloque no tiene colisión (los jugadores pueden atravesarlo)
                .noOcclusion() // El bloque no ocluye la luz (no bloquea la luz)
                .isRedstoneConductor((bs, br, bp) -> false) // El bloque no conduce la redstone
        );
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
        boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
        DestructorAlJugadorDestruirElBloqueProcedure.execute(entity);
        return retval;
    }

    // Método que define el color que el bloque aporta a un faro (beacon)
    @Override
    public float[] getBeaconColorMultiplier(BlockState state, LevelReader world, BlockPos pos, BlockPos beaconPos) {
        return new float[]{0.2f, 0.2f, 0f}; // Devuelve un color amarillo oscuro
    }

    // Método que define si la luz del cielo pasa a través del bloque
    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true; // La luz del cielo pasa a través del bloque
    }

    // Método que define cuánta luz bloquea el bloque
    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0; // No bloquea la luz
    }

    // Método que define la forma visual del bloque (usado para renderizado)
    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty(); // No tiene forma visual (es invisible)
    }

    // Método que define la forma de colisión del bloque (usado para físicas y colisiones)
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return box(6, 0, 6, 10, 4, 10); // Define una caja de colisión pequeña en el centro del bloque
    }

    // Método que define el tipo de ruta que los mobs pueden usar para moverse alrededor del bloque
    @Override
    public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
        return BlockPathTypes.WALKABLE; // Los mobs pueden caminar sobre este bloque
    }

    @Override
    public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
        super.use(blockstate, world, pos, entity, hand, hit);
        if (entity instanceof ServerPlayer player) {
            NetworkHooks.openScreen(player, new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.literal("Destructor");
                }

                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                    return new DestructorguiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
                }
            }, pos);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        BlockEntity tileEntity = worldIn.getBlockEntity(pos);
        return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DestructorBlockEntity(pos, state);
    }

    @Override
    public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
        super.triggerEvent(state, world, pos, eventID, eventParam);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
        BlockEntity tileentity = world.getBlockEntity(pos);
        if (tileentity instanceof DestructorBlockEntity be)
            return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
        else
            return 0;
    }

}