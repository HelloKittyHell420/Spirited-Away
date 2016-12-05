package com.aquabarnes.spiritedaway.client.renderer.entity;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.client.model.ModelNoFace;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderNoFace extends RenderLiving
{
public final ResourceLocation NOFACETEXTURE = new ResourceLocation("sa", "textures/entity/noface.png");
public final ResourceLocation NOFACEANGRYTEXTURE = new ResourceLocation("sa", "textures/entity/noface_angry.png");

protected static ModelNoFace Model;

public RenderNoFace(RenderManager renderManager, ModelBase model, float f) {

  super(renderManager, model, f);
}

/**
 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
 */
protected ResourceLocation getEntityTexture(Entity entity)
{
	  return entity.isBurning() ? NOFACEANGRYTEXTURE : NOFACETEXTURE;
	}

}
