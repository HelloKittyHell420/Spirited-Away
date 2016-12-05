package com.aquabarnes.spiritedaway.item;

import com.aquabarnes.spiritedaway.SpiritedAway;
import com.aquabarnes.spiritedaway.init.SACreativeTabs;

import net.minecraft.block.BlockDispenser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemElytra extends Item
{
	  public ItemElytra(String name) {
		 
	    this.maxStackSize = 1;
        this.setMaxDamage(432);
	    GameRegistry.registerItem(this, name);
	    this.setCreativeTab(SACreativeTabs.tabSATransportation);
	    this.setUnlocalizedName(name);
	    this.addPropertyOverride(new ResourceLocation("broken"), new IItemPropertyGetter()
	         {
	             @SideOnly(Side.CLIENT)
	             public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn)
	             {
	                 return ItemElytra.isBroken(stack) ? 0.0F : 1.0F;
	             }
	         });
	         BlockDispenser.dispenseBehaviorRegistry.putObject(this, ItemArmor.dispenserBehavior);
	     }

	     public static boolean isBroken(ItemStack stack)
	     {
	         return stack.getItemDamage() < stack.getMaxDamage() - 1;
	     }

	     /**
	      * Return whether this item is repairable in an anvil.
	      */
	     public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	     {
	         return repair.getItem() == Items.leather;
	     }

	     public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
	     {
	         EntityEquipmentSlot entityequipmentslot = EntityLiving.getSlotForItemStack(itemStackIn);
	         ItemStack itemstack = playerIn.getItemStackFromSlot(entityequipmentslot);

	         if (itemstack == null)
	         {
	             playerIn.setItemStackToSlot(entityequipmentslot, itemStackIn.copy());
	             itemStackIn.stackSize = 0;
	             return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	         }
	         else
	         {
	             return new ActionResult(EnumActionResult.FAIL, itemStackIn);
	         }
	     }
	    

}