package com.aquabarnes.spiritedaway.init;

import java.awt.Container;

import com.aquabarnes.spiritedaway.client.gui.GuiCrafting;
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

public class SAGuiHandler implements IGuiHandler {
	
public static final int craftingID = 1;
public static final int furnaceID = 2;	
	
@SideOnly(Side.SERVER)
public Object getServerGuiElement(int guiId, EntityPlayer player, World world, int posX, int posY, int posZ)
{
    TileEntity tile_entity = world.getTileEntity(new BlockPos(posX, posX, posZ));
    //if ((tile_entity instanceof TileEntityFridge)) {
      //return new ContainerShrine(player.inventory, (TileEntityFridge)tile_entity);
    return null;
}

@SideOnly(Side.CLIENT)
public Object getClientGuiElement(int guiId, EntityPlayer player, World world, int posX, int posY, int posZ)
{
   TileEntity tile_entity = world.getTileEntity(new BlockPos(posX, posY, posZ));
   //if ((tile_entity instanceof TileEntityFridge)) {
      //return new GuiFurnace(player.field_71071_by, (TileEntityFridge)tile_entity);
   
    FMLLog.getLogger().fatal("Failed to handle provided GUI ID: " + guiId + ". Please report!, This is a Programming error");
	return null;
}
}
