package com.macrokebab.zazacraft.item.inventory;

import com.macrokebab.zazacraft.client.gui.GuirinoneraScreen;
import com.macrokebab.zazacraft.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.neoforge.items.ComponentItemHandler;

import javax.annotation.Nonnull;

@EventBusSubscriber(Dist.CLIENT)
public class RinoneraInventoryCapability extends ComponentItemHandler {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onItemDropped(ItemTossEvent event) {
        if (event.getEntity().getItem().getItem() == ModItems.RINONERA.get()) {
            if (Minecraft.getInstance().screen instanceof GuirinoneraScreen) {
                Minecraft.getInstance().player.closeContainer();
            }
        }
    }

    public RinoneraInventoryCapability(MutableDataComponentHolder parent) {
        super(parent, DataComponents.CONTAINER, 4);
    }

    @Override
    public int getSlotLimit(int slot) {
        return 64;
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return stack.getItem() != ModItems.RINONERA.get();
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return super.getStackInSlot(slot).copy();
    }
}
