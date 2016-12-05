package com.aquabarnes.spiritedaway.client.renderer.entity;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.client.model.ModelKashira;
import com.aquabarnes.spiritedaway.entity.EntityShikigami;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderKashira extends RenderLiving
{
private static final ResourceLocation KashiraTextures = new ResourceLocation("sa:textures/entity/kashira.png");
protected static ModelKashira Model;

public RenderKashira(RenderManager renderManager, ModelBase modelKashira, float f) {

  super(renderManager, modelKashira, f);
}

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return KashiraTextures;
    }
    
    protected void scale(EntityShikigami par1Entity, float par2)
    {
      float f = par1Entity.scaleSize();
      GL11.glScalef(f, f, f);
    }
    
}
