package com.macrokebab.zazacraft.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

import com.macrokebab.zazacraft.world.inventory.DestructorguiMenu;
import com.macrokebab.zazacraft.network.DestructorguiButtonMessage;
import com.macrokebab.zazacraft.ZazacraftMod;

public class DestructorguiScreen extends AbstractContainerScreen<DestructorguiMenu> {
    private final static HashMap<String, Object> guistate = DestructorguiMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_destruir;

    public DestructorguiScreen(DestructorguiMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    private static final ResourceLocation texture = new ResourceLocation("zazacraft:textures/screens/destructor_gui.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

        guiGraphics.blit(new ResourceLocation("zazacraft:textures/screens/zaza_hoja_gui.png"), this.leftPos + 6, this.topPos + 7, 0, 0, 16, 16, 16, 16);

        guiGraphics.blit(new ResourceLocation("zazacraft:textures/screens/zaza_hoja_gui.png"), this.leftPos + 150, this.topPos + 7, 0, 0, 16, 16, 16, 16);

        guiGraphics.blit(new ResourceLocation("zazacraft:textures/screens/zaza_hoja_gui.png"), this.leftPos + 6, this.topPos + 61, 0, 0, 16, 16, 16, 16);

        guiGraphics.blit(new ResourceLocation("zazacraft:textures/screens/zaza_hoja_gui.png"), this.leftPos + 150, this.topPos + 61, 0, 0, 16, 16, 16, 16);

        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
    }

    @Override
    public void init() {
        super.init();
        button_destruir = Button.builder(Component.translatable("gui.zazacraft.destructor_gui.button_destruir"), e -> {
            if (true) {
                ZazacraftMod.PACKET_HANDLER.sendToServer(new DestructorguiButtonMessage(0, x, y, z));
                DestructorguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 51, this.topPos + 34, 67, 20).build();
        guistate.put("button:button_destruir", button_destruir);
        this.addRenderableWidget(button_destruir);
    }
}