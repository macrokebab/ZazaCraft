package com.macrokebab.zazacraft.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import com.macrokebab.zazacraft.entity.PoliEntity;

public class PoliRenderer extends HumanoidMobRenderer<PoliEntity, HumanoidModel<PoliEntity>> {
    public PoliRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<PoliEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    @Override
    public ResourceLocation getTextureLocation(PoliEntity entity) {
        return new ResourceLocation("zazacraft:textures/entities/bb32e8be177bf74b.png");
    }
}

