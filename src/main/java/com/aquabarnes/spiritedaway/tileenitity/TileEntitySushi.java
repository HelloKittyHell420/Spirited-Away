package com.aquabarnes.spiritedaway.tileenitity;

import com.aquabarnes.spiritedaway.init.SAItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySushi extends TileEntity {
	
	public int sushiCount = 0;
	
	public boolean addSushi() {
		if(sushiCount < 8) {
			sushiCount++;
			markDirty();
			IBlockState state = worldObj.getBlockState(pos);
			worldObj.notifyBlockUpdate(pos, state, state, 3);
			return true;
		}
		return false;
	}
	
	public void removeSushi() {
		if(sushiCount > 0) {
			worldObj.spawnEntityInWorld(new EntityItem(worldObj, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, new ItemStack(Items.fish)));
			sushiCount--;
			markDirty();
			IBlockState state = worldObj.getBlockState(pos);
			worldObj.notifyBlockUpdate(pos, state, state, 3);
			}
		}

	    public NBTTagCompound writetoNBT(NBTTagCompound compound) {
			super.writeToNBT(compound);
			this.readUpdateTag(compound);
			return compound;
		
		}
		
	    public NBTTagCompound readfromNBT(NBTTagCompound compound) {
			super.readFromNBT(compound);
			this.writeUpdateTag(compound);
			return compound;
		}
		
	    @Override
	    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
	    	NBTTagCompound tag = packet.getNbtCompound();
	    	readUpdateTag(tag);
	    }
	    
	    public SPacketUpdateTileEntity getUpdatepacket() {
	    	NBTTagCompound tag = new NBTTagCompound();
	    	this.writetoNBT(tag);
	    	return new SPacketUpdateTileEntity(getPos(), getBlockMetadata(), tag); 
	    }
			
		public void writeUpdateTag(NBTTagCompound tag) {
			tag.setInteger("SushiCount", this.sushiCount);
			
		}
		
	
		public void readUpdateTag(NBTTagCompound tag) {
			this.sushiCount = tag.getInteger("SushiCount");
			
		}
	}
