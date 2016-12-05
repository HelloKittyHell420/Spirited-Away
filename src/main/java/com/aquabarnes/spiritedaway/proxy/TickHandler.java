package com.aquabarnes.spiritedaway.proxy;

import com.aquabarnes.spiritedaway.client.main_menu.GuiSpiritedAwayMenu;
import com.aquabarnes.spiritedaway.handler.SAConfiguration;
import java.io.PrintStream;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Session;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderLivingEvent.Post;
import net.minecraftforge.client.event.RenderLivingEvent.Pre;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

public class TickHandler {

	  //private TrailManager TrailManager;
	
	  @SubscribeEvent
	  public void onRenderTick(TickEvent e)
	  {
		  if (e.type != TickEvent.Type.RENDER) {
			  return;
		  }
		  	if(SAConfiguration.showTitleScreen) {
		  		Minecraft.getMinecraft().displayGuiScreen(new GuiSpiritedAwayMenu());
		  	}
	  }
	  
	  @SubscribeEvent
	  //TODO:CUSTOM TRAILS
	  public void playerTick(TickEvent.PlayerTickEvent e)
	  {
		  if ((e.side == Side.CLIENT) && (e.phase == TickEvent.Phase.START))
	    {
	      EntityPlayer player = e.player;
	      World world = Minecraft.getMinecraft().theWorld;
	      //if (this.flowerTrailManager.hasTrail(player.())) {
	        //if ((player.field_70165_t != player.field_70169_q) || (player.field_70161_v != player.field_70166_s))
	        {
	         // double dx = player.posX + 0.30000001192092896D - 0.6F * world.isRemote.nextFloat();
	          //double dy = player.posY - 2.0D;
	          //double dz = player.posZ + 0.30000001192092896D - 0.6F * world.field_73012_v.nextFloat();
	          //if (player != Minecraft.func_71410_x().field_71439_g) {
	            //dy += 1.0D;
	          }
	          //int x = MathHelper.getCoordinateRandom(dx);
	          //int y = MathHelper.func_76128_c(dy);
	         // int z = MathHelper.func_76128_c(dz);
	          //if (world.spawnParticle(x, y, z).func_149747_d(world, x, y, z, 0)) {
	           // SA.proxy.spawnParticle("flowerscatter", dx, y + 1.01D, dz, new Object[] { ParticleRegistry.trailMap.get(this.flowerTrailManager.getTrailType(player.func_110124_au())) });
	    }
	  }
}