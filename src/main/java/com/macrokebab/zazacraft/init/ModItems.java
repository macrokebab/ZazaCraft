package com.macrokebab.zazacraft.init;

import com.macrokebab.zazacraft.ZazacraftMod;
import com.macrokebab.zazacraft.item.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.minecraft.world.item.Rarity.EPIC;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ZazacraftMod.MODID);

    //

    public static final Supplier<Item> ZAZA_DSTR = ITEMS.registerSimpleItem("zaza_dstr");
    public static final Supplier<Item> ZAZA_HOJA = ITEMS.registerSimpleItem("zaza_hoja");
    public static final Supplier<Item> ZAZA_POLVO = ITEMS.registerSimpleItem("zaza_polvo");
    public static final Supplier<Item> ZAZA_ROCA = ITEMS.registerSimpleItem("zaza_roca");
    public static final Supplier<Item> COGOLLO = ITEMS.registerSimpleItem("cogollo");
    public static final Supplier<Item> PAPELOTE = ITEMS.registerSimpleItem("papelote");
    public static final Supplier<Item> SOSTENEDOR = ITEMS.registerSimpleItem("sostenedor");
    public static final Supplier<Item> TOBANIA_HOJA = ITEMS.registerSimpleItem("tobania_hoja");

    //

    public static final Supplier<Item> ZAZA_TRIGO = ITEMS.register("zaza_trigo", ZazatrigoItem::new);
    public static final Supplier<Item> ZAZA_TOBANIA = ITEMS.register("zaza_tobania", ZazatobaniaItem::new);
    public static final Supplier<Item> PASTEL = ITEMS.register("pastel", PastelItem::new);
    public static final Supplier<Item> RINONERA = ITEMS.register("rinonera", RinoneraItem::new);

    //

    public static final Supplier<Item> VARITA_CANARIA = ITEMS.register(
            "varita_canaria",
            () -> new VaritacanariaItem(
                    new Item.Properties()
                            .durability(16)
                            .rarity(EPIC)
            )
    );

    public static final Supplier<Item> VARITA = ITEMS.register(
            "varita_magica",
            () -> new VaritaItem(
                    new Item.Properties()
                            .durability(16)
            )
    );

    public static final Supplier<Item> VERDE = ITEMS.register(
            "verde",
            () -> new VerdeItem(
                    new Item.Properties()
                            .stacksTo(4)
            )
    );

    public static final Supplier<Item> PORRO = ITEMS.register(
            "porro",
            () -> new PorroItem(
                    new Item.Properties()
                            .stacksTo(4)
            )
    );





    public static final Supplier<Item> ELIXIR_ZAZA = ITEMS.register(
            "elixir_zaza",
            () -> new Item(
                    new Item.Properties()
                            .durability(3)
            )
    );

    //

    public static final Supplier<BlockItem> TOBANIA_SEMILLAS = ITEMS.registerSimpleBlockItem(
            ModBlocks.TOBANIA_CULTIVO,
            new Item.Properties()
    );

    public static final Supplier<BlockItem> ZAZA_SEMILLAS = ITEMS.registerSimpleBlockItem(
            ModBlocks.ZAZA_CULTIVO,
            new Item.Properties()
    );

    public static final Supplier<BlockItem> BONG = ITEMS.registerSimpleBlockItem(
            ModBlocks.BONG,
            new Item.Properties().stacksTo(1)
    );

    public static final Supplier<BlockItem> DESTRUCTOR = ITEMS.registerSimpleBlockItem(
            ModBlocks.DESTRUCTOR,
            new Item.Properties().stacksTo(1)
    );

    public static final Supplier<BlockItem> DESTRUCTOR_MAGICO = ITEMS.registerSimpleBlockItem(
            ModBlocks.DESTRUCTOR_MAGICO,
            new Item.Properties().stacksTo(1)
    );

    public static final Supplier<BlockItem> BANDEJA = ITEMS.registerSimpleBlockItem(
            ModBlocks.BANDEJA,
            new Item.Properties().stacksTo(1)
    );

}