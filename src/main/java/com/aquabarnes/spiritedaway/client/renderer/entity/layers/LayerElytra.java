package com.aquabarnes.spiritedaway.client.renderer.entity.layers;

import com.aquabarnes.spiritedaway.entity.player.SARenderPlayer;
import com.aquabarnes.spiritedaway.init.SAItems;


import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelElytra;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerElytra implements LayerRenderer<AbstractClientPlayer>
{
    /** The Elytras texture. */
    private static final ResourceLocation TEXTURE_ELYTRA_RADISH = new ResourceLocation("sa:textures/entity/elytra.png");
    private static final ResourceLocation TEXTURE_ELYTRA_KASHIRA = new ResourceLocation("sa:textures/entity/elytra.png");
    private static final ResourceLocation TEXTURE_ELYTRA_SOOTBALL = new ResourceLocation("sa:textures/entity/elytra.png");

    private final RenderPlayer renderPlayer;
    private final ModelElytra modelElytra = new ModelElytra();

	public LayerElytra(RenderPlayer renderPlayerIn)
	  {
	    this.renderPlayer = renderPlayerIn;
	  }
	  

	public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        ItemStack itemstack = entitylivingbaseIn.getItemStackFromSlot(EntityEquipmentSlot.CHEST);

        if (itemstack != null && itemstack.getItem() == SAItems.ELYTRA_SOOTBALL)
        {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

            if (entitylivingbaseIn.isPlayerInfoSet() && entitylivingbaseIn.getLocationElytra() != null)
            {
                this.renderPlayer.bindTexture(entitylivingbaseIn.getLocationElytra());
            }
            else if (entitylivingbaseIn.hasPlayerInfo() && entitylivingbaseIn.getLocationCape() != null && entitylivingbaseIn.isWearing(EnumPlayerModelParts.CAPE))
            {
                this.renderPlayer.bindTexture(entitylivingbaseIn.getLocationCape());
            }
            else
            {
                this.renderPlayer.bindTexture(TEXTURE_ELYTRA_SOOTBALL);
            }
            
            if (itemstack != null && itemstack.getItem() == SAItems.ELYTRA_KASHIRA)
            {
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

                if (entitylivingbaseIn.isPlayerInfoSet() && entitylivingbaseIn.getLocationElytra() != null)
                {
                    this.renderPlayer.bindTexture(entitylivingbaseIn.getLocationElytra());
                }
                else if (entitylivingbaseIn.hasPlayerInfo() && entitylivingbaseIn.getLocationCape() != null && entitylivingbaseIn.isWearing(EnumPlayerModelParts.CAPE))
                {
                    this.renderPlayer.bindTexture(entitylivingbaseIn.getLocationCape());
                }
                else
                {
                    this.renderPlayer.bindTexture(TEXTURE_ELYTRA_KASHIRA);
                }
                
             if (itemstack != null && itemstack.getItem() == SAItems.ELYTRA_RADISH)
                {
                    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

                    if (entitylivingbaseIn.isPlayerInfoSet() && entitylivingbaseIn.getLocationElytra() != null)
                    {
                        this.renderPlayer.bindTexture(entitylivingbaseIn.getLocationElytra());
                    }
                    else if (entitylivingbaseIn.hasPlayerInfo() && entitylivingbaseIn.getLocationCape() != null && entitylivingbaseIn.isWearing(EnumPlayerModelParts.CAPE))
                    {
                        this.renderPlayer.bindTexture(entitylivingbaseIn.getLocationCape());
                    }
                    else
                    {
                        this.renderPlayer.bindTexture(TEXTURE_ELYTRA_RADISH);
                    }
    


            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, 0.0F, 0.125F);
            this.modelElytra.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entitylivingbaseIn);
            this.modelElytra.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

            if (itemstack.isItemEnchanted())
            {
                LayerArmorBase.renderEnchantedGlint(this.renderPlayer, entitylivingbaseIn, this.modelElytra, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
            }

            GlStateManager.popMatrix();
        }
        }
       }
    }

    public boolean shouldCombineTextures()
    {
        return false;
    }
}