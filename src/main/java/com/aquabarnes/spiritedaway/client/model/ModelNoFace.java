package com.aquabarnes.spiritedaway.client.model;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.entity.EntityNoFace;
import com.aquabarnes.spiritedaway.entity.EntityShikigami;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNoFace extends ModelBase
{
  //fields
    ModelRenderer Head;
    ModelRenderer Head2;
    ModelRenderer Head3;
    ModelRenderer Head4;
  
  public ModelNoFace()
  {
	    textureWidth = 128;
	    textureHeight = 128;
	    
	      Head = new ModelRenderer(this, 0, 7);
	      Head.addBox(0F, 0F, 0F, 23, 98, 23);
	      Head.setRotationPoint(-12F, -52F, -11F);
	      Head.setTextureSize(128, 128);
	      Head.mirror = true;
	      setRotation(Head, 0F, 0F, 0F);
	      Head2 = new ModelRenderer(this, 1, 4);
	      Head2.addBox(0F, 0F, 0F, 21, 3, 23);
	      Head2.setRotationPoint(-11F, -55F, -11F);
	      Head2.setTextureSize(128, 128);
	      Head2.mirror = true;
	      setRotation(Head2, 0F, 0F, 0F);
	      Head3 = new ModelRenderer(this, 3, 2);
	      Head3.addBox(0F, 0F, 0F, 17, 2, 23);
	      Head3.setRotationPoint(-9F, -57F, -11F);
	      Head3.setTextureSize(128, 128);
	      Head3.mirror = true;
	      setRotation(Head3, 0F, 0F, 0F);
	      Head4 = new ModelRenderer(this, 0, 103);
	      Head4.addBox(0F, 0F, 0F, 13, 2, 23);
	      Head4.setRotationPoint(-7F, -59F, -11F);
	      Head4.setTextureSize(128, 128);
	      Head4.mirror = true;
	      setRotation(Head4, 0F, 0F, 0F);

	  }
	  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    EntityNoFace human = (EntityNoFace)entity;
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    
    GL11.glPushMatrix();
    
    GL11.glEnable(3042);
    float transparency = 0.6F;
    GL11.glBlendFunc(770, 771);
    GL11.glColor4f(0.8F, 0.8F, 0.8F, transparency);
    GL11.glTranslated(0D, 0.19D, 0D);
    GL11.glScaled(0.5D, 0.45D, 0.5D);
    Head.render(f5);
    Head2.render(f5);
    Head3.render(f5);
    Head4.render(f5);
    GL11.glDisable(3042);
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