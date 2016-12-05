package com.aquabarnes.spiritedaway.item;

import com.aquabarnes.spiritedaway.SpiritedAway;
import com.aquabarnes.spiritedaway.entity.EntityTrain;
import com.aquabarnes.spiritedaway.enums.TrainType;
import com.aquabarnes.spiritedaway.init.SACreativeTabs;

import java.util.List;

import net.minecraft.block.BlockRailBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemTrain extends Item {

private EntityTrain entityTrain;
private final TrainType trainType;

public ItemTrain(String name, int meta, TrainType type) 
{
  this.setUnlocalizedName(name);
  this.setCreativeTab(SACreativeTabs.tabSATransportation);
  this.trainType = type;
  GameRegistry.registerItem(this, name);
	this.setUnlocalizedName(name);
	    if (!SpiritedAway.isServer()) {
	      Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, meta, new ModelResourceLocation("sa:" + name, "inventory"));
	    }
	  }


public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
{
    IBlockState iblockstate = worldIn.getBlockState(pos);

    if (!BlockRailBase.isRailBlock(iblockstate))
    {
        return EnumActionResult.FAIL;
    }
    else
    {
        if (!worldIn.isRemote)
        {
            BlockRailBase.EnumRailDirection blockrailbase$enumraildirection = iblockstate.getBlock() instanceof BlockRailBase ? (BlockRailBase.EnumRailDirection)iblockstate.getValue(((BlockRailBase)iblockstate.getBlock()).getShapeProperty()) : BlockRailBase.EnumRailDirection.NORTH_SOUTH;
            double d0 = 0.0D;

            if (blockrailbase$enumraildirection.isAscending())
            {
                d0 = 0.5D;
            }

            EntityTrain entitytrain = EntityTrain.func_184263_a(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.0625D + d0, (double)pos.getZ() + 0.5D, this.trainType);

            if (stack.hasDisplayName())
            {
                entitytrain.setCustomNameTag(stack.getDisplayName());
            }

            worldIn.spawnEntityInWorld(entitytrain);
        }

        --stack.stackSize;
        return EnumActionResult.SUCCESS;
    }
}
}