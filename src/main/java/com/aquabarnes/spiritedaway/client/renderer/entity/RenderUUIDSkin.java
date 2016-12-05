package com.aquabarnes.spiritedaway.client.renderer.entity;

import java.util.Map;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

import java.util.HashMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderUUIDSkin extends RenderLiving {

	public static final ResourceLocation SteveSkin = new ResourceLocation("sa:textures/entity/Steve.png");
	public static final ResourceLocation AlexSkin = new ResourceLocation("sa:textures/entity/Alex.png");

	public RenderUUIDSkin(RenderManager renderManager, ModelBase model, float f) {

			  super(renderManager, model, f);
			}  
  
	 public static String getSkinUrl(String username)
	  {
	    return String.format("http://skins.minecraft.net/MinecraftSkins/%s.png", new Object[] { StringUtils.stripControlCodes(username) });
	  }
	  
	  public static ResourceLocation getSkinResourceLocation(String username)
	  {
	    return new ResourceLocation("skins/" + StringUtils.stripControlCodes(username));
	  }
	 

		@Override
		protected ResourceLocation getEntityTexture(Entity entity) {

		Minecraft.getMinecraft().getSessionService();
		//if(false) this.bindTexture(this.AlexSkin);
		
		return SteveSkin;
	    
	}
}
