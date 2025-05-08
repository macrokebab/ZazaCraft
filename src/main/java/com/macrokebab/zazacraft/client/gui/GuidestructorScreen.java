package com.macrokebab.zazacraft.client.gui;

import com.macrokebab.zazacraft.network.GuidestructorButtonMessage;
import com.macrokebab.zazacraft.world.inventory.GuidestructorMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.HashMap;

public class GuidestructorScreen extends AbstractContainerScreen<GuidestructorMenu> {
    private final static HashMap<String, Object> guistate = GuidestructorMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_destruir;

    public GuidestructorScreen(GuidestructorMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    private static final ResourceLocation texture = ResourceLocation.parse("zazacraft:textures/screens/guidestructor.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
        button_destruir = Button.builder(Component.translatable("gui.zazacraft.guidestructor.button_destruir"), e -> {
            if (true) {
                PacketDistributor.sendToServer(new GuidestructorButtonMessage(0, x, y, z));
                GuidestructorButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 54, this.topPos + 24, 67, 20).build();
        guistate.put("button:button_destruir", button_destruir);
        this.addRenderableWidget(button_destruir);
    }
}
