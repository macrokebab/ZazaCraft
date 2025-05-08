package com.macrokebab.zazacraft.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ZazatobaniaItem extends Item {
    public ZazatobaniaItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}