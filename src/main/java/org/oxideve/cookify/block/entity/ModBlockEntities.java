package org.oxideve.cookify.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.oxideve.cookify.Cookify;
import org.oxideve.cookify.block.ModBlocks;

public class ModBlockEntities{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Cookify.MOD_ID);

    public static final RegistryObject<BlockEntityType<DeseederBlockEntity>> DESEEDER_BE =
            BLOCK_ENTITIES.register("deseeder_be", () ->
                    BlockEntityType.Builder.of(DeseederBlockEntity::new,
                            ModBlocks.DESEEDER.get()).build(null));

    public static final RegistryObject<BlockEntityType<FloraReactorBlockEntity>> FLORA_REACTOR_BE =
            BLOCK_ENTITIES.register("flora_reactor_be", () ->
                    BlockEntityType.Builder.of(FloraReactorBlockEntity::new,
                            ModBlocks.FLORA_REACTOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<InductionCookerBlockEntity>> INDUCTIOCOOKER_BE =
            BLOCK_ENTITIES.register("inductioncooker_be", () ->
                    BlockEntityType.Builder.of(InductionCookerBlockEntity::new,
                            ModBlocks.INDUCTIONCOOKER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
