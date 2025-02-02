package com.macrokebab.zazacraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

import com.macrokebab.zazacraft.init.ModItems;
import com.macrokebab.zazacraft.ZazacraftMod;

public class DestructorprocesoProcedure {
    private static boolean variableControl = false; // Nueva variable

    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null) return;

        // Verifica si el slot 1 está vacío
        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
                ? ((Slot) _slt.get(1)).getItem()
                : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {

            // Si la condición se cumple y la variable está en false, se pone en true
            if (!variableControl) {
                variableControl = true;
            }

            ZazacraftMod.queueServerWork(100, () -> {
                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                    ItemStack _setstack = new ItemStack(ModItems.ZAZA_DSTR.get()).copy();
                    _setstack.setCount(1);
                    ((Slot) _slots.get(1)).set(_setstack);
                    _player.containerMenu.broadcastChanges();

                    // Cuando el item aparece en el slot 1, la variable vuelve a false
                    if (!((Slot) _slots.get(1)).getItem().isEmpty()) {
                        variableControl = false;
                    }
                }

                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                    ((Slot) _slots.get(0)).remove(1);
                    _player.containerMenu.broadcastChanges();
                }
            });
        }
    }
}