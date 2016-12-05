package com.aquabarnes.spiritedaway.client.model;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.entity.EntityBoh;
import com.aquabarnes.spiritedaway.entity.EntityShikigami;
import com.aquabarnes.spiritedaway.entity.EntitySootball;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelSootball extends ModelBase
{
  //fields
    ModelRenderer Head;
    ModelRenderer LeftLeg;
    ModelRenderer RightLeg;
    ModelRenderer RightArm;
    ModelRenderer LeftArm;
  
  public ModelSootball()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Head = new ModelRenderer(this, 0, 0);
      Head.addBox(0F, 0F, 0F, 28, 25, 28);
      Head.setRotationPoint(-14F, 86F, -14F);
      Head.setTextureSize(128, 64);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      LeftLeg = new ModelRenderer(this, 28, 0);
      LeftLeg.addBox(0F, 0F, 0F, 5, 10, 5);
      LeftLeg.setRotationPoint(-8.6F, 110F, 0F);
      LeftLeg.setTextureSize(128, 64);
      LeftLeg.mirror = true;
      setRotation(LeftLeg, 0F, 0F, 0F);
      RightLeg = new ModelRenderer(this, 28, 0);
      RightLeg.addBox(0F, 0F, 0F, 5, 10, 5);
      RightLeg.setRotationPoint(3.6F, 110F, 0F);
      RightLeg.setTextureSize(128, 64);
      RightLeg.mirror = true;
      setRotation(RightLeg, 0F, 0F, 0F);
      RightArm = new ModelRenderer(this, 28, 0);
      RightArm.addBox(0F, 0F, 0F, 3, 12, 6);
      RightArm.setRotationPoint(14F, 96F, 0F);
      RightArm.setTextureSize(128, 64);
      RightArm.mirror = true;
      setRotation(RightArm, 0F, 0F, 0F);
      LeftArm = new ModelRenderer(this, 28, 0);
      LeftArm.addBox(0F, 0F, 0F, 3, 12, 6);
      LeftArm.setRotationPoint(-17F, 96F, 0F);
      LeftArm.setTextureSize(128, 64);
      LeftArm.mirror = true;
      setRotation(LeftArm, 0F, 0F, 0F);
  }
  
  public void render(Entity entityIn, float p_78088_2_, float limbSwing, float ageInTicks, float netHeadYaw, float headPitch, float scale)
  {
    EntitySootball entitySootball = (EntitySootball)entityIn;
    this.setRotationAngles(p_78088_2_, limbSwing, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
    
    GL11.glPushMatrix();
    
    GL11.glScaled(0.2D, 0.2D, 0.2D);
    this.Head.render(scale);
    this.LeftLeg.render(scale);
    this.RightLeg.render(scale);
    this.RightArm.render(scale);
    this.LeftArm.render(scale);
    
    
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
    this.LeftLeg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount);
    this.RightLeg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + 3.141593F) * limbSwingAmount);
  }
   
  }