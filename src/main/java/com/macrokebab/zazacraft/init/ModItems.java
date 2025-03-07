package com.macrokebab.zazacraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import com.macrokebab.zazacraft.item.*;
import com.macrokebab.zazacraft.ZazacraftMod;


import static com.macrokebab.zazacraft.ZazacraftMod.MODID;


public class ModItems {
    // Create a Deferred Register to hold Items which will all be registered under the "zazacraft" namespace
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Registro de items
    public static final RegistryObject<Item> CANARIA = REGISTRY.register("varita_canaria",
            () -> new CanariaItem(new Item.Properties().stacksTo(1).durability(16)));

    public static final RegistryObject<Item> COGOLLO = REGISTRY.register("cogollo",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ELIXIR_ZAZA = REGISTRY.register("elixir_zaza",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> VERDE = REGISTRY.register("verde",
            () -> new VerdeItem(new Item.Properties()));

    public static final RegistryObject<Item> PORRO = REGISTRY.register("porro",
            () -> new PorroItem(new Item.Properties()));

    public static final RegistryObject<Item> PAPELOTE = REGISTRY.register("papelote",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RINONERA = REGISTRY.register("rinonera",
            () -> new RinoneraItem());

    public static final RegistryObject<Item> SOSTENEDOR = REGISTRY.register("sostenedor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TOBANIA_HOJA = REGISTRY.register("tobania_hoja",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TOBANIA_SEMILLAS = REGISTRY.register("tobania_semillas",
            () -> new BlockItem(ModBlocks.TOBANIA_CULTIVO.get(), new Item.Properties()));

    public static final RegistryObject<Item> VARITA = REGISTRY.register("varita_magica",
            () -> new VaritaItem(new Item.Properties().stacksTo(1).durability(16)));

    public static final RegistryObject<Item> ZAZA_DSTR = REGISTRY.register("zaza_dstr",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZAZA_HOJA = REGISTRY.register("zaza_hoja",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZAZA_POLVO = REGISTRY.register("zaza_polvo",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZAZA_ROCA = REGISTRY.register("zaza_roca",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZAZA_SEMILLAS = REGISTRY.register("zaza_semillas",
            () -> new BlockItem(ModBlocks.ZAZA_CULTIVO.get(), new Item.Properties()));

    public static final RegistryObject<Item> BONG = REGISTRY.register("bong",
            () -> new BlockItem(ModBlocks.BONG.get(), new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> DESTRUCTOR = REGISTRY.register("destructor",
            () -> new BlockItem(ModBlocks.DESTRUCTOR.get(), new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> DESTRUCTOR_MAGICO = REGISTRY.register("destructor_magico",
            () -> new BlockItem(ModBlocks.DESTRUCTOR_MAGICO.get(), new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> BANDEJA = REGISTRY.register("bandeja",
            () -> new BlockItem(ModBlocks.BANDEJA.get(), new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> POLI_SPAWN_EGG = REGISTRY.register("poli_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.POLI, -1, -16777063, new Item.Properties()));

    public static final RegistryObject<Item> ZAZATRIGO = REGISTRY.register("zazatrigo", () -> new ZazatrigoItem());

    public static final RegistryObject<Item> ZAZATOBANIA = REGISTRY.register("zazatobania", () -> new ZazatobaniaItem());

    public static final RegistryObject<Item> PASTEL = REGISTRY.register("pastel", () -> new PastelItem());



    // Start of user code block custom items
    // End of user code block custom items
    private static RegistryObject<Item> block(RegistryObject<Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));


    }
}
