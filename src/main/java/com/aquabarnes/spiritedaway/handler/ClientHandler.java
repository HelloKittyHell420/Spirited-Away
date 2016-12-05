package com.aquabarnes.spiritedaway.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ClientHandler {

	@SubscribeEvent
	public void onClientTick(ClientTickEvent e) {
	  if(KeyHandler.ASCEND_KEY.isKeyDown()) {
		  Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new TextComponentString("Just Dance!" + KeyHandler.ASCEND_KEY.getKeyDescription()));
		  //Minecraft.getMinecraft().displayGuiScreen(new GuiTest());
	  }
	}
} 		