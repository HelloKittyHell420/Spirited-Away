package com.aquabarnes.spiritedaway.client.gui.containers;

import com.aquabarnes.spiritedaway.tileenitity.TileEntityWorkbench;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerWorkbench extends Container { 
	
	  /** The crafting matrix inventory (3x3). */
      public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
      public IInventory craftResult = new InventoryCraftResult();
      private World worldObj;
      /** Position of the workbench */
      private BlockPos pos;
      
      public ContainerWorkbench(TileEntityWorkbench par2TileEntityFurnace, TileEntityWorkbench par2TileEntityHolystone) {
	  
      }

      @Override
      public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return false;
	}
	}
