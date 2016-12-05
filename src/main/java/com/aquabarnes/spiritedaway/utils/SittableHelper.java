package com.aquabarnes.spiritedaway.utils;

import java.util.List;

import com.aquabarnes.spiritedaway.entity.EntitySittableBlock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class SittableHelper
{
  public static boolean sitOnBlock(World par1World, double x, double y, double z, EntityPlayer par5EntityPlayer, double par6)
  {
    if (!checkForExistingEntity(par1World, x, y, z, par5EntityPlayer))
    {
      EntitySittableBlock nemb = new EntitySittableBlock(par1World, x, y, z, par6);
      par1World.func_72838_d(nemb);
      par5EntityPlayer.func_70078_a(nemb);
    }
    return true;
  }
  
  public static boolean sitOnBlockWithRotationOffset(World par1World, double x, double y, double z, EntityPlayer par5EntityPlayer, double par6, int metadata, double offset)
  {
    if (!checkForExistingEntity(par1World, x, y, z, par5EntityPlayer))
    {
      EntitySittableBlock nemb = new EntitySittableBlock(par1World, x, y, z, par6, metadata, offset);
      par1World.func_72838_d(nemb);
      par5EntityPlayer.func_70078_a(nemb);
    }
    return true;
  }
  
  public static boolean checkForExistingEntity(World par1World, double x, double y, double z, EntityPlayer par5EntityPlayer)
  {
    List<EntitySittableBlock> listEMB = par1World.func_72872_a(EntitySittableBlock.class, new AxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D).func_72314_b(1.0D, 1.0D, 1.0D));
    for (EntitySittableBlock mount : listEMB) {
      if ((mount.blockPosX == x) && (mount.blockPosY == y) && (mount.blockPosZ == z))
      {
        if (mount.field_70153_n == null) {
          par5EntityPlayer.func_70078_a(mount);
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean isSomeoneSitting(World world, double x, double y, double z)
  {
    List<EntitySittableBlock> listEMB = world.func_72872_a(EntitySittableBlock.class, new AxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D).func_72314_b(1.0D, 1.0D, 1.0D));
    for (EntitySittableBlock mount : listEMB) {
      if ((mount.blockPosX == x) && (mount.blockPosY == y) && (mount.blockPosZ == z)) {
        return mount.field_70153_n != null;
      }
    }
    return false;
  }
}
