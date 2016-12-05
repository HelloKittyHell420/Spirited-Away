package com.aquabarnes.spiritedaway.item;

import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemStaff extends Item {

public ItemStaff(int par1){
    
	setMaxDamage(0);
	maxStackSize = 64;
	setUnlocalizedName("travel_staff");
	GameRegistry.registerItem(this, "travel_staff");
	setCreativeTab(CreativeTabs.tabMaterials);
}

	@Override
	public int getItemEnchantability()
	{
		return 1;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 0;
	}

@Override
public float getStrVsBlock(ItemStack par1ItemStack, IBlockState par2Block)
{
    return 1.0F;
}

@Override
public ActionResult<ItemStack> onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity, EnumHand hand){
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);

if(true){
if (entity.getRidingEntity() == null && entity.getRidingEntity() == null && !world.isRemote){entity.changeDimension(-1);}
}


return new ActionResult(EnumActionResult.PASS, itemstack);
}

@Override
public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
{
list.add("Hello");
list.add("Hey");
list.add("Hi");
}

@Override
public boolean canHarvestBlock(IBlockState state, ItemStack stack)
{
    return true;
}
}
