package com.aquabarnes.spiritedaway.commands;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.aquabarnes.spiritedaway.client.gui.GuiCrafting;

import net.minecraft.client.gui.GuiRepair;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CommandSAOpenGUIs extends CommandBase
{
	private HashMap<String, Class<? extends GuiScreen>> availableScreens = new HashMap();
	
    public String getCommandName()
    {
        return "gui";
    }

    public int getRequiredPermissionLevel()
    {
        return 3;
    }

    /**
     * Gets the usage string for the command.
     */
    public String getCommandUsage(ICommandSender sender)
    {
        return "/gui";

    }
    
    public final void addAvailableGui(String name, Class<? extends GuiScreen> _class)
    {
      this.availableScreens.put(name, _class);
    }

    public CommandSAOpenGUIs()
    {
      super();
      if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
        registerCommands();
      }
    }
    
    @SideOnly(Side.CLIENT)
    private void registerCommands()
    {
      //Vanilla
      addAvailableGui("crafting", GuiCrafting.class);
      addAvailableGui("furnace", GuiFurnace.class);
      addAvailableGui("anvil", GuiRepair.class);
      addAvailableGui("brewing", GuiBrewingStand.class);
      //Spirited Away
    }
    
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
	    {
	        if (args.length <= 0)
	        {
	       
	          }

	      }
	    }

	}