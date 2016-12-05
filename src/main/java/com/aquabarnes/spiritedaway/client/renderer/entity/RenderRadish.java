package com.aquabarnes.spiritedaway.client.renderer.entity;

import com.aquabarnes.spiritedaway.client.model.ModelKasuga;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderRadish extends RenderLiving
{
private static final ResourceLocation RadishTextures = new ResourceLocation("sa:textures/entity/radish.png");
private static final ResourceLocation RadishLavaTextures = new ResourceLocation("sa:textures/entity/radish_lava.png");
protected static ModelKasuga Model;

public RenderRadish(RenderManager renderManager, ModelBase model, float f) {

  super(renderManager, model, f);
}

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
	protected ResourceLocation getEntityTexture(Entity entity)
{
	  return entity.isInLava() ? RadishLavaTextures : RadishTextures;
	}

}