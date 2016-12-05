package com.aquabarnes.spiritedaway.client.renderer.entity;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.client.model.ModelShikigami;
import com.aquabarnes.spiritedaway.entity.EntityShikigami;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderShikigami extends RenderLiving
{
private static final ResourceLocation ShikigamiTextures = new ResourceLocation("sa:textures/entity/shikigami.png");
protected static ModelShikigami Model;

public RenderShikigami(RenderManager renderManager, ModelBase modelShikigami, float f) {

  super(renderManager, modelShikigami, f);
}

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return ShikigamiTextures;
    }
    
    protected void scale(EntityShikigami par1Entity, float par2)
    {
      float f = par1Entity.scaleSize();
      GL11.glScalef(f, f, f);
    }
    
}
