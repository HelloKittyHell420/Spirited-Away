package com.aquabarnes.spiritedaway.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSlab.EnumBlockHalf;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSlabs extends BlockSlab
{
private String name;
private boolean double_slab;

public BlockSlabs(String name, boolean double_slab, Material materialIn)
{
  super(materialIn);
  this.name = name;
  this.double_slab = double_slab;
  
  func_180632_j(double_slab ? func_176223_P() : func_176223_P().func_177226_a(field_176554_a, BlockSlab.EnumBlockHalf.BOTTOM));
  func_149672_a(materialIn == Material.field_151575_d ? SoundType.field_185848_a : SoundType.field_185851_d);
}

public ItemStack func_185473_a(World worldIn, BlockPos pos, IBlockState state)
{
  return new ItemStack(getDroppedSlab(), 1, 0);
}

public Block getDroppedSlab()
{
  if (this == SABlocks.skyroot_double_slab) {
    return SABlocks.skyroot_slab;
  }
  return this;
}

public Item func_180660_a(IBlockState state, Random rand, int fortune)
{
  return Item.func_150898_a(getDroppedSlab());
}

public int func_180651_a(IBlockState state)
{
  return 0;
}

public boolean func_176552_j()
{
  return (this.double_slab) && (this.name.contains("double"));
}

public IBlockState func_180642_a(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
{
  IBlockState iblockstate = super.func_180642_a(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
  return (facing != EnumFacing.DOWN) && ((facing == EnumFacing.UP) || (hitY <= 0.5D)) ? iblockstate.func_177226_a(field_176554_a, BlockSlab.EnumBlockHalf.BOTTOM) : func_176552_j() ? iblockstate : iblockstate.func_177226_a(field_176554_a, BlockSlab.EnumBlockHalf.TOP);
}

public IBlockState func_176203_a(int meta)
{
  if (!func_176552_j()) {
    return func_176223_P().func_177226_a(field_176554_a, meta == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
  }
  return func_176223_P();
}

public int func_176201_c(IBlockState state)
{
  if (!func_176552_j())
  {
    if (state.func_177229_b(field_176554_a) == BlockSlab.EnumBlockHalf.BOTTOM) {
      return 0;
    }
    if (state.func_177229_b(field_176554_a) == BlockSlab.EnumBlockHalf.TOP) {
      return 1;
    }
  }
  return 0;
}

protected BlockStateContainer func_180661_e()
{
  return func_176552_j() ? new BlockStateContainer(this, new IProperty[0]) : new BlockStateContainer(this, new IProperty[] { field_176554_a });
}

public String func_150002_b(int meta)
{
  return this.name;
}

public IProperty<?> func_176551_l()
{
  return null;
}

public Comparable<?> func_185674_a(ItemStack stack)
{
  return null;
}
}