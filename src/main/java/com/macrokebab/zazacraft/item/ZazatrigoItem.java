package com.macrokebab.zazacraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ZazatrigoItem extends Item {
    public ZazatrigoItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}