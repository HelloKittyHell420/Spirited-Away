package com.aquabarnes.spiritedaway.client.renderer.entity;

import org.lwjgl.opengl.GL11;


import com.aquabarnes.spiritedaway.client.model.ModelShikigami;
import com.aquabarnes.spiritedaway.entity.EntityShikigami;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderSootball extends RenderLiving
{
private static final ResourceLocation SootballTextures = new ResourceLocation("sa:textures/entity/sootball.png");
private static final ResourceLocation SootballBlueTextures = new ResourceLocation("sa:textures/entity/sootball_blue.png");
private static final ResourceLocation SootballChristmasTextures = new ResourceLocation("sa:textures/entity/sootball.png");
protected static ModelShikigami Model;

public RenderSootball(RenderManager renderManager, ModelBase modelShikigami, float f) {

  super(renderManager, modelShikigami, f);
  this.addLayer(new LayerHeldItem(this));
}

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity entity)
    {
    	if (entity.hasCustomName() && "AquaBarnes".equals(entity.getCustomNameTag()))
        {
    		this.bindTexture(SootballBlueTextures);
        }
		return SootballTextures;
    }
    
    protected void scale(EntityShikigami par1Entity, float par2)
    {
      float f = par1Entity.scaleSize();
      GL11.glScalef(f, f, f);
    }
    
}
