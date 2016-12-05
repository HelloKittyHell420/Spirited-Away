package com.aquabarnes.spiritedaway.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelDragon;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderZenbia extends RenderLiving {

		private static final ResourceLocation KasugaTextures = new ResourceLocation("textures/entity/witch.png");
		protected static ModelDragon Model;


		public RenderZenbia(RenderManager renderManager, ModelBase model, float f) {

		  super(renderManager, model, f);
		}

		    /**
		     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
		     */
			@Override
		    protected ResourceLocation getEntityTexture(Entity entity)
		    {
		        return KasugaTextures;
		    }
		    
		    
		}

