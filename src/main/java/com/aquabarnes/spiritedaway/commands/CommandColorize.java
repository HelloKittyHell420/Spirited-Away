package com.aquabarnes.spiritedaway.commands;

import java.util.Collections;
import java.util.List;

import com.aquabarnes.spiritedaway.init.SAItems;
import com.aquabarnes.spiritedaway.item.ItemArmorDyeable;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

public class CommandColorize extends CommandBase
{
	public String getCommandName()
	{
		return "dye";
	}

	public int getRequiredPermissionLevel()
	{
		return 2;
	}

	public String getCommandUsage(ICommandSender sender) {
	{
		return "/" + getCommandName() + " [<colorValue>]";
	}
}

	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		{
		if (args.length < 1) {
			throw new WrongUsageException("commands.dye.usage.error", new Object[0]);
		}
		String color = null;
		if (args.length == 2) {
			for (String colorLine : args) {
				color = colorLine;
				
			throw new WrongUsageException("commands.dye.usage.noValue", new Object[0]);
			
			}
  }
		int currentColor = Integer.parseInt(color);
  
		EntityPlayerMP entityplayer = getPlayer(server, sender, args[0]);
  
		if (entityplayer.getHeldItemMainhand().getItem() == SAItems.CHESTPLATE_DYEABLE_CLOTHES)
		{
			ItemArmorDyeable item = (ItemArmorDyeable)entityplayer.getActiveItemStack().getItem();
    
			item.setColor(entityplayer.getActiveItemStack(), currentColor);
		}	
		else if (entityplayer.getHeldItemMainhand().getItem() == SAItems.LEGGINGS_DYEABLE_CLOTHES)
		{
			ItemArmorDyeable item = (ItemArmorDyeable)entityplayer.getActiveItemStack().getItem();
	    
			item.setColor(entityplayer.getHeldItemMainhand(), currentColor);	
		}	
		else if (entityplayer.getEquipmentAndArmor() instanceof ItemArmor)
		{
			ItemArmor item = (ItemArmor)entityplayer.getActiveItemStack().getItem();
		    
			item.setColor(entityplayer.getActiveItemStack(), currentColor);	
  
		}
		
		notifyOperators(sender, this, "commands.dye.success", entityplayer.getName());
		
		}

  }

	public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos)
	    {
	        return args.length == 1 ? getListOfStringsMatchingLastWord(args, server.getCommandManager().hashCode())); 
	    }
	
	public boolean isUsernameIndex(String[] args, int index) {
		{
			return index == 1;
		}
	}
	
}

