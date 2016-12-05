package com.aquabarnes.spiritedaway.itemblock;

import java.util.List;

import com.aquabarnes.spiritedaway.enums.EnumColors;
import com.aquabarnes.spiritedaway.enums.EnumFood;
import com.aquabarnes.spiritedaway.enums.EnumPlankTypes;
import com.aquabarnes.spiritedaway.init.SACreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBowl extends Block implements IMetaBlockName {

	public static final PropertyEnum<EnumColors> COLOR = PropertyEnum.<EnumColors>create("color", EnumColors.class);
	public static final PropertyEnum<EnumFood> FOOD = PropertyEnum.<EnumFood>create("food", EnumFood.class);
	//TODO: Contain's [Mushroom/Rabbit/Beetroot] And my mod stuff!

	protected static final AxisAlignedBB BOWL_AABB = new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 0.375D, 0.6875D);

	public BlockBowl(String name) {
		
		super(Material.ROCK);
        setUnlocalizedName(name);
        setRegistryName(name);
	    this.setCreativeTab(SACreativeTabs.BUILDING_BLOCKS);
	    this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumColors.WHITE).withProperty(FOOD, EnumFood.EMPTY));


        GameRegistry.register(this);
        GameRegistry.register(new ItemBlockMeta(this), getRegistryName());
	  }
	
      public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
      {
        return BOWL_AABB;
      }

      public boolean isTranslucent(IBlockState state)
      {
        return true;
      }

      public boolean isOpaqueCube(IBlockState state)
      {
    	return false;
      }
    
      public boolean isFullCube(IBlockState state)
      {
    	return false;
      }
	
      @SideOnly(Side.CLIENT)
      public BlockRenderLayer getBlockLayer()
      {
        return BlockRenderLayer.CUTOUT_MIPPED;
      }
      
      public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
      {
          if (worldIn.isRemote)
          {
              return true;
          }
          if (heldItem == null)
          {
              return true;
          }
          else
          {
        	  //playerIn.addedToChunk
        	  
              Item item = heldItem.getItem();
              EnumFood food = (EnumFood)state.getValue(FOOD);

              if (item == Items.MUSHROOM_STEW)
              {
                      if (!playerIn.capabilities.isCreativeMode) 
                      //if(hasMushroom(state))
                      {
                          playerIn.setHeldItem(hand, new ItemStack(Items.BOWL));
                      }
                      
                      worldIn.setBlockState(pos, state.withProperty(FOOD, EnumFood.MUSHROOMSOUP));
                      worldIn.notifyBlockOfStateChange(pos, this);
                      playerIn.addChatComponentMessage(new TextComponentString("SET BOWL TO MUSHROOM SOUP."));;
                  }
              
              else if (item == Items.BEETROOT_SOUP)
          	  {
                    if (!playerIn.capabilities.isCreativeMode) 
                    //if(hasBeetroot(state))
                    {
                        playerIn.setHeldItem(hand, new ItemStack(Items.BOWL));
                    }
                    
                    worldIn.setBlockState(pos, state.withProperty(FOOD, EnumFood.BEETROOTSOUP));;
                    worldIn.notifyBlockOfStateChange(pos, this);
                    playerIn.addChatComponentMessage(new TextComponentString("SET BOWL TO BEETROOT SOUP."));;
          	  	  }
          	  
              else if (item == Items.RABBIT_STEW)
          	  {
                    if (!playerIn.capabilities.isCreativeMode) 
                    //if(hasRabbit(state))
                    {
                        playerIn.setHeldItem(hand, new ItemStack(Items.BOWL));
                    }
                    
                    worldIn.setBlockState(pos, state.withProperty(FOOD, EnumFood.RABBITSTEW));
                    worldIn.notifyBlockOfStateChange(pos, this);
                    playerIn.addChatComponentMessage(new TextComponentString("SET BOWL TO RABBIT STEW."));
          	  }
          }
		return true;
          
      }
	  		  
	  public int damageDropped(IBlockState state)
	  {
	    return ((EnumColors)state.getValue(COLOR)).getMetadata();
	  }
	  
	  public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, Block block, BlockPos pos, EntityPlayer player)
	  {
		  return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	  }

	  @SideOnly(Side.CLIENT)
	  public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
	    {
	        for (EnumColors blockplanks$enumtype : EnumColors.values())
	        {
	            list.add(new ItemStack(itemIn, 1, blockplanks$enumtype.getMetadata()));
	        }
	    }
	  
	  public String getSpecialName(ItemStack stack) 
	  {
	      if(stack.getItemDamage() == 0)
	    	  return "white";
	      if(stack.getItemDamage() == 1)
	    	  return "orange";
	      if(stack.getItemDamage() == 2)
	    	  return "magenta";
	      if(stack.getItemDamage() == 3)
	    	  return "light_blue";
	      if(stack.getItemDamage() == 4)
	    	  return "yellow";
	      if(stack.getItemDamage() == 5)
	    	  return "lime";
	      if(stack.getItemDamage() == 6)
	    	  return "pink";
	      if(stack.getItemDamage() == 7)
	    	  return "gray";
	      if(stack.getItemDamage() == 8)
	    	  return "silver";
	      if(stack.getItemDamage() == 9)
	    	  return "cyan";
	      if(stack.getItemDamage() == 10)
	    	  return "purple";
	      if(stack.getItemDamage() == 11)
	    	  return "blue";
	      if(stack.getItemDamage() == 12)
	    	  return "brown";
	      if(stack.getItemDamage() == 13)
	    	  return "green";
	      if(stack.getItemDamage() == 14)
	    	  return "red";
	      if(stack.getItemDamage() == 15)
	    	  return "black";

		return "white";
	  }
	  
	  public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	  {
		//if (state.getValue(FOOD) == EnumFood.EMPTY)
		return state;
	  }
	  
	  public IBlockState getStateFromMeta(int meta)
	  {
	     return this.getDefaultState().withProperty(COLOR, EnumColors.byMetadata(meta)).withProperty(FOOD, (meta & 1) > 0 ? EnumFood.EMPTY : EnumFood.EMPTY);
	  }
	   
	  public int getMetaFromState(IBlockState state)
	  {
		 int i = 0;
	     //return ((EnumColor)state.getValue(COLOR)).getMetadata(); 
	    	
	     	if (state.getValue(FOOD) == EnumFood.EMPTY);
	           {
	                i |= 1;
	            }

	        return i;
	  }

	  protected BlockStateContainer createBlockState()
	  {
	     return new BlockStateContainer(this, new IProperty[] {COLOR, FOOD});
	  }
	    
	   
}