package org.oxideve.cookify.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.oxideve.cookify.Cookify;
import org.oxideve.cookify.block.ModBlocks;
import org.oxideve.cookify.recipe.DeseederRecipe;

public class DeseederCategory implements IRecipeCategory<DeseederRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(Cookify.MOD_ID, "deseeder");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Cookify.MOD_ID,
            "textures/gui/deseeder_gui.png");

    public static final RecipeType<DeseederRecipe> DESEEDER_TYPE =
            new RecipeType<>(UID, DeseederRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public DeseederCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
                new ItemStack(ModBlocks.DESEEDER.get()));
    }


    public RecipeType<DeseederRecipe> getRecipeType() {
        return DESEEDER_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Deseeder");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, DeseederRecipe deseederRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(deseederRecipe.getIngredients().get(0));

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(deseederRecipe.getResultItem(null));
    }


}
