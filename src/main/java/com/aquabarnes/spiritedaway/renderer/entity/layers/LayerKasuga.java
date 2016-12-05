package com.aquabarnes.spiritedaway.renderer.entity.layers;

import com.aquabarnes.spiritedaway.client.model.ModelKasuga;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderKasuga;

import net.minecraft.client.model.ModelSheep1;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class LayerKasuga implements LayerRenderer {

    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/test.png");
    private final RenderSheep Renderer;
    private final ModelKasuga Model = new ModelKasuga();

    public LayerKasuga(RenderSheep sheepRendererIn)
    {
        this.Renderer = sheepRendererIn;
    }
	
	@Override
	public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		
		if (entitylivingbaseIn.hasCustomName() && "AquaBarnes".equals(entitylivingbaseIn.getCustomNameTag()));

	}

	@Override
	public boolean shouldCombineTextures() {
		// TODO Auto-generated method stub
		return false;
	}

}
