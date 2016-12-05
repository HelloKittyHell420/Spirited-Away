package eu.aquabarnes;
import java.util.ArrayList;

import java.util.List;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid="AquaBarnesUtils", name="AquaBarnes Utils", version="1.10.2-1.0", acceptedMinecraftVersions="[1.10.2]")
public class Core
{
  @Mod.Instance("AquaBarnesUtils")
  public static Core instance;
 
  public Core()
  {
	  
  }
  public static boolean isClient()
  {
    return getSide().isClient();
  }
  
  public static boolean isServer()
  {
    return getSide().isServer();
  }
  
  public static Side getSide()
  {
    Thread thr = Thread.currentThread();
    if ((thr.getName().equals("Server thread")) || (thr.getName().startsWith("Netty Server IO"))) {
      return Side.SERVER;
    }
    return Side.CLIENT;
  }
}
  