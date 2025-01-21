package com.macrokebab.zazacraft.init;

import com.macrokebab.zazacraft.item.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
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

    public static final RegistryObject<Item> PALITO = ITEMS.register("palito",
            () -> new PalitoItem(new Item.Properties()));

    public static final RegistryObject<Item> PALITO_LOCO = ITEMS.register("palito_loco",
            () -> new PalitoLocoItem(new Item.Properties()));

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

    public static final RegistryObject<Item> ZAZA_SEMILLAS = ITEMS.register("zaza_semillas",
            () -> new BlockItem(ModBlocks.ZAZA_CULTIVO.get(), new Item.Properties()));

    private static RegistryObject<Item> block(RegistryObject<Block> block) {
        return ITEMS.register(block.getId().getPath(),
                () -> new BlockItem(block.get(),
                        new Item.Properties()));
    }

    private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
        return ITEMS.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
    }
}