package org.oxideve.cookify.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.oxideve.cookify.Cookify;

public class SeedEnhancerScreen extends AbstractContainerScreen<SeedEnhancerMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Cookify.MOD_ID, "textures/gui/seedenhancer_gui.png");

    public SeedEnhancerScreen(SeedEnhancerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelX = (imageWidth - font.width(this.title)) / 2;
        //this.titleLabelY = imageHeight / 2;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressBar(guiGraphics, x, y);
    }

    private void renderProgressBar(GuiGraphics guiGraphics, int x, int y) {
        if (menu.isCrafting()) {
            int barWidth = 55; // Lunghezza della barra
            int barHeight = 6; // Altezza della barra
            int progressWidth = menu.getScaledProgress(); // Lunghezza della barra in base al progresso

            // Calcola le coordinate x e y della barra
            int barX = 59; // Posizione x della barra (angolo alto sinistro)
            int barY = 39; // Posizione y della barra (angolo alto sinistro)

            // Disegna la barra
            guiGraphics.blit(TEXTURE, x + barX, y + barY, 176, 0, progressWidth, barHeight);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
