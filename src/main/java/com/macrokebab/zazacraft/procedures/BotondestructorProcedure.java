package com.macrokebab.zazacraft.procedures;

import com.macrokebab.zazacraft.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.Map;
import java.util.function.Supplier;

public class BotondestructorProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == ModItems.COGOLLO.get()) {
            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                ((Slot) _slots.get(0)).remove(1);
                _player.containerMenu.broadcastChanges();
            }
            if (world instanceof Level _level3 && _level3.hasNeighborSignal(BlockPos.containing(x, y, z))) {
                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                    ItemStack _setstack = new ItemStack(ModItems.ZAZA_POLVO.get()).copy();
                    _setstack.setCount(1);
                    ((Slot) _slots.get(1)).set(_setstack);
                    _player.containerMenu.broadcastChanges();
                }
            } else {
                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                    ItemStack _setstack = new ItemStack(ModItems.ZAZA_DSTR.get()).copy();
                    _setstack.setCount(2);
                    ((Slot) _slots.get(1)).set(_setstack);
                    _player.containerMenu.broadcastChanges();
                }
            }
        }
    }
}