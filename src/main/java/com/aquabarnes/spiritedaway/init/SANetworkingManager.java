package com.aquabarnes.spiritedaway.init;

import com.aquabarnes.spiritedaway.SpiritedAway;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class SANetworkingManager {

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(SpiritedAway.modAddress());

	private static int discriminant;

	public static void preInitialization()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(SpiritedAway.modAddress(), new SAGuiHandler());
	}
}