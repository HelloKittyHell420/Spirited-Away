package com.aquabarnes.spiritedaway.client.model;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.entity.EntityOotori;
import com.aquabarnes.spiritedaway.entity.EntityRadish;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRadish
extends ModelBase
{
	  //fields
    ModelRenderer Head;
    ModelRenderer LeftLeg;
    ModelRenderer RightLeg;
    ModelRenderer HatMid;
    ModelRenderer LeftB;
    ModelRenderer RightB;
    ModelRenderer Body;
    ModelRenderer HatBot;
    ModelRenderer Leaf;
    ModelRenderer BodyBle;
    ModelRenderer BobyBle2;
    ModelRenderer BobyBle3;
    ModelRenderer BobyBle4;
    ModelRenderer BodyBle5;
    ModelRenderer LeftArm;
    ModelRenderer RightArm;
	  
    public ModelRadish()
		  {
    	textureWidth = 256;
        textureHeight = 256;
        
        Head = new ModelRenderer(this, 0, 0);
        Head.addBox(0F, 0F, 0F, 24, 22, 22);
        Head.setRotationPoint(-12F, -38F, -9F);
        Head.setTextureSize(64, 32);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        LeftLeg = new ModelRenderer(this, 93, 47);
        LeftLeg.addBox(0F, 0F, 0F, 8, 24, 8);
        LeftLeg.setRotationPoint(0F, 0F, -2F);
        LeftLeg.setTextureSize(64, 32);
        LeftLeg.mirror = true;
        setRotation(LeftLeg, 0F, 0F, 0F);
        RightLeg = new ModelRenderer(this, 93, 47);
        RightLeg.addBox(-8F, 0F, 0F, 8, 24, 8);
        RightLeg.setRotationPoint(0F, 0F, -2F);
        RightLeg.setTextureSize(64, 32);
        RightLeg.mirror = true;
        setRotation(RightLeg, 0F, 0F, 0F);
        HatMid = new ModelRenderer(this, 190, 66);
        HatMid.addBox(0F, 0F, 0F, 16, 6, 16);
        HatMid.setRotationPoint(-8F, -48F, -6F);
        HatMid.setTextureSize(64, 32);
        HatMid.mirror = true;
        setRotation(HatMid, 0F, 0F, 0F);
        LeftB = new ModelRenderer(this, 93, 0);
        LeftB.addBox(0F, 0F, 0F, 10, 28, 8);
        LeftB.setRotationPoint(4F, -26F, -12F);
        LeftB.setTextureSize(64, 32);
        LeftB.mirror = true;
        setRotation(LeftB, 0F, 0F, 0F);
        RightB = new ModelRenderer(this, 93, 0);
        RightB.addBox(0F, 0F, 0F, 10, 28, 8);
        RightB.setRotationPoint(-14F, -26F, -12F);
        RightB.setTextureSize(64, 32);
        RightB.mirror = true;
        setRotation(RightB, 0F, 0F, 0F);
        Body = new ModelRenderer(this, 0, 73);
        Body.addBox(0F, 2F, 0F, 18, 38, 11);
        Body.setRotationPoint(-9F, -19F, -4F);
        Body.setTextureSize(64, 32);
        Body.mirror = true;
        setRotation(Body, 0F, 0F, 0F);
        HatBot = new ModelRenderer(this, 142, 0);
        HatBot.addBox(-14F, -42F, -12F, 28, 4, 28);
        HatBot.setRotationPoint(0F, 0F, 0F);
        HatBot.setTextureSize(64, 32);
        HatBot.mirror = true;
        setRotation(HatBot, 0F, 0F, 0F);
        Leaf = new ModelRenderer(this, 142, 32);
        Leaf.addBox(-14F, -42F, -12F, 28, 5, 28);
        Leaf.setRotationPoint(0F, 4F, 0F);
        Leaf.setTextureSize(64, 32);
        Leaf.mirror = true;
        setRotation(Leaf, 0F, 0F, 0F);
        BodyBle = new ModelRenderer(this, 0, 49);
        BodyBle.addBox(0F, 0F, 0F, 20, 1, 15);
        BodyBle.setRotationPoint(-10F, -3F, -6F);
        BodyBle.setTextureSize(64, 32);
        BodyBle.mirror = true;
        setRotation(BodyBle, 0F, 0F, 0F);
        BobyBle2 = new ModelRenderer(this, 0, 122);
        BobyBle2.addBox(0F, 0F, 0F, 22, 20, 19);
        BobyBle2.setRotationPoint(-11F, -2F, -8F);
        BobyBle2.setTextureSize(64, 32);
        BobyBle2.mirror = true;
        setRotation(BobyBle2, 0F, 0F, 0F);
        BobyBle3 = new ModelRenderer(this, 0, 161);
        BobyBle3.addBox(0F, 0F, 0F, 24, 15, 23);
        BobyBle3.setRotationPoint(-12F, 0F, -10F);
        BobyBle3.setTextureSize(64, 32);
        BobyBle3.mirror = true;
        setRotation(BobyBle3, 0F, 0F, 0F);
        BobyBle4 = new ModelRenderer(this, 0, 199);
        BobyBle4.addBox(0F, 0F, 0F, 17, 12, 26);
        BobyBle4.setRotationPoint(-8F, 1F, -11.5F);
        BobyBle4.setTextureSize(64, 32);
        BobyBle4.mirror = true;
        setRotation(BobyBle4, 0F, 0F, 0F);
        BodyBle5 = new ModelRenderer(this, 105, 201);
        BodyBle5.addBox(0F, 0F, 0F, 11, 9, 27);
        BodyBle5.setRotationPoint(-5F, 3F, -12.5F);
        BodyBle5.setTextureSize(64, 32);
        BodyBle5.mirror = true;
        setRotation(BodyBle5, 0F, 0F, 0F);
        LeftArm = new ModelRenderer(this, 93, 0);
        LeftArm.addBox(0F, 0F, 0F, 10, 28, 8);
        LeftArm.setRotationPoint(4F, -16F, -3F);
        LeftArm.setTextureSize(64, 32);
        LeftArm.mirror = true;
        setRotation(LeftArm, 0F, 0F, -0.0743572F);
        RightArm = new ModelRenderer(this, 93, 0);
        RightArm.addBox(-10F, 0F, 0F, 10, 28, 8);
        RightArm.setRotationPoint(-4F, -16F, -3F);
        RightArm.setTextureSize(64, 32);
        RightArm.mirror = true;
        setRotation(RightArm, 0F, 0F, 0.074351F);
		  }

	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    EntityRadish human = (EntityRadish)entity;
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
	    
	    GL11.glPushMatrix();
	    GL11.glScaled(0.5D, 0.5D, 0.5D);
	    GL11.glTranslated(0D, 1.5D, 0D);
	    
	    Head.render(f5);
	    LeftLeg.render(f5);
	    RightLeg.render(f5);
	    HatMid.render(f5);
	    LeftB.render(f5);
	    RightB.render(f5);
	    Body.render(f5);
	    HatBot.render(f5);   
	    BodyBle.render(f5);
	    BobyBle2.render(f5);
	    BobyBle3.render(f5);
	    BobyBle4.render(f5);
	    BodyBle5.render(f5);
	    LeftArm.render(f5);
	    RightArm.render(f5);
	    GL11.glPopMatrix();
	    
	    GL11.glPushMatrix();
	    GL11.glScaled(0.5D, 0.5D, 0.5D);
	    GL11.glTranslated(0D, 1.5D, 0D);
	    GL11.glEnable(3042);
	    float transparency = 0.9F;
	    GL11.glBlendFunc(770, 771);
	    GL11.glColor4f(0.8F, 0.8F, 0.8F, transparency);
	    Leaf.render(f5);
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
