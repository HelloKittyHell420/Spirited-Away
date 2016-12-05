package com.aquabarnes.spiritedaway.client.model;

import com.aquabarnes.spiritedaway.entity.EntityChihiro;
import com.aquabarnes.spiritedaway.entity.EntityOotori;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBipedBase extends ModelBase {

	    ModelRenderer Head;
	    ModelRenderer Body;
	    ModelRenderer RightArm;
	    ModelRenderer LeftArm;
	    ModelRenderer RightLeg;
	    ModelRenderer LeftLeg;
	  
	  public ModelBipedBase()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      Head = new ModelRenderer(this, 0, 0);
	      Head.addBox(-4F, -8F, -4F, 8, 8, 8);
	      Head.setRotationPoint(0F, 0F, 0F);
	      Head.setTextureSize(64, 32);
	      Head.mirror = true;
	      setRotation(Head, 0F, 0F, 0F);
	      Body = new ModelRenderer(this, 16, 16);
	      Body.addBox(-4F, 0F, -2F, 8, 12, 4);
	      Body.setRotationPoint(0F, 0F, 0F);
	      Body.setTextureSize(64, 32);
	      Body.mirror = true;
	      setRotation(Body, 0F, 0F, 0F);
	      RightArm = new ModelRenderer(this, 40, 16);
	      RightArm.addBox(-3F, -2F, -2F, 4, 12, 4);
	      RightArm.setRotationPoint(-5F, 2F, 0F);
	      RightArm.setTextureSize(64, 32);
	      RightArm.mirror = true;
	      setRotation(RightArm, 0F, 0F, 0F);
	      LeftArm = new ModelRenderer(this, 40, 16);
	      LeftArm.addBox(-1F, -2F, -2F, 4, 12, 4);
	      LeftArm.setRotationPoint(5F, 2F, 0F);
	      LeftArm.setTextureSize(64, 32);
	      setRotation(LeftArm, 0F, 0F, 0F);
	      LeftArm.mirror = true;
	      RightLeg = new ModelRenderer(this, 0, 16);
	      RightLeg.addBox(-2F, 0F, -2F, 4, 12, 4);
	      RightLeg.setRotationPoint(-2F, 12F, 0F);
	      RightLeg.setTextureSize(64, 32);
	      RightLeg.mirror = true;
	      setRotation(RightLeg, 0F, 0F, 0F);
	      LeftLeg = new ModelRenderer(this, 0, 16);
	      LeftLeg.addBox(-2F, 0F, -2F, 4, 12, 4);
	      LeftLeg.setRotationPoint(2F, 12F, 0F);
	      LeftLeg.setTextureSize(64, 32);
	      LeftLeg.mirror = true;
	      setRotation(LeftLeg, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entityIn, float p_78088_2_, float limbSwing, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	    {  
	    //EntityOotori entityOotori = (EntityOotori)entityIn;
		this.setRotationAngles(p_78088_2_, limbSwing, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		
	    
	    Head.render(scale);
	    Body.render(scale);
	    RightArm.render(scale);
	    LeftArm.render(scale);
	    RightLeg.render(scale);
	    LeftLeg.render(scale);
	  }
	  
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	  model.rotateAngleX = x;
	  model.rotateAngleY = y;
	  model.rotateAngleZ = z;
	  }
	  
	  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	  {
	    //super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.Body.rotateAngleY = 0.0F;
        this.RightArm.rotationPointZ = 0.0F;
        this.RightArm.rotationPointX = -5.0F;
        this.LeftArm.rotationPointZ = 0.0F;
        this.LeftArm.rotationPointX = 5.0F;
	  }

}