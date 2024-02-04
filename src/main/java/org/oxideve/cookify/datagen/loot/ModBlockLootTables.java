package org.oxideve.cookify.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import org.oxideve.cookify.block.ModBlocks;
import org.oxideve.cookify.block.custom.BlueberriesCropBlock;
import org.oxideve.cookify.block.custom.TomatoCropBlock;
import org.oxideve.cookify.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.DESEEDER.get());
        this.dropSelf(ModBlocks.FLORA_REACTOR.get());
        this.dropSelf(ModBlocks.INDUCTIONCOOKER.get());

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.BLUEBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlueberriesCropBlock.AGE, 3));

        this.add(ModBlocks.BLUEBERRY_CROP.get(), createCropDrops(ModBlocks.BLUEBERRY_CROP.get(), ModItems.BLUEBERRY.get(),
                ModItems.BLUEBERRY_SEEDS.get(), lootitemcondition$builder));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 9));

        this.add(ModBlocks.TOMATO_CROP.get(), createCropDrops(ModBlocks.TOMATO_CROP.get(), ModItems.TOMATO.get(),
                ModItems.TOMATO_SEEDS.get(), lootitemcondition$builder2));
    }



    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
