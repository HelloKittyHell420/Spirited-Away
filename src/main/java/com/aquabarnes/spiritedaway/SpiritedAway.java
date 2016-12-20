package com.aquabarnes.spiritedaway;

import java.io.File;













import org.apache.logging.log4j.Level;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraftforge.common.util.EnumHelper;

import com.aquabarnes.spiritedaway.commands.CommandColorize;
import com.aquabarnes.spiritedaway.commands.CommandDimensionTP;
import com.aquabarnes.spiritedaway.commands.CommandSAOpenGUIs;
import com.aquabarnes.spiritedaway.creativetab.SABlocksTab;
import com.aquabarnes.spiritedaway.creativetab.SACombatTab;
import com.aquabarnes.spiritedaway.creativetab.SADecorationsTab;
import com.aquabarnes.spiritedaway.creativetab.SAFoodTab;
import com.aquabarnes.spiritedaway.creativetab.SAMaterialsTab;
import com.aquabarnes.spiritedaway.creativetab.SAToolsTab;
import com.aquabarnes.spiritedaway.creativetab.SATransportationTab;
import com.aquabarnes.spiritedaway.achievements.SAAchievementPage;
import com.aquabarnes.spiritedaway.client.model.ModelShikigami;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderShikigami;
import com.aquabarnes.spiritedaway.handler.SAConfiguration;
import com.aquabarnes.spiritedaway.init.SABiomes;
import com.aquabarnes.spiritedaway.init.SABlocks;
import com.aquabarnes.spiritedaway.init.SACreativeTabs;
import com.aquabarnes.spiritedaway.init.SADimension;
import com.aquabarnes.spiritedaway.init.SAEntities;
import com.aquabarnes.spiritedaway.init.SAEventHandler;
import com.aquabarnes.spiritedaway.init.SAFluids;
import com.aquabarnes.spiritedaway.init.SAGuiHandler;
import com.aquabarnes.spiritedaway.init.SAItemBlocks;
import com.aquabarnes.spiritedaway.init.SAItems;
import com.aquabarnes.spiritedaway.init.SARanks;
import com.aquabarnes.spiritedaway.init.SARecipes;
import com.aquabarnes.spiritedaway.init.SASchematics;
import com.aquabarnes.spiritedaway.init.SASoundEvents;
import com.aquabarnes.spiritedaway.network.SAPacketHandler;
import com.aquabarnes.spiritedaway.potions.SAPotions;
import com.aquabarnes.spiritedaway.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderEnd;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid="SA", name="Spirited Away", version="1.10.2-1.0", dependencies="required-after:AquaBarnesUtils@[1.0,);", acceptedMinecraftVersions="[1.10.2]")
public class SpiritedAway
{
  @Mod.Instance("SA")
  public static SpiritedAway instance;
  @SidedProxy(clientSide="com.aquabarnes.spiritedaway.proxy.ClientProxy", serverSide="com.aquabarnes.spiritedaway.proxy.CommonProxy")
  public static CommonProxy proxy;

  @Mod.EventHandler
  public void preInit(FMLPreInitializationEvent event) 
  {
	SAConfiguration.initialization(event.getModConfigurationDirectory());

	//TODO: Networking
    proxy.preInitialization();
  } 
  
  @Mod.EventHandler
  public void load(FMLInitializationEvent event)
  {  
	FMLLog.log("Spirited Away", Level.INFO, "************************************************************************************", new Object[0]);
	FMLLog.log("Spirited Away", Level.INFO, "* Spirited Away is a mod developed by AquaBarnes. *", new Object[0]);
	FMLLog.log("Spirited Away", Level.INFO, "************************************************************************************", new Object[0]);  
	 
	SASoundEvents.initialization();
    SACreativeTabs.initialization();
	
    SAFluids.init();
    SARecipes.initialization();

	//SARanks.initialization();
	
	SAItems.init(); 
	SABlocks.initialization();
	SAItemBlocks.initialization();
	
	//TODO: LOOKUP
	//SAPotions.init();
    SAEntities.initialization();
	//SATileEntites.init();
  
    //SASchematics.init();
    SAAchievementPage.init();
    
    //SADimension.init();
    
    proxy.registerEntityRenderers();
    proxy.registerModelBakeryStuff();
    proxy.initialization();

  }

  @Mod.EventHandler
  public void postInit(FMLPostInitializationEvent event) 
  {

  }

  @Mod.EventHandler
  public void serverStarting(FMLServerStartingEvent event)
  {
	//event.registerServerCommand(new CommandHelp()); 
    //event.registerServerCommand(new CommandOpenGUIs());
	//event.registerServerCommand(new CommandColorize());
	//event.registerServerCommand(new CommandDimensionTP()); 
  }
  
  public static boolean isServer()
  {
    return FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER;
  }
  
  public static boolean isClient()
  {
    return FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT;
  }

  public static ResourceLocation getResource(String name) 
  {
	return new ResourceLocation("sa", name);
  }
  
  public static String modAddress()
  {
    return "sa:";
  }
  
}



