package com.aquabarnes.spiritedaway.item;

import javax.annotation.Nonnull;




import com.aquabarnes.spiritedaway.SpiritedAway;
import com.aquabarnes.spiritedaway.gui.GuiBook;
import com.aquabarnes.spiritedaway.init.SAGuiHandler;
import com.aquabarnes.spiritedaway.init.SAItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBook extends Item {

	  public ItemBook() {
	    
		 this.setMaxStackSize(1);
	  }

	  @Nonnull
	  @Override
	  public ActionResult<ItemStack> onItemRightClick(@Nonnull ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
	    if(worldIn.isRemote) {
	    	//TODO: Block/Items/Mobs (Displays Information about mod stuff)
	    	//playerIn.openGui(SpiritedAway.instance, SAGuiHandler.lore, worldIn, (int)playerIn.posX, (int)playerIn.posY, (int)playerIn.posZ);
	    	Minecraft.getMinecraft().displayGuiScreen(new GuiBook());
	    }
	    return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
	  }

}
