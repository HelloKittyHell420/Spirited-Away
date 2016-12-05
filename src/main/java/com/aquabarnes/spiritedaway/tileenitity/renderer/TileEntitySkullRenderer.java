package com.aquabarnes.spiritedaway.tileenitity.renderer;

import java.util.Map;

import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.tileenitity.TileEntitySkull;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelDragonHead;
import net.minecraft.client.model.ModelHumanoidHead;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class TileEntitySkullRenderer extends TileEntitySpecialRenderer
{
	private static final ResourceLocation TEXTURE_SKULL_CHIHIRO = new ResourceLocation("textures/entity/zombie/zombie.png");
	private final ModelHumanoidHead chihiroHeadModel;;
    private static final ResourceLocation TEXTURE_SKULL_HAKU = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
    //private final ModelHakuHead;
    private static final ResourceLocation TEXTURE_SKULL_HAKU_DRAGON = new ResourceLocation("textures/entity/enderdragon/dragon.png");
    //private final ModelChihiroHead;
    private static final ResourceLocation TEXTURE_SKULL_KASHIRA = new ResourceLocation("textures/entity/skeleton/skeleton.png");
    //private final ModelChihiroHead;
    private static final ResourceLocation TEXTURE_SKULL_OOTORI = new ResourceLocation("textures/entity/skeleton/skeleton.png");
    //private final ModelChihiroHead;
    private static final ResourceLocation TEXTURE_SKULL_RADISH = new ResourceLocation("textures/entity/skeleton/skeleton.png");
    //private final ModelChihiroHead;
    private static final ResourceLocation TEXTURE_SKULL_SOOTBALL = new ResourceLocation("sa:textures/entity/sootball.png");
    //private final ModelChihiroHead;
       
    public TileEntitySkullRenderer()
    {
      this.chihiroHeadModel = new ModelHumanoidHead();
    }
    
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage) {
    {
      TileEntitySkull skull = (TileEntitySkull)te;
      
      GL11.glPushMatrix();
      GL11.glDisable(2884);
      
      int meta = skull.getBlockMetadata() & 0x7;
      
      float rotation = skull.getSkullRotation() * 360 / 16.0F;
      boolean onGround = true;
      if (meta != 1) {
        switch (meta)
        {
        case 2: 
          onGround = false;
          break;
        case 3: 
          onGround = false;
          rotation = 180.0F;
          break;
        case 4: 
          onGround = false;
          rotation = 270.0F;
          break;
        case 5: 
        default: 
          onGround = false; 
          rotation = 90.0F;
        }
      }
      GL11.glTranslatef((float)x + 0.5F, (float)y + 0.5F, (float)z + 0.5F);
      switch (skull.getBlockMetadata())
      {
      case 0: 
        renderChihiroHead(rotation, onGround);
        break;
      }
      GL11.glPopMatrix();
    	}
    }
    
    private void renderChihiroHead(float rotation, boolean onGround)
    {
      GL11.glTranslatef(0.0F, -0.125F, 0.0F);
      
      GL11.glScalef(0.25F, 0.25F, 0.25F);
      
      this.bindTexture(TEXTURE_SKULL_SOOTBALL);
      
      GL11.glScalef(1.0F, -1.0F, -1.0F);
      
      GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
      
      GL11.glTranslatef(0.0F, onGround ? 1.0F : -0.0F, onGround ? 0.0F : 1.0F);
      
      this.chihiroHeadModel.render((Entity)null, 0.0F, 0.0F, 0.0F, rotation, 0.0F, 0.0625F);
						
	}
}