package com.aquabarnes.spiritedaway.item;

import com.aquabarnes.spiritedaway.SpiritedAway;
import com.aquabarnes.spiritedaway.init.SACreativeTabs;
import com.aquabarnes.spiritedaway.init.SAItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBook extends Item {

	public ItemBook(String name) {

		  super();
		  this.setCreativeTab(SACreativeTabs.tabSAMaterials);
		  this.setUnlocalizedName(name);
		  GameRegistry.registerItem(this, name);
		  if (!SpiritedAway.isServer()) {
			  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("sa:" + name, "inventory"));	
		  }
	}

	
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemstackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
	
		if(worldIn.isRemote);
		//TODO: GUI instead of using NBT 
			//playerIn.openGui(SA.instance, modGuiId, world, x, y, z);;
		    playerIn.addChatComponentMessage(new TextComponentString(TextFormatting.DARK_RED + "TODO: Open's The Skin Changer GUI"));
		
		return super.onItemRightClick(itemstackIn, worldIn, playerIn, hand);
	
}
	
//TODO: May add a GUI to the Skin Changer 
public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par1Player)
{
  NBTTagCompound tag = par1Player.getEntityData();
  if (par2World.isRemote) {
    switch (tag.getByte("Skin"))
    {
    case 2: 
        tag.hasKey("Skin", 1);
        par1Player.addChatComponentMessage(new TextComponentString(TextFormatting.RED + "Chihiro Onigo"));
        regenParticles(par2World, par1Player);
    case 3: 
        tag.hasKey("Skin", 2);
        par1Player.addChatComponentMessage(new TextComponentString(TextFormatting.RED + "Haku"));
        regenParticles(par2World, par1Player);
    case 1: 
        tag.hasKey("Skin", 0);
        par1Player.addChatComponentMessage(new TextComponentString(TextFormatting.RED + "Default"));
        regenParticles(par2World, par1Player);
    }
  }
  return super.toString(par1ItemStack, par2World, par1Player);
}

@SideOnly(Side.CLIENT)
public boolean hasEffect(ItemStack par1ItemStack, int pass)
{
  return super.hasEffect(par1ItemStack, pass);
}

public void regenParticles(World par1World, EntityPlayer par2Player)
{
  for (int i = 0; i < 100; i++)
  {
   
  }
}
}
