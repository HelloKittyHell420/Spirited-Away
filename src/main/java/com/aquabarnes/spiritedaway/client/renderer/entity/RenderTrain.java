package com.aquabarnes.spiritedaway.client.renderer.entity;

import com.aquabarnes.spiritedaway.client.model.ModelTrain;
import com.aquabarnes.spiritedaway.entity.EntityTrain;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelDragon;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderTrain extends RenderLiving
{
  private static final ResourceLocation TRAIN_TEXTURE = new ResourceLocation("sa:textures/entity/minecart.png");
  protected static ModelTrain Model;
  
	public RenderTrain(RenderManager renderManager, ModelBase modelTrain, float f) {

		  super(renderManager, modelTrain, f);
		}

		    public RenderTrain(RenderManager renderManager, ModelTrain modelTrain, int f) {
		    	
		    	super(renderManager, modelTrain, f);
	}

			/**
		     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
		     */
			@Override
		    protected ResourceLocation getEntityTexture(Entity entity)
		    {
		        return TRAIN_TEXTURE;
		    }
		    
		    
		}

