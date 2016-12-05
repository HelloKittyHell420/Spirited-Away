package com.aquabarnes.spiritedaway.client.model;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.entity.EntityHakuDragon;
import com.aquabarnes.spiritedaway.entity.EntityHakuHuman;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelHakuHuman extends ModelBiped {

public ModelHakuHuman() {
		super();
		// TODO Auto-generated constructor stub
	}

public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
{
  EntityHakuHuman human = (EntityHakuHuman)entity;
  super.render(entity, f, f1, f2, f3, f4, f5);
  setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  
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
	 this.bipedHead.rotateAngleY = netHeadYaw * 0.017453292F;

     this.bipedHead.rotateAngleX = -((float)Math.PI / 4F);

     this.bipedHead.rotateAngleX = headPitch * 0.017453292F;
	
	
    float f = 1.0F;

    {
        f = (float)(entityIn.motionX * entityIn.motionX + entityIn.motionY * entityIn.motionY + entityIn.motionZ * entityIn.motionZ);
        f = f / 0.2F;
        f = f * f * f;
    }

    if (f < 1.0F)
    {
        f = 1.0F;
    }

    this.bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
    this.bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
    this.bipedRightArm.rotateAngleZ = 0.0F;
    this.bipedLeftArm.rotateAngleZ = 0.0F;
    this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
    this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
    this.bipedRightLeg.rotateAngleY = 0.0F;
    this.bipedLeftLeg.rotateAngleY = 0.0F;
    this.bipedRightLeg.rotateAngleZ = 0.0F;
    this.bipedLeftLeg.rotateAngleZ = 0.0F;

}

}
