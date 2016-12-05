package com.aquabarnes.spiritedaway.client.model;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.entity.EntityNoFace;
import com.aquabarnes.spiritedaway.entity.EntityOotori;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.math.MathHelper;

public class ModelOotori extends ModelBase
{
	  //fields
	    ModelRenderer Top;
	    ModelRenderer Top2;
	    ModelRenderer Top3;
	    ModelRenderer Top4;
	    ModelRenderer Top5;
	    ModelRenderer Bottom;
	    ModelRenderer LeftArm;
	    ModelRenderer RightArm;
	    ModelRenderer Mouth;
	    ModelRenderer Mouth2;
	    ModelRenderer Tail;
	    ModelRenderer Leaf;
	    ModelRenderer Stem;
	  
	  public ModelOotori()
	  {
	    textureWidth = 512;
	    textureHeight = 512;
	    
	      Top = new ModelRenderer(this, 0, 0);
	      Top.addBox(0F, 0F, 0F, 24, 2, 20);
	      Top.setRotationPoint(-12F, -16F, -8F);
	      Top.setTextureSize(512, 512);
	      Top.mirror = true;
	      //setRotation(Top, 0F, 0F, 0F);
	      Top2 = new ModelRenderer(this, 0, 36);
	      Top2.addBox(0F, 0F, 0F, 28, 6, 28);
	      Top2.setRotationPoint(-14F, -14F, -14F);
	      Top2.setTextureSize(512, 512);
	      Top2.mirror = true;
	      //setRotation(Top2, 0F, 0F, 0F);
	      Top3 = new ModelRenderer(this, 0, 87);
	      Top3.addBox(0F, 0F, 0F, 32, 16, 30);
	      Top3.setRotationPoint(-16F, -8F, -14F);
	      Top3.setTextureSize(512, 512);
	      Top3.mirror = true;
	      //setRotation(Top3, 0F, 0F, 0F);
	      Top4 = new ModelRenderer(this, 0, 141);
	      Top4.addBox(0F, 0F, 0F, 36, 12, 34);
	      Top4.setRotationPoint(-18F, 2F, -16F);
	      Top4.setTextureSize(512, 512);
	      Top4.mirror = true;
	      //setRotation(Top4, 0F, 0F, 0F);
	      Top5 = new ModelRenderer(this, 0, 203);
	      Top5.addBox(0F, 0F, 0F, 40, 30, 38);
	      Top5.setRotationPoint(-20F, 14F, -18F);
	      Top5.setTextureSize(512, 512);
	      Top5.mirror = true;
	      //setRotation(Top5, 0F, 0F, 0F);
	      Bottom = new ModelRenderer(this, 0, 287);
	      Bottom.addBox(0F, 0F, 0F, 36, 4, 34);
	      Bottom.setRotationPoint(-18F, 44F, -16F);
	      Bottom.setTextureSize(512, 512);
	      Bottom.mirror = true;
	      //setRotation(Bottom, 0F, 0F, 0F);
	      LeftArm = new ModelRenderer(this, 200, 0);
	      LeftArm.addBox(-2F, 0F, -7F, 6, 28, 14);
	      LeftArm.setRotationPoint(-16F, 3F, 7F);
	      LeftArm.setTextureSize(512, 512);
	      LeftArm.mirror = true;
	      //setRotation(ArmLeft, 0.0174533F, 0F, 0.2602503F);
	      RightArm = new ModelRenderer(this, 200, 0);
	      RightArm.addBox(-3F, 0F, -7F, 6, 28, 14);
	      RightArm.setRotationPoint(15F, 4F, 7F);
	      RightArm.setTextureSize(512, 512);
	      RightArm.mirror = true;
	      //setRotation(ArmRight, 0F, 0F, -0.260246F);
	      Mouth = new ModelRenderer(this, 244, 0);
	      Mouth.addBox(0F, 0F, 0F, 8, 5, 4);
	      Mouth.setRotationPoint(-4F, -8F, -18F);
	      Mouth.setTextureSize(512, 512);
	      Mouth.mirror = true;
	      //setRotation(Mouth, 0F, 0F, 0F);
	      Mouth2 = new ModelRenderer(this, 107, 0);
	      Mouth2.addBox(0F, 0F, 0F, 18, 2, 1);
	      Mouth2.setRotationPoint(-9F, -6F, -15F);
	      Mouth2.setTextureSize(512, 512);
	      Mouth2.mirror = true;
	      //setRotation(Mouth2, 0F, 0F, 0F);
	      Tail = new ModelRenderer(this, 154, 7);
	      Tail.addBox(0F, 0F, 0F, 12, 12, 8);
	      Tail.setRotationPoint(-6F, 28F, 20F);
	      Tail.setTextureSize(512, 512);
	      Tail.mirror = true;
	      //setRotation(Tail, 0F, 0F, 0F);
	      Leaf = new ModelRenderer(this, 283, 0);
	      Leaf.addBox(0F, -41F, 0F, 28, 0, 26);
	      Leaf.setRotationPoint(-14F, 24.8F, -11F);
	      Leaf.setTextureSize(512, 512);
	      Leaf.mirror = true;
	      //setRotation(Leaf, 0F, 0F, 0F);
	      Stem = new ModelRenderer(this, 318, 4);
	      Stem.addBox(0F, 0F, 0F, 2, 4, 2);
	      Stem.setRotationPoint(-1F, -20F, 3F);
	      Stem.setTextureSize(512, 512);
	      Stem.mirror = true;
	      //setRotation(Stem, 0F, 0F, 0F);
	  }
  
	    public void render(Entity entityIn, float p_78088_2_, float limbSwing, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	    {  
	    	EntityOotori entityOotori = (EntityOotori)entityIn;
	    	boolean isFly = entityOotori.isInWater();
			this.setRotationAngles(p_78088_2_, limbSwing, ageInTicks, netHeadYaw, headPitch, scale, entityIn, isFly);
		
	    GL11.glPushMatrix();
	    GL11.glScaled(0.5D, 0.5D, 0.5D);
	    
	    this.Top.render(scale);
	    this.Top2.render(scale);
	    this.Top3.render(scale);
	    this.Top4.render(scale);
	    this.Top5.render(scale);
	    this.LeftArm.render(scale);
	    this.RightArm.render(scale);
	    this.Mouth.render(scale);
	    this.Mouth2.render(scale);
	    this.Bottom.render(scale);
	    this.Leaf.render(scale);
	    this.Stem.render(scale);

	    GL11.glPopMatrix();
	  }

	    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn, boolean isFly)
	    {
	    	
		EntityOotori entityOotori = (EntityOotori)entityIn; 
	  	
        if (isFly)
	    {
	      Float WingRot = Float.valueOf(MathHelper.cos(limbSwingAmount* 1.4F + 3.141593F) * 0.6F);
	      this.RightArm.rotateAngleZ = (0.1F + WingRot.floatValue());
	      this.LeftArm.rotateAngleZ = (-0.1F - WingRot.floatValue());
	      
	    } 
	    else 
	    {
		  	  this.RightArm.rotateAngleZ  = -0.2F;
		  	  this.LeftArm.rotateAngleZ = 0.2F;
	    }
	    {
	      
  }
  }
}
