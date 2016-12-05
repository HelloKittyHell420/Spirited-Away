package com.aquabarnes.spiritedaway.client.renderer.entity;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.client.model.ModelOotori;
import com.aquabarnes.spiritedaway.entity.EntityOotori;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.util.ResourceLocation;

public class RenderOotori extends RenderLiving
{
public final ResourceLocation OotoriTextures = new ResourceLocation("sa", "textures/entity/ootori_water.png");

protected static ModelOotori Model;

public RenderOotori(RenderManager renderManager, ModelBase model, float f) {

	  super(renderManager, model, f);
	}

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity entity)
    {
    	  return OotoriTextures;
    }
    
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityOotori entitylivingbaseIn, float partialTickTime)
    {
       
    }
}
