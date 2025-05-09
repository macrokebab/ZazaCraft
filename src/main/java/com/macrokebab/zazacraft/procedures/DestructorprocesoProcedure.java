package com.macrokebab.zazacraft.procedures;

import com.macrokebab.zazacraft.init.ModItems;
import com.macrokebab.zazacraft.network.ModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.Map;
import java.util.function.Supplier;

public class DestructorprocesoProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        {
            double _setval = (entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ModVariables.PlayerVariables())).giros + 1;
            entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.giros = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        if ((entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ModVariables.PlayerVariables())).giros == 3) {
            {
                double _setval = 0;
                entity.getCapability(ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.giros = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == ModItems.COGOLLO.get()) {
                if (world instanceof Level _level2 && _level2.hasNeighborSignal(BlockPos.containing(x, y, z))) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(ModItems.ZAZA_POLVO.get()).copy();
                        _setstack.setCount(1);
                        ((Slot) _slots.get(1)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ((Slot) _slots.get(0)).remove(1);
                        _player.containerMenu.broadcastChanges();
                    }
                } else {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(ModItems.ZAZA_DSTR.get()).copy();
                        _setstack.setCount(1);
                        ((Slot) _slots.get(1)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ((Slot) _slots.get(0)).remove(1);
                        _player.containerMenu.broadcastChanges();
                    }
                }
            }
        }
    }
}