package org.oxideve.cookify.item;

import org.oxideve.cookify.Cookify;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.oxideve.cookify.block.ModBlocks;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Cookify.MOD_ID);

    public static final RegistryObject<CreativeModeTab> COOKIFYTAB1 = CREATIVE_MODE_TABS.register("cookify_tab1",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TOMATO.get()))
                    .title(Component.literal("Cookify Food"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.TOMATO.get());


                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> COOKIFYTAB2 = CREATIVE_MODE_TABS.register("cookify_tab2",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TESTBLOCK.get()))
                    .title(Component.literal("Cookify Machines"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModBlocks.TESTBLOCK.get());
                        pOutput.accept(ModBlocks.DESEEDER.get());


                    })
                    .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}