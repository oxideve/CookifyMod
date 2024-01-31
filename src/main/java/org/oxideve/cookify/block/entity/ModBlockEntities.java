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

    public static final RegistryObject<BlockEntityType<SeedEnhancerBlockEntity>> SEED_ENHANCER_BE =
            BLOCK_ENTITIES.register("seed_enhancer_be", () ->
                    BlockEntityType.Builder.of(SeedEnhancerBlockEntity::new,
                            ModBlocks.SEED_ENHANCER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
