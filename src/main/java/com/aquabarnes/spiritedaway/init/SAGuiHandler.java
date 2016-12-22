package com.aquabarnes.spiritedaway.init;

import java.awt.Container;


import com.aquabarnes.spiritedaway.client.gui.GuiCrafting;
import com.aquabarnes.spiritedaway.gui.GuiBook;
import com.aquabarnes.spiritedaway.inventory.ContainerCrafting;
import com.aquabarnes.spiritedaway.inventory.ContainerShrine;
import com.aquabarnes.spiritedaway.tileenitity.TileEntityWorkbench;

import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SAGuiHandler implements IGuiHandler
{

	public static final int book = 1;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{

		if (ID == book)
		{
			//return new Container(player.inventory);
		}

		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == book)
		{
			//return new GuiBook(player.inventory);
		}

		return null;
	}

}