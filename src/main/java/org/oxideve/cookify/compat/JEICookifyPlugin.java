package org.oxideve.cookify.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import org.oxideve.cookify.Cookify;
import org.oxideve.cookify.recipe.DeseederRecipe;
import org.oxideve.cookify.screen.DeseederScreen;

import java.util.List;

@JeiPlugin
public class JEICookifyPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Cookify.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new DeseederCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<DeseederRecipe> deseederRecipes = recipeManager.getAllRecipesFor(DeseederRecipe.Type.INSTANCE);
        registration.addRecipes(DeseederCategory.DESEEDER_TYPE, deseederRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(DeseederScreen.class, 60, 30, 20, 20,
                DeseederCategory.DESEEDER_TYPE);
    }
}
