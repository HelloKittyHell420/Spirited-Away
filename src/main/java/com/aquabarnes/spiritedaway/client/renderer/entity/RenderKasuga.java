package com.aquabarnes.spiritedaway.client.renderer.entity;

import com.aquabarnes.spiritedaway.client.model.ModelKasuga;
import com.aquabarnes.spiritedaway.entity.EntityKasuga;
import com.aquabarnes.spiritedaway.renderer.entity.layers.LayerKasuga;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderKasuga extends RenderLiving
{
private static final ResourceLocation KasugaTextures = new ResourceLocation("sa:textures/entity/kasuga.png");
private static final ResourceLocation KasugaMaskTextures = new ResourceLocation("sa:textures/entity/kasuga_head.png");
protected static ModelKasuga Model;

public RenderKasuga(RenderManager renderManager, ModelBase model, float f) {

  super(renderManager, model, f);
  //this.addLayer(new LayerCape(this));
}

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return KasugaTextures;
    }
    
    
}

