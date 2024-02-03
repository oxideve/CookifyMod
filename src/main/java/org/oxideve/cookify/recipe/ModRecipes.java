package org.oxideve.cookify.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.oxideve.cookify.Cookify;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Cookify.MOD_ID);

    public static final RegistryObject<RecipeSerializer<DeseederRecipe>> DESEEDER_SERIALIZER =
            SERIALIZERS.register("deseeder", () -> DeseederRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<FloraReactorRecipe>> FLORAREACTOR_SERIALIZER =
            SERIALIZERS.register("florareactor", () -> FloraReactorRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
