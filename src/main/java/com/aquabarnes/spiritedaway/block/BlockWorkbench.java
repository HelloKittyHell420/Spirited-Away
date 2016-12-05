package com.aquabarnes.spiritedaway.block;

import com.aquabarnes.spiritedaway.init.SABlocks;
import com.aquabarnes.spiritedaway.init.SAGuiHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockWorkbench extends Block {

	  private static boolean keepInventory;
	
		public BlockWorkbench(Material material) {
			super(Material.wood);
	        setUnlocalizedName("crafting_table");
	        setRegistryName("crafting_table");   
	        GameRegistry.registerBlock(this);
	        GameRegistry.register(this); getRegistryName();
		}
		   public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
		    {
		        if (worldIn.isRemote)
		        {
		            return true;
		        }
		        else
		        {
		            playerIn.displayGui(new BlockWorkbench.InterfaceCraftingTable(worldIn, pos));
		            playerIn.addStat(StatList.craftingTableInteraction);
		            return true;
		        }
		    }

		    public static class InterfaceCraftingTable implements IInteractionObject
		        {
		            private final World world;
		            private final BlockPos position;

		            public InterfaceCraftingTable(World worldIn, BlockPos pos)
		            {
		                this.world = worldIn;
		                this.position = pos;
		            }

		            /**
		             * Get the name of this object. For players this returns their username
		             */
		            public String getName()
		            {
		                return null;
		            }

		            /**
		             * Returns true if this thing is named
		             */
		            public boolean hasCustomName()
		            {
		                return false;
		            }

		            /**
		             * Get the formatted ChatComponent that will be used for the sender's username in chat
		             */
		            public ITextComponent getDisplayName()
		            {
		                return new TextComponentTranslation(SABlocks.CRAFTING_TABLE.getUnlocalizedName() + ".name", new Object[0]);
		            }

		            public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
		            {
		                return new ContainerWorkbench(playerInventory, this.world, this.position);
		            }

		            public String getGuiID()
		            {
		                return "minecraft:crafting_table";
		            }
		        }
		}