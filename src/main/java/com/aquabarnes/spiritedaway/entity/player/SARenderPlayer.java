package com.aquabarnes.spiritedaway.entity.player;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerArrow;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerCape;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerDeadmau5Head;
import net.minecraft.client.renderer.entity.layers.LayerElytra;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;

public class SARenderPlayer extends RenderPlayer {
	
	private ModelBiped modelBiped;
	
	public SARenderPlayer()
	  {
		//HATS/MASKS
	    this.modelBiped = new ModelHat(0.6F);
	    this.modelBiped = new Model
	    //ELYTRAS
	    this.modelBiped(new LayerElytra(this));
	    //SKULLS
        this.modelBiped(new LayerSkull(this.getMainModel().bipedHead));
	    
	  }
	//TODO:UUID's
	else if entity.UUID.fromString("13655ac1-584d-4785-b227-650308195121"));
	
	else if ((entity.getName().equals("AquaBarnes")) && ((!(entity instanceof EntityPlayer)) || (!entity.isUser())))
	else if ((entity.getName().equals("Karzia")) && ((!(entity instanceof EntityPlayer)) || (!entity.isUser())))
    else if ((entity.getName().equals("Spacedragonz")) && ((!(entity instanceof EntityPlayer)) || (!entity.isUser())))
	else if ((entity.getName().equals("BenBuck")) && ((!(entity instanceof EntityPlayer)) || (!entity.isUser())))
}