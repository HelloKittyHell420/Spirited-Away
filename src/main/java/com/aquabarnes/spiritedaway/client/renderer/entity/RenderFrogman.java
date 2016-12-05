package com.aquabarnes.spiritedaway.client.renderer.entity;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.client.model.ModelFrogman;
import com.aquabarnes.spiritedaway.entity.EntityFrogman;
import com.aquabarnes.spiritedaway.entity.EntityOotori;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderFrogman extends RenderLiving<EntityFrogman>
{
public static final ResourceLocation FrogmanTextures = new ResourceLocation("sa", "textures/entity/frogman.png");
public static final ResourceLocation FrogmanHatTextures = new ResourceLocation("sa", "textures/entity/frogman_water.png");

protected static ModelFrogman Model;

public RenderFrogman(RenderManager renderManager, ModelBase model, float f) {

	  super(renderManager, model, f);
	}

/**
 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
 */
	@Override
	protected ResourceLocation getEntityTexture(EntityFrogman entity) {
	      
		switch (entity.getFrogmanType())
	        {
	        case 0:
	        default:
	        	return FrogmanTextures;
	        case 1:
	        	return FrogmanHatTextures;
}
}
/**
 * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
 * entityLiving, partialTickTime
 */
	protected void preRenderCallback(EntityFrogman entitylivingbaseIn, float partialTickTime)
{
        if (entitylivingbaseIn.getFrogmanType() == 1)
        {
            GlStateManager.scale(1.2F, 1.2F, 1.2F);
        }
    }

}
