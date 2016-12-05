package com.aquabarnes.spiritedaway.client.renderer.entity;

import com.aquabarnes.spiritedaway.client.model.ModelKashira;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderLin extends RenderLiving {

	private static final ResourceLocation KashiraTextures = new ResourceLocation("sa:textures/entity/kashira.png");
	protected static ModelKashira Model;

	public RenderLin(RenderManager renderManager, ModelBase modelKashira, float f) {

	  super(renderManager, modelKashira, f);
	}

	    /**
	     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	     */
	    protected ResourceLocation getEntityTexture(Entity entity)
	    {
	        return KashiraTextures;
	    }
}