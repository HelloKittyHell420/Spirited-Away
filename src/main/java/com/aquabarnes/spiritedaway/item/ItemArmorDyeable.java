package com.aquabarnes.spiritedaway.item;

import org.lwjgl.opengl.GL11;


import com.aquabarnes.spiritedaway.SpiritedAway;
import com.aquabarnes.spiritedaway.init.SACreativeTabs;
import com.aquabarnes.spiritedaway.init.SAItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArmorDyeable extends ItemArmor {

public ItemArmorDyeable(String name, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)  {
	  
	super(SAItems.DYEABLE, renderIndexIn, equipmentSlotIn);
	  this.hasCustomProperties();
	//this.renderHelmetOverlay(stack, player, resolution, partialTicks);
	  this.setHasSubtypes(true);
	  this.setCreativeTab(SACreativeTabs.COMBAT);
	  this.setUnlocalizedName(name);
	  //GameRegistry.registerItem(this, name);	  
	  if (!SpiritedAway.isServer()) {
		  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("sa:" + name, "inventory"));	  
		  
		  
		  //Minecraft.getMinecraft().getItemColors().equals(new IItemColor()
			    {
			      //public int func_186726_a(ItemStack stack, int tintIndex)
			      {
			        //return tintIndex > 0 ? -1 : ((this)stack()).func_82814_b(stack);
			      }
			    }//, new Item[] { SAItems.LEGGINGS_DYEABLE_CLOTHES, SAItems.CHESTPLATE_DYEABLE_CLOTHES});
			  }

		    }



/**
 * Return whether the specified armor ItemStack has a color.
 */
public boolean hasColor(ItemStack stack)
{
     NBTTagCompound nbttagcompound = stack.getTagCompound();
     return nbttagcompound != null && nbttagcompound.hasKey("display", 10) ? nbttagcompound.getCompoundTag("display").hasKey("color", 3) : false;
}

/**
 * Return the color for the specified armor ItemStack.
 */
public int getColor(ItemStack stack)
{
	NBTTagCompound nbttagcompound = stack.getTagCompound();
    if (nbttagcompound == null) {
        return 16777215;
    }
    else
    {
        NBTTagCompound nbttagcompound1 = stack.getTagCompound();

        if (nbttagcompound != null)
        {
            NBTTagCompound nbttagcompound11 = nbttagcompound.getCompoundTag("display");

            if (nbttagcompound11 != null && nbttagcompound11.hasKey("color", 3))
            {
                return nbttagcompound11.getInteger("color");
            }
        }

        return 10511680;
    }
}

/**
 * Remove the color from the specified armor ItemStack.
 */
public void removeColor(ItemStack stack)
{
        NBTTagCompound nbttagcompound = stack.getTagCompound();

        if (nbttagcompound != null)
        {
            NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

            if (nbttagcompound1.hasKey("color"))
            {
                nbttagcompound1.removeTag("color");
            }
        }
}

/**
 * Sets the color of the specified armor ItemStack
 */
public void setColor(ItemStack stack, int color)
{
        NBTTagCompound nbttagcompound1 = stack.getTagCompound();

        if (nbttagcompound1 == null)
        {
            nbttagcompound1 = new NBTTagCompound();
            stack.setTagCompound(nbttagcompound1);
        }

        NBTTagCompound nbttagcompound2 = nbttagcompound1.getCompoundTag("display");

        if (!nbttagcompound1.hasKey("display", 10))
        {
            nbttagcompound1.setTag("display", nbttagcompound2);
        }

        nbttagcompound2.setInteger("color", color);
    }
}
