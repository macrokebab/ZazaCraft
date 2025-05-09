package com.macrokebab.zazacraft.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ZazatrigoItem extends Item {
    public ZazatrigoItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}