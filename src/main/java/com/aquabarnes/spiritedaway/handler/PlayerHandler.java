package com.aquabarnes.spiritedaway.handler;

import java.util.Random;


import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class PlayerHandler {

	@SubscribeEvent
	public void onEntityInteract(EntityInteract e) {
		
	}

	@SubscribeEvent
	public void onPlayerTickEvent(PlayerTickEvent e) {
		
	}
	
	@SubscribeEvent
	public void onPlayerLogout(PlayerLoggedOutEvent e) {
		
		EntityPlayer player = e.player;

		TextComponentString prefix = new TextComponentString(TextFormatting.DARK_RED + "Bye");
	    player.addChatComponentMessage(prefix);
	}
	
	//@SubscribeEvent
	//public void onRenderPlayer(RenderPlayeEvent.Specials.Pre e) {
		
		//TODO: HATS/CUSTOMELYTRAS/PATERONBADGE?/CUSTOMSKIN?
		
	//}

	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent e) {
  
		EntityPlayer player = e.player;
		//GameProfile.class.getName().substring() name = name;
		if (!player.worldObj.isRemote && SAConfiguration.welcomeMessage)
    {
    TextComponentString prefix = new TextComponentString(TextFormatting.DARK_RED + "Thank you for downloading The Spirited Away Mod");
    player.addChatComponentMessage(prefix);
    
    Random rand = new Random();
    int sel = rand.nextInt(3);
    switch (sel) 
    {
    case 1: 
      player.addChatComponentMessage(new TextComponentString(TextFormatting.RED + "Make sure you check out the website"));
      TextComponentString url = new TextComponentString(TextFormatting.BOLD + ("[Website IP]"));
      player.addChatComponentMessage(url);
      break;
    case 2: 
      player.addChatComponentMessage(new TextComponentString(TextFormatting.RED + ("Want to suggest some ideas for the mod?")));
      TextComponentString url1 = new TextComponentString(TextFormatting.BOLD + ("[Website IP]"));
      player.addChatComponentMessage(url1);
    case 3: 
      //TODO Add a auto updater for the mod. May do this in AquaBarnesUtils
      player.addChatComponentMessage(new TextComponentString(TextFormatting.RED + ("Auto Update.....TODO TODO TODO TODO")));
      TextComponentString url11 = new TextComponentString(TextFormatting.BOLD + ("[Website IP]"));
      player.addChatComponentMessage(url11);
    }
  }
}
}