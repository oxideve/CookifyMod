package org.oxideve.cookify.item;

import net.minecraft.world.item.ItemNameBlockItem;
import org.oxideve.cookify.Cookify;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.oxideve.cookify.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Cookify.MOD_ID);

    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MUSH_PORCINI = ITEMS.register("mush_porcini",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds", //2blocks
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORANGE_SEEDS = ITEMS.register("orange_seeds",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds", //simplecrop
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_CROP.get(), new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
