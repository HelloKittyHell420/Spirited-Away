package com.aquabarnes.spiritedaway.client.model;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.entity.EntityShikigami;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelShikigami extends ModelBase
{
    //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
  
  public ModelShikigami()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape1.setRotationPoint(0F, 19F, 0F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 3, 1, 1);
      Shape2.setRotationPoint(-1F, 20F, 0F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(0F, 0F, -1F, 1, 3, 1);
      Shape3.setRotationPoint(0F, 21F, 1F);
      Shape3.setTextureSize(32, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
  }
  

public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
{
  EntityShikigami human = (EntityShikigami)entity;
  super.render(entity, f, f1, f2, f3, f4, f5);
  setRotationAngles(f, f1, f2, f3, f4, f5);
  
  GL11.glPushMatrix();
  
  GL11.glEnable(3042);
  float transparency = 0.6F;
  GL11.glBlendFunc(770, 771);
  GL11.glColor4f(0.8F, 0.8F, 0.8F, transparency);
  this.Shape1.render(f5);
  this.Shape2.render(f5);
  this.Shape3.render(f5);
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
