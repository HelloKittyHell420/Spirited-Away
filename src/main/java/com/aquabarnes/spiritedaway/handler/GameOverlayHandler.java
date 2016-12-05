package com.aquabarnes.spiritedaway.handler;

import java.awt.Color;
import java.lang.reflect.Proxy;

import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class GameOverlayHandler {

 @SubscribeEvent
 public void onRenderGameOverlay(RenderGameOverlayEvent.Text e) {
 Minecraft mc = Minecraft.getMinecraft();

  if(mc.thePlayer != null) {
	   int fps = Minecraft.getDebugFPS();  
	   long calendar = System.nanoTime();
	   String info = Minecraft.getMinecraft().getSession().getUsername();
	   String server = Proxy.class.getSimpleName();
	   //WorldType id = Minecraft.getMinecraft().thePlayer.worldObj.getWorldType();
			   
	   mc.fontRendererObj.drawString("Spirited Away", 5, 0, 0xCCFFFF);
	   
	   mc.fontRendererObj.drawString("FPS: " + fps, 10, 10, Color.RED.getRGB());
	   
	   mc.fontRendererObj.drawString("Time: " + calendar, 10, 20, Color.GREEN.getRGB());
	   
	   mc.fontRendererObj.drawString("Username: " + info, 10, 30, Color.YELLOW.getRGB());
	   
	   //mc.fontRendererObj.drawString("Dim: " + id, 10, 40, Color.CYAN.getRGB());
	   
	   }
 	  
 }
}