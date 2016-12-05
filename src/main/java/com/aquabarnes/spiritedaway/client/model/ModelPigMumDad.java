package com.aquabarnes.spiritedaway.client.model;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.entity.EntityHakuHuman;
import com.aquabarnes.spiritedaway.entity.EntityPigMumDad;

import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPigMumDad extends ModelPig {

	public ModelPigMumDad(float partialTicks) {
		super(partialTicks);
		// TODO Auto-generated constructor stub
	}

public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
{
  EntityPigMumDad human = (EntityPigMumDad)entity;
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
}
}