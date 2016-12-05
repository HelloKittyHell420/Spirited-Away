package com.aquabarnes.spiritedaway.item;

import com.aquabarnes.spiritedaway.SpiritedAway;
import com.aquabarnes.spiritedaway.client.model.ModelRadish;
import com.aquabarnes.spiritedaway.client.model.hats.ModelFrogmanHat;
import com.aquabarnes.spiritedaway.client.model.hats.ModelRadishHat;
import com.aquabarnes.spiritedaway.init.SACreativeTabs;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHat extends ItemArmor {
	
public ItemHat(String name, ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, EntityEquipmentSlot par4)
{
  super(par2EnumArmorMaterial, par3, par4);
  this.setCreativeTab(SACreativeTabs.tabSACombat);
  this.setUnlocalizedName(name);
  GameRegistry.registerItem(this, name);
  if (!SpiritedAway.isServer()) {
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("sa:" + name, "inventory"));
  }
}

@SideOnly(Side.CLIENT)
public ModelCreeper getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
{
  ModelCreeper armorModel = new ModelCreeper();
  if (armorModel != null)
  {
    armorModel.head.showModel = (armorSlot == 0);
    }
  return armorModel;
}

@SideOnly(Side.CLIENT)
public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
{
  return "sa:textures/models/armor/RadishHat_layer_1.png";
}

@SideOnly(Side.CLIENT)
public int func_82790_a(ItemStack stack, int pass)
{
  if (pass > 0) {
    return 16777215;
  }
  int j = getColor(stack);
  if (j < 0) {
    j = 16777215;
  }
  return j;
}

@SideOnly(Side.CLIENT)
public boolean func_77623_v()
{
  return true;
} 

/**
 * Return whether the specified armor ItemStack has a color.
 */
public boolean hasColor(ItemStack stack)
{
    if (this.getArmorMaterial() != ItemArmor.ArmorMaterial.LEATHER)
    {
        return false;
    }
    else
    {
        NBTTagCompound nbttagcompound = stack.getTagCompound();
        return nbttagcompound != null && nbttagcompound.hasKey("display", 10) ? nbttagcompound.getCompoundTag("display").hasKey("color", 3) : false;
    }
}

/**
 * Return the color for the specified armor ItemStack.
 */
public int getColor(ItemStack stack)
{
    if (this.getArmorMaterial() != ItemArmor.ArmorMaterial.LEATHER)
    {
        return 16777215;
    }
    else
    {
        NBTTagCompound nbttagcompound = stack.getTagCompound();

        if (nbttagcompound != null)
        {
            NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

            if (nbttagcompound1 != null && nbttagcompound1.hasKey("color", 3))
            {
                return nbttagcompound1.getInteger("color");
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
    if (this.getArmorMaterial() == ItemArmor.ArmorMaterial.LEATHER)
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
}

/**
 * Sets the color of the specified armor ItemStack
 */
public void setColor(ItemStack stack, int color)
{
    if (this.getArmorMaterial() != ItemArmor.ArmorMaterial.LEATHER)
    {
        throw new UnsupportedOperationException("Can\'t dye non-leather!");
    }
    else
    {
        NBTTagCompound nbttagcompound = stack.getTagCompound();

        if (nbttagcompound == null)
        {
            nbttagcompound = new NBTTagCompound();
            stack.setTagCompound(nbttagcompound);
        }

        NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

        if (!nbttagcompound.hasKey("display", 10))
        {
            nbttagcompound.setTag("display", nbttagcompound1);
        }

        nbttagcompound1.setInteger("color", color);
    }
}
}