package com.aquabarnes.spiritedaway.init;

import java.awt.Color;


import java.io.PrintStream;
import java.lang.reflect.Proxy;

import com.aquabarnes.spiritedaway.SpiritedAway;
import com.aquabarnes.spiritedaway.client.main_menu.GuiSpiritedAwayMenu;
import com.aquabarnes.spiritedaway.handler.ClientHandler;
import com.aquabarnes.spiritedaway.handler.GameOverlayHandler;
import com.aquabarnes.spiritedaway.handler.PlayerHandler;
import com.aquabarnes.spiritedaway.handler.PotionReplenishHandler;
import com.aquabarnes.spiritedaway.handler.SAConfiguration;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftSessionService;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.ClickEvent.Action;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;

public class SAEventHandler
{ 
	  public static void init()
	  {
	    registerWorldEventHandlers();
	    registerEntityEventHandlers();
	    registerPotionEventHandlers();
	    registerEntityEventHandlers();
	    
	    if (SpiritedAway.isClient())
	    {
	    	registerClientEventHandlers();
	    }
	  }
	  
    private static void registerClientEventHandlers() {
    	
    	MinecraftForge.EVENT_BUS.register(new GameOverlayHandler());
    	MinecraftForge.EVENT_BUS.register(new ClientHandler());
    	//MinecraftForge.EVENT_BUS.register(new TrailsHandler());
    }
    
	private static void registerEntityEventHandlers() {
	
		MinecraftForge.EVENT_BUS.register(new PlayerHandler());
		//TODO: PICKUP ITEMS/BLOCKS ACHIEVEMENTS //MinecraftForge.EVENT_BUS.register(new EntityHandler());
	}
	
	
	private static void registerGUIEventHandlers() {
		  
	}
	
	private static void registerWorldEventHandlers() {
	
		
	}
	private static void registerPotionEventHandlers() {
	    //TODO:
		//MinecraftForge.EVENT_BUS.register(new PotionReplenishHandler());
	    //MinecraftForge.EVENT_BUS.register(new PotionRejuvnateEventHandler());	
	
  
  
   }

  }
