package com.aquabarnes.spiritedaway.client.model;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.entity.EntityKasuga;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

public class ModelKasuga extends ModelVillager {

	 private ModelRenderer Head;
	  
	    public ModelKasuga()
	    {
	    	super(0.5F);
	    	
	    	textureWidth = 64;
	    	textureHeight = 64;
	    	    
	      
	        Head = new ModelRenderer(this, 0, 0);
	        Head.addBox(0F, 0F, 0F, 22, 32, 2);
	        Head.setRotationPoint(-11F, -28F, -8F);
	        Head.setTextureSize(64, 64);
	        Head.mirror = true;
	        setRotation(Head, 0F, 0F, 0F);
	    }	  
	  
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
		EntityKasuga human = (EntityKasuga)entity;
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
	    
	    GL11.glPushMatrix();

	    GL11.glScaled(0.365D, 0.355D, 0.5D);
	    GL11.glTranslated(0D, 0D, 0D);
	    GlStateManager.translate(0.0F, 0.0F, 0.0F);
	    this.Head.render(f5);
	    
	    GL11.glPopMatrix();
	  }

	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }

	  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
	  }

	  }