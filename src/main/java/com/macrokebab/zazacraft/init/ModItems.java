package com.macrokebab.zazacraft.init;

import com.macrokebab.zazacraft.item.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.macrokebab.zazacraft.ZazacraftMod.MODID;


public class ModItems {
    // Create a Deferred Register to hold Items which will all be registered under the "zazacraft" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Registro de items
    public static final RegistryObject<Item> CANARIA = ITEMS.register("varita_canaria",
            () -> new CanariaItem(new Item.Properties().stacksTo(1).durability(16)));

    public static final RegistryObject<Item> COGOLLO = ITEMS.register("cogollo",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ELIXIR_ZAZA = ITEMS.register("elixir_zaza",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> VERDE = ITEMS.register("verde",
            () -> new VerdeItem(new Item.Properties()));

    public static final RegistryObject<Item> PORRO = ITEMS.register("porro",
            () -> new PorroItem(new Item.Properties()));

    public static final RegistryObject<Item> PAPELOTE = ITEMS.register("papelote",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RINONERA = ITEMS.register("rinonera",
            () -> new RinoneraItem());

    public static final RegistryObject<Item> SOSTENEDOR = ITEMS.register("sostenedor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TOBANIA_HOJA = ITEMS.register("tobania_hoja",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TOBANIA_SEMILLAS = ITEMS.register("tobania_semillas",
            () -> new BlockItem(ModBlocks.TOBANIA_CULTIVO.get(), new Item.Properties()));

    public static final RegistryObject<Item> VARITA = ITEMS.register("varita_magica",
            () -> new VaritaItem(new Item.Properties().stacksTo(1).durability(16)));

    public static final RegistryObject<Item> ZAZA_DSTR = ITEMS.register("zaza_dstr",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZAZA_HOJA = ITEMS.register("zaza_hoja",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZAZA_POLVO = ITEMS.register("zaza_polvo",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZAZA_ROCA = ITEMS.register("zaza_roca",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZAZA_SEMILLAS = ITEMS.register("zaza_semillas",
            () -> new BlockItem(ModBlocks.ZAZA_CULTIVO.get(), new Item.Properties()));

    public static final RegistryObject<Item> BONG = ITEMS.register("bong",
            () -> new BlockItem(ModBlocks.BONG.get(), new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> DESTRUCTOR = ITEMS.register("destructor",
            () -> new BlockItem(ModBlocks.DESTRUCTOR.get(), new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> BANDEJA = ITEMS.register("bandeja",
            () -> new BlockItem(ModBlocks.BANDEJA.get(), new Item.Properties().stacksTo(1)));

}