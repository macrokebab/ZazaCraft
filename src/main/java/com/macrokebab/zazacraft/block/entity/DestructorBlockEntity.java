package com.macrokebab.zazacraft.block.entity;

import net.minecraftforge.items.wrapper.SidedInvWrapper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.stream.IntStream;

import io.netty.buffer.Unpooled;

import com.macrokebab.zazacraft.world.inventory.DestructorguiMenu;
import com.macrokebab.zazacraft.init.ModBlockEntities;

public class DestructorBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
    private int giros = 0; // Contador de giros

    // Métodos para el contador giros
    public int getGiros() {
        return this.giros;
    }

    public void setGiros(int value) {
        this.giros = value;
        this.setChanged(); // Guarda cambios
    }


    private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(2, ItemStack.EMPTY);
    private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());

    // Variables para controlar el estado
    private boolean isRedstonePowered = false;
    private ProcessMode currentMode = ProcessMode.MODE_1; // Enum para los modos

    // Enum para definir los modos de proceso
    public enum ProcessMode {
        MODE_1, // Proceso sin redstone
        MODE_2  // Proceso con redstone
    }

    // Constructor
    public DestructorBlockEntity(BlockPos position, BlockState state) {
        super(ModBlockEntities.DESTRUCTOR.get(), position, state);
    }

    // Método para actualizar el estado de redstone
    public void setRedstonePowered(boolean powered) {
        this.isRedstonePowered = powered;
        this.currentMode = powered ? ProcessMode.MODE_2 : ProcessMode.MODE_1;
        this.setChanged(); // Marca la entidad como modificada para guardar cambios
    }

    // Getter para el estado de redstone (ahora público)
    public boolean isRedstonePowered() {
        return isRedstonePowered;
    }

    // Getter para el modo actual
    public ProcessMode getCurrentMode() {
        return currentMode;
    }

    // Método para guardar datos persistentes
    // Guardar y cargar el contador
    @Override
    protected void saveAdditional(CompoundTag compound) {
        super.saveAdditional(compound); // Guardar datos básicos
        compound.putBoolean("RedstonePowered", isRedstonePowered); // Guardar estado de redstone
        compound.putString("CurrentMode", currentMode.name()); // Guardar modo actual
        compound.putInt("Giros", this.giros);
        if (!this.trySaveLootTable(compound)) { // Guardar el inventario si no hay tabla de botín
            ContainerHelper.saveAllItems(compound, this.stacks);
        }
    }

    // Método para cargar datos persistentes
    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        this.giros = compound.getInt("Giros");
        this.isRedstonePowered = compound.getBoolean("RedstonePowered"); // Cargar estado de redstone
        this.currentMode = ProcessMode.valueOf(compound.getString("CurrentMode")); // Cargar modo actual
        if (!this.tryLoadLootTable(compound)) { // Cargar el inventario si no hay tabla de botín
            this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
            ContainerHelper.loadAllItems(compound, this.stacks);
        }
    }

    // Método para sincronizar datos con el cliente
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithFullMetadata();
    }

    // Métodos de contenedor
    @Override
    public int getContainerSize() {
        return stacks.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.stacks) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Component getDefaultName() {
        return Component.literal("destructor");
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new DestructorguiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Destructor");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.stacks;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> stacks) {
        this.stacks = stacks;
    }

    @Override
    public boolean canPlaceItem(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return IntStream.range(0, this.getContainerSize()).toArray();
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
        return this.canPlaceItem(index, stack);
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return true;
    }

    // Método para manejar capacidades (como el manejo de ítems)
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        if (!this.remove && facing != null && capability == ForgeCapabilities.ITEM_HANDLER) {
            return handlers[facing.ordinal()].cast();
        }
        return super.getCapability(capability, facing);
    }

    // Método para invalidar capacidades cuando la entidad se elimina
    @Override
    public void setRemoved() {
        super.setRemoved();
        for (LazyOptional<? extends IItemHandler> handler : handlers) {
            handler.invalidate();
        }
    }
}