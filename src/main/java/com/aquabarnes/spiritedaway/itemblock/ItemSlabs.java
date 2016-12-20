package com.aquabarnes.spiritedaway.itemblock;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSlabs extends ItemBlock
{
private final BlockSlab singleSlab;
private final BlockSlab doubleSlab;

public ItemSlabs(Block block, BlockSlab singleSlab, BlockSlab doubleSlab)
{
  super(block);
  this.singleSlab = singleSlab;
  this.doubleSlab = doubleSlab;
  func_77656_e(0);
  func_77627_a(true);
}

public int func_77647_b(int damage)
{
  return damage;
}

public String func_77667_c(ItemStack stack)
{
  return this.singleSlab.func_150002_b(stack.func_77960_j());
}

public EnumActionResult func_180614_a(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
{
  if ((stack.field_77994_a != 0) && (playerIn.func_175151_a(pos.func_177972_a(facing), facing, stack)))
  {
    IBlockState iblockstate = worldIn.func_180495_p(pos);
    if (iblockstate.func_177230_c() == this.singleSlab)
    {
      BlockSlab.EnumBlockHalf blockslab$enumblockhalf = (BlockSlab.EnumBlockHalf)iblockstate.func_177229_b(BlockSlab.field_176554_a);
      if (((facing == EnumFacing.UP) && (blockslab$enumblockhalf == BlockSlab.EnumBlockHalf.BOTTOM)) || ((facing == EnumFacing.DOWN) && (blockslab$enumblockhalf == BlockSlab.EnumBlockHalf.TOP)))
      {
        IBlockState iblockstate1 = makeState();
        AxisAlignedBB axisalignedbb = iblockstate1.func_185890_d(worldIn, pos);
        if ((axisalignedbb != Block.field_185506_k) && (worldIn.func_72855_b(axisalignedbb.func_186670_a(pos))) && (worldIn.func_180501_a(pos, iblockstate1, 11)))
        {
          SoundType soundtype = this.doubleSlab.func_185467_w();
          worldIn.func_184133_a(playerIn, pos, soundtype.func_185841_e(), SoundCategory.BLOCKS, (soundtype.func_185843_a() + 1.0F) / 2.0F, soundtype.func_185847_b() * 0.8F);
          stack.field_77994_a -= 1;
        }
        return EnumActionResult.SUCCESS;
      }
    }
    return tryPlace(playerIn, stack, worldIn, pos.func_177972_a(facing)) ? EnumActionResult.SUCCESS : super.func_180614_a(stack, playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
  }
  return EnumActionResult.FAIL;
}

@SideOnly(Side.CLIENT)
public boolean func_179222_a(World worldIn, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack)
{
  BlockPos blockpos = pos;
  IBlockState iblockstate = worldIn.func_180495_p(pos);
  if (iblockstate.func_177230_c() == this.singleSlab)
  {
    boolean flag = iblockstate.func_177229_b(BlockSlab.field_176554_a) == BlockSlab.EnumBlockHalf.TOP;
    if (((side == EnumFacing.UP) && (!flag)) || ((side == EnumFacing.DOWN) && (flag))) {
      return true;
    }
  }
  pos = pos.func_177972_a(side);
  IBlockState iblockstate1 = worldIn.func_180495_p(pos);
  return iblockstate1.func_177230_c() == this.singleSlab ? true : super.func_179222_a(worldIn, blockpos, side, player, stack);
}

private boolean tryPlace(EntityPlayer player, ItemStack stack, World worldIn, BlockPos pos)
{
  IBlockState iblockstate = worldIn.func_180495_p(pos);
  if (iblockstate.func_177230_c() == this.singleSlab)
  {
    IBlockState iblockstate1 = makeState();
    AxisAlignedBB axisalignedbb = iblockstate1.func_185890_d(worldIn, pos);
    if ((axisalignedbb != Block.field_185506_k) && (worldIn.func_72855_b(axisalignedbb.func_186670_a(pos))) && (worldIn.func_180501_a(pos, iblockstate1, 11)))
    {
      SoundType soundtype = this.doubleSlab.func_185467_w();
      worldIn.func_184133_a(player, pos, soundtype.func_185841_e(), SoundCategory.BLOCKS, (soundtype.func_185843_a() + 1.0F) / 2.0F, soundtype.func_185847_b() * 0.8F);
      stack.field_77994_a -= 1;
    }
    return true;
  }
  return false;
}

protected <T extends Comparable<T>> IBlockState makeState()
{
  return this.doubleSlab.func_176223_P();
}
}
