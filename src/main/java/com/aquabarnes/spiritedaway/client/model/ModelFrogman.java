package com.aquabarnes.spiritedaway.client.model;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.entity.EntityFrogman;
import com.aquabarnes.spiritedaway.entity.EntityKashira;
import com.aquabarnes.spiritedaway.entity.EntityOotori;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelFrogman extends ModelBase
{
	  //fields
    ModelRenderer Head;
    ModelRenderer Body;
    ModelRenderer LeftArm;
    ModelRenderer RightArm;
    ModelRenderer LeftHand;
    ModelRenderer RightHand;
    ModelRenderer LeftLeg;
    ModelRenderer RightLeg;
    ModelRenderer HatTop;
    ModelRenderer HatBot;
    ModelRenderer HatMid;
	  
	  public ModelFrogman()
	  {
	    textureWidth = 128;
	    textureHeight = 128;
	    
	    Head = new ModelRenderer(this, 0, 0);
	      Head.addBox(0F, 0F, 0F, 24, 22, 22);
	      Head.setRotationPoint(-12F, -14F, -9F);
	      Head.setTextureSize(128, 128);
	      Head.mirror = true;
	      setRotation(Head, 0F, 0F, 0F);
	      Body = new ModelRenderer(this, 0, 78);
	      Body.addBox(0F, 0F, 0F, 18, 36, 10);
	      Body.setRotationPoint(-9F, 1F, -3F);
	      Body.setTextureSize(128, 128);
	      Body.mirror = true;
	      setRotation(Body, 0F, 0F, 0F);
	      LeftArm = new ModelRenderer(this, 33, 50);
	      LeftArm.addBox(0F, 0F, 0F, 7, 16, 11);
	      LeftArm.setRotationPoint(9F, 8F, -4F);
	      LeftArm.setTextureSize(128, 128);
	      LeftArm.mirror = true;
	      setRotation(LeftArm, 0F, 0F, 0F);
	      RightArm = new ModelRenderer(this, 33, 50);
	      RightArm.addBox(0F, 0F, 0F, 7, 16, 11);
	      RightArm.setRotationPoint(-16F, 8F, -4F);
	      RightArm.setTextureSize(128, 128);
	      RightArm.mirror = true;
	      setRotation(RightArm, 0F, 0F, 0F);
	      LeftHand = new ModelRenderer(this, 93, 0);
	      LeftHand.addBox(0F, 0F, 0F, 6, 2, 9);
	      LeftHand.setRotationPoint(9F, 24F, -3F);
	      LeftHand.setTextureSize(128, 128);
	      LeftHand.mirror = true;
	      setRotation(LeftHand, 0F, 0F, 0F);
	      RightHand = new ModelRenderer(this, 93, 0);
	      RightHand.addBox(0F, 0F, 0F, 6, 2, 9);
	      RightHand.setRotationPoint(-15F, 24F, -3F);
	      RightHand.setTextureSize(128, 128);
	      RightHand.mirror = true;
	      setRotation(RightHand, 0F, 0F, 0F);
	      LeftLeg = new ModelRenderer(this, 0, 45);
	      LeftLeg.addBox(0F, 0F, 0F, 8, 24, 8);
	      LeftLeg.setRotationPoint(0F, 24F, -2F);
	      LeftLeg.setTextureSize(128, 128);
	      LeftLeg.mirror = true;
	      setRotation(LeftLeg, 0F, 0F, 0F);
	      RightLeg = new ModelRenderer(this, 0, 45);
	      RightLeg.addBox(-8F, 0F, -3F, 8, 24, 8);
	      RightLeg.setRotationPoint(0F, 24F, 1F);
	      RightLeg.setTextureSize(128, 128);
	      RightLeg.mirror = true;
	      setRotation(RightLeg, 0F, 0F, 0F);
	      HatTop = new ModelRenderer(this, 57, 54);
	      HatTop.addBox(0F, 0F, 0F, 8, 6, 24);
	      HatTop.setRotationPoint(-4F, -28F, -16F);
	      HatTop.setTextureSize(128, 128);
	      HatTop.mirror = true;
	      setRotation(HatTop, 0F, 0F, 0F);
	      HatBot = new ModelRenderer(this, 56, 102);
	      HatBot.addBox(0F, 0F, 0F, 19, 5, 17);
	      HatBot.setRotationPoint(-9F, -19F, -6F);
	      HatBot.setTextureSize(128, 128);
	      HatBot.mirror = true;
	      setRotation(HatBot, 0F, 0F, 0F);
	      HatMid = new ModelRenderer(this, 56, 84);
	      HatMid.addBox(0F, 0F, 0F, 15, 3, 14);
	      HatMid.setRotationPoint(-7F, -22F, -4F);
	      HatMid.setTextureSize(128, 128);
	      HatMid.mirror = true;
	      setRotation(HatMid, 0F, 0F, 0F);
	  }

	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    EntityFrogman human = (EntityFrogman)entity;
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    
	    if (this.isChild)
        {
	        
		    GL11.glPushMatrix();
		    GL11.glScaled(0.2D, 0.2D, 0.2D);
		    //GL11.glTranslatef(0F, 0.5F, 0F);
		    
	        Head.render(f5);
		    Body.render(f5);
		    LeftArm.render(f5);
		    RightArm.render(f5);
		    LeftHand.render(f5);
		    RightHand.render(f5);
		    LeftLeg.render(f5);
		    RightLeg.render(f5);
		    
		    GL11.glPopMatrix();
        }
	    else
	    	
	    GL11.glPushMatrix();
	    GL11.glScaled(0.5D, 0.5D, 0.5D);
	    //GlStateManager.translate(0.0F, 0.5F, 0.0F);
	    
	    Head.render(f5);
	    Body.render(f5);
	    LeftArm.render(f5);
	    RightArm.render(f5);
	    LeftHand.render(f5);
	    RightHand.render(f5);
	    LeftLeg.render(f5);
	    RightLeg.render(f5);
	    HatTop.render(f5);
	    HatBot.render(f5);
	    HatMid.render(f5);

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
  this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
  this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
  this.RightLeg.rotateAngleY = 0.0F;
  this.LeftLeg.rotateAngleY = 0.0F;
}

}
