package com.aquabarnes.spiritedaway.proxy;

import java.util.Random;


import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import com.aquabarnes.spiritedaway.renders.BlockRendering;
import com.aquabarnes.spiritedaway.renders.ItemRendering;
import com.aquabarnes.spiritedaway.client.model.ModelChihiro;
import com.aquabarnes.spiritedaway.client.model.ModelFrogman;
import com.aquabarnes.spiritedaway.client.model.ModelHakuDragon;
import com.aquabarnes.spiritedaway.client.model.ModelHakuHuman;
import com.aquabarnes.spiritedaway.client.model.ModelKashira;
import com.aquabarnes.spiritedaway.client.model.ModelKasuga;
import com.aquabarnes.spiritedaway.PlayerInfo;
import com.aquabarnes.spiritedaway.client.main_menu.GuiSpiritedAwayMenu;
import com.aquabarnes.spiritedaway.client.model.ModelBipedBase;
import com.aquabarnes.spiritedaway.client.model.ModelBipedMini;
import com.aquabarnes.spiritedaway.client.model.ModelNoFace;
import com.aquabarnes.spiritedaway.client.model.ModelOotori;
import com.aquabarnes.spiritedaway.client.model.ModelPigMumDad;
import com.aquabarnes.spiritedaway.client.model.ModelRadish;
import com.aquabarnes.spiritedaway.client.model.ModelShikigami;
import com.aquabarnes.spiritedaway.client.model.ModelSootball;
import com.aquabarnes.spiritedaway.client.model.ModelTrain;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderAkiichiro;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderBoh;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderChihiro;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderFrogman;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderHakuHuman;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderKashira;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderKasuga;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderLin;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderNoFace;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderOotori;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderPigMumDad;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderRadish;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderShikigami;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderSootball;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderTestDragon;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderTrain;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderUUIDSkin;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderUshi;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderYubaba;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderYuko;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderZenbia;
import com.aquabarnes.spiritedaway.entity.EntityAkiichiro;
import com.aquabarnes.spiritedaway.entity.EntityBoh;
import com.aquabarnes.spiritedaway.entity.EntityChihiro;
import com.aquabarnes.spiritedaway.entity.EntityFrogman;
import com.aquabarnes.spiritedaway.entity.EntityGiant;
import com.aquabarnes.spiritedaway.entity.EntityHakuDragon;
import com.aquabarnes.spiritedaway.entity.EntityHakuHuman;
import com.aquabarnes.spiritedaway.entity.EntityKashira;
import com.aquabarnes.spiritedaway.entity.EntityKasuga;
import com.aquabarnes.spiritedaway.entity.EntityLin;
import com.aquabarnes.spiritedaway.entity.EntityMudball;
import com.aquabarnes.spiritedaway.entity.EntityNoFace;
import com.aquabarnes.spiritedaway.entity.EntityOotori;
import com.aquabarnes.spiritedaway.entity.EntityPigMumDad;
import com.aquabarnes.spiritedaway.entity.EntityRadish;
import com.aquabarnes.spiritedaway.entity.EntityShikigami;
import com.aquabarnes.spiritedaway.entity.EntitySootball;
import com.aquabarnes.spiritedaway.entity.EntitySpiritEye;
import com.aquabarnes.spiritedaway.entity.EntityTrain;
import com.aquabarnes.spiritedaway.entity.EntityUUIDSkin;
import com.aquabarnes.spiritedaway.entity.EntityUshi;
import com.aquabarnes.spiritedaway.entity.EntityYubaba;
import com.aquabarnes.spiritedaway.entity.EntityYuko;
import com.aquabarnes.spiritedaway.entity.EntityZenbia;
import com.aquabarnes.spiritedaway.enums.EnumPlankTypes;
import com.aquabarnes.spiritedaway.handler.KeyHandler;
import com.aquabarnes.spiritedaway.handler.SAConfiguration;
import com.aquabarnes.spiritedaway.init.SABlocks;
import com.aquabarnes.spiritedaway.init.SAItemBlocks;
import com.aquabarnes.spiritedaway.init.SAItems;
import com.aquabarnes.spiritedaway.itemblock.IMetaBlockName;
import com.aquabarnes.spiritedaway.particle.EntityFootprintFX;
import com.aquabarnes.spiritedaway.tileenitity.TileEntitySkull;
import com.aquabarnes.spiritedaway.tileenitity.TileEntitySushi;
import com.aquabarnes.spiritedaway.tileenitity.renderer.TileEntitySkullRenderer;
import com.aquabarnes.spiritedaway.tileenitity.renderer.TileEntitySushiRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelDragon;
import net.minecraft.client.model.ModelElytra;
import net.minecraft.client.model.ModelMinecart;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.entity.RenderDragon;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.client.renderer.entity.layers.LayerCape;
import net.minecraft.client.renderer.entity.layers.LayerElytra;
import net.minecraft.client.renderer.entity.layers.LayerSheepWool;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {	
	

	  public void preinitialization() 
	  {
		MinecraftForge.EVENT_BUS.register(new PlayerInfo());
		//Minecraft.getMinecraft().getRenderManager().getClass(EnumPlayerModelParts.CAPE, true);
		for (RenderPlayer render : Minecraft.getMinecraft().getRenderManager().getSkinMap().values())
		{ 
			render.addLayer(new LayerCape(render));
	        render.addLayer(new LayerElytra(render));
	    }
	  }

	  public void initialization()
	  {
		BlockRendering.initialize();
		ItemRendering.initialize(); 
	  }
	
	  @SideOnly(Side.CLIENT)
	  public void registerEntityRenderers()
	  {	
	//Projectiles
	//RenderingRegistry.registerEntityRenderingHandler(EntitySpiritEye.class, new RenderSpiritEye(this, SAItems.SpiritEye, itemRendererIn));
	RenderingRegistry.registerEntityRenderingHandler(EntityMudball.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), SAItems.MUDBALL, null));
	
	//Mobs
	//RenderingRegistry.registerEntityRenderingHandler(EntityUUIDSkin.class, new RenderUUIDSkin(Minecraft.getMinecraft().getRenderManager(), new ModelBipedBase(), 0.4F));
	RenderingRegistry.registerEntityRenderingHandler(EntityAkiichiro.class, new RenderAkiichiro(Minecraft.getMinecraft().getRenderManager(), new ModelBipedBase(), 0.4F));
	//RenderingRegistry.registerEntityRenderingHandler(EntityBoh.class, new RenderBoh(Minecraft.getMinecraft().getRenderManager(), new ModelBird(), 0.4F));
	RenderingRegistry.registerEntityRenderingHandler(EntityChihiro.class, new RenderChihiro(Minecraft.getMinecraft().getRenderManager(), new ModelChihiro(), 0.4F));
	RenderingRegistry.registerEntityRenderingHandler(EntityFrogman.class, new RenderFrogman(Minecraft.getMinecraft().getRenderManager(), new ModelFrogman(), 0.4F));
	RenderingRegistry.registerEntityRenderingHandler(EntityHakuHuman.class, new RenderHakuHuman(Minecraft.getMinecraft().getRenderManager(), new ModelBipedBase(), 0.4F));
	RenderingRegistry.registerEntityRenderingHandler(EntityKashira.class, new RenderKashira(Minecraft.getMinecraft().getRenderManager(), new ModelKashira(), 0.4F));
	RenderingRegistry.registerEntityRenderingHandler(EntityKasuga.class, new RenderKasuga(Minecraft.getMinecraft().getRenderManager(), new ModelKasuga(), 0.5F));
	RenderingRegistry.registerEntityRenderingHandler(EntityLin.class, new RenderLin(Minecraft.getMinecraft().getRenderManager(), new ModelBipedBase(), 0.4F));
	RenderingRegistry.registerEntityRenderingHandler(EntityNoFace.class, new RenderNoFace(Minecraft.getMinecraft().getRenderManager(), new ModelNoFace(), 0.5F));
	RenderingRegistry.registerEntityRenderingHandler(EntityOotori.class, new RenderOotori(Minecraft.getMinecraft().getRenderManager(), new ModelOotori(), 0.5F));
	RenderingRegistry.registerEntityRenderingHandler(EntityRadish.class, new RenderRadish(Minecraft.getMinecraft().getRenderManager(), new ModelRadish(), 0.5F));
	RenderingRegistry.registerEntityRenderingHandler(EntityShikigami.class, new RenderShikigami(Minecraft.getMinecraft().getRenderManager(), new ModelShikigami(), 0.2F));
	RenderingRegistry.registerEntityRenderingHandler(EntitySootball.class, new RenderSootball(Minecraft.getMinecraft().getRenderManager(), new ModelSootball(), 0.3F));
	RenderingRegistry.registerEntityRenderingHandler(EntityUshi.class, new RenderUshi(Minecraft.getMinecraft().getRenderManager(), new ModelBipedBase(), 0.4F));
	RenderingRegistry.registerEntityRenderingHandler(EntityYubaba.class, new RenderYubaba(Minecraft.getMinecraft().getRenderManager(), new ModelWitch(0), 0.4F));
	RenderingRegistry.registerEntityRenderingHandler(EntityYuko.class, new RenderYuko(Minecraft.getMinecraft().getRenderManager(), new ModelBipedBase(), 0.4F));
	RenderingRegistry.registerEntityRenderingHandler(EntityZenbia.class, new RenderZenbia(Minecraft.getMinecraft().getRenderManager(), new ModelWitch(0), 0.4F));
	
	RenderingRegistry.registerEntityRenderingHandler(EntityHakuDragon.class, new RenderTestDragon(Minecraft.getMinecraft().getRenderManager(), new ModelHakuDragon(0.9F), 0));
	RenderingRegistry.registerEntityRenderingHandler(EntityPigMumDad.class, new RenderPigMumDad(Minecraft.getMinecraft().getRenderManager(), new ModelPigMumDad(0.5F), 0));
	
	//TODO: TRAM TRAIN :D
	RenderingRegistry.registerEntityRenderingHandler(EntityTrain.class, new RenderTrain(Minecraft.getMinecraft().getRenderManager(), new ModelMinecart(), 0));

	//RenderingRegistry.registerEntityRenderingHandler(AbstractClientPlayer.class, new SALayerElytra(Minecraft.getMinecraft().getRenderManager(), new ModelElytra(), 0));
	

	MinecraftForge.EVENT_BUS.register(new TickHandler());
	FMLCommonHandler.instance().bus().register(new TickHandler());
	KeyHandler.init();
	
	}

	public void registerModelBakeryStuff() {
		
		ModelBakery.registerItemVariants(Item.getItemFromBlock(SAItemBlocks.bowls)
				, new ResourceLocation("sa:bowl_white_empty")
				, new ResourceLocation("sa:bowl_orange_empty"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(SAItemBlocks.planks), new ResourceLocation("sa:planks_sakura"), new ResourceLocation("sa:planks_wisteria"), new ResourceLocation("sa:planks_acer_palmatum"), new ResourceLocation("sa:planks_winter_sweet"));
		//ModelBakery.registerItemVariants(Item.getItemFromBlock(SAItemBlocks.SAPLING), new ResourceLocation("sa:sapling_sakura"), new ResourceLocation("sa:sapling_wisteria"), new ResourceLocation("sa:sapling_acer_palmatum"), new ResourceLocation("sa:sapling_winter_sweet"));

	}

	@SideOnly(Side.CLIENT)
	public void registerTileSpecialRenderers()
	{	
	//TODO: Special Sushi Tray Renderer
	//ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySushi.class, new TileEntitySushiRenderer());
	//ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySkull.class, new TileEntitySkullRenderer());
	}

	public ModelBiped getArmorModel(int id)
	{
		return null;
	}
		
	 public void spawnParticle(String string, double x, double y, double z, Object args)
	 {
	 
	 

	 }
}
