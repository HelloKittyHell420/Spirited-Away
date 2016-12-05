package com.aquabarnes.spiritedaway.client.model;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.entity.EntitySootball;
import com.aquabarnes.spiritedaway.entity.EntityTrain;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelTrain extends ModelBase
{
	  //fields
	  
	  public ModelTrain()
	  {
	    textureWidth = 350;
	    textureHeight = 350;
	    
	  }
	  
	  public void render(Entity entityIn, float p_78088_2_, float limbSwing, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	  {
	    EntityTrain entityTrain = (EntityTrain)entityIn;
	    this.setRotationAngles(p_78088_2_, limbSwing, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
	    
	    GL11.glPushMatrix();
	    
	    
	    GL11.glPopMatrix();
	  }
	  
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
	  
	  
	  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	  {   
	   
	  }
	}
