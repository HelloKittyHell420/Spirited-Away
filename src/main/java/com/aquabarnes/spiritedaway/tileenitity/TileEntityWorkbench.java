package com.aquabarnes.spiritedaway.tileenitity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;

public class TileEntityWorkbench extends TileEntity implements IInventory, ISidedInventory {

	 	private ItemStack[] chestContents = new ItemStack[27];
	    /** The number of players currently using this chest */
	    public int numPlayersUsing;
	    /** Server sync counter (once per 20 ticks) */
	    private int ticksSinceSync;
	    private BlockChest.Type cachedChestType;
	    private String customName;

	    public TileEntityWorkbench()
	    {
	    }

	    public TileEntityWorkbench(BlockChest.Type p_i46677_1_)
	    {
	        this.cachedChestType = p_i46677_1_;
	    }

	    /**
	     * Returns the number of slots in the inventory.
	     */
	    public int getSizeInventory()
	    {
	        return 27;
	    }

		public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasCustomName() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public ItemStack getStackInSlot(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ItemStack decrStackSize(int index, int count) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ItemStack removeStackFromSlot(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setInventorySlotContents(int index, ItemStack stack) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getInventoryStackLimit() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isUseableByPlayer(EntityPlayer player) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void openInventory(EntityPlayer player) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void closeInventory(EntityPlayer player) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isItemValidForSlot(int index, ItemStack stack) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int getField(int id) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setField(int id, int value) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getFieldCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public ITextComponent getDisplayName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int[] getSlotsForFace(EnumFacing side) {
			// TODO Auto-generated method stub
			return null;
		}
}