package com.aquabarnes.spiritedaway.init;

import com.aquabarnes.spiritedaway.handler.SAConfiguration;

import com.aquabarnes.spiritedaway.world.SAWorldProvider;
import com.aquabarnes.spiritedaway.world.Teleporter;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.entity.player.EntityPlayerMP;



import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerInteractionManager;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class SADimension {
	 
	public static int SpiritedAwayDimensionID = SAConfiguration.SpiritedAwayID;
	public static DimensionType SpiritedAway; 
		 
	public static void init()
	  {
	    registerDimensionsType();
	    registerDimensions();
	  }
	 
	  private static void registerDimensionsType() {
		
		  SpiritedAway = DimensionType.register("Spirited Away", "_spiritedaway", SpiritedAwayDimensionID, SAWorldProvider.class, false);
	  }

	  private static void registerDimensions() 
	  {
		  DimensionManager.registerDimension(SpiritedAwayDimensionID, SpiritedAway);
	  }
  }

