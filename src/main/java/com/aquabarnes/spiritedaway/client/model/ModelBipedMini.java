package com.aquabarnes.spiritedaway.client.model;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.entity.EntityAkiichiro;
import com.aquabarnes.spiritedaway.entity.EntityRadish;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBipedMini extends ModelBiped {

private ModelRenderer bipedCape;
private ModelRenderer bipedDeadmau5Head;	
	
public ModelBipedMini(float modelSize, boolean smallArmsIn)
{
    super();
    this.bipedDeadmau5Head = new ModelRenderer(this, 24, 0);
    this.bipedDeadmau5Head.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, modelSize);
    this.bipedCape = new ModelRenderer(this, 0, 0);
    this.bipedCape.setTextureSize(64, 32);
    this.bipedCape.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, modelSize);
}

public void render(Entity entityIn, float p_78088_2_, float limbSwing, float ageInTicks, float netHeadYaw, float headPitch, float scale)
{
	this.setRotationAngles(p_78088_2_, limbSwing, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
	
	GL11.glPushMatrix();
    GL11.glScaled(0.1D, 0.1D, 0.1D);
    GL11.glTranslated(0D, 13.5D, 0D);
    this.bipedHead.render(scale);
    this.bipedBody.render(scale);
    this.bipedRightArm.render(scale);
    this.bipedLeftArm.render(scale);
    this.bipedRightLeg.render(scale);
    this.bipedLeftLeg.render(scale);
    this.bipedHeadwear.render(scale);
    
    this.bipedDeadmau5Head.render(scale);
    this.bipedCape.render(scale);
    
	GL11.glPopMatrix();
	
}
}