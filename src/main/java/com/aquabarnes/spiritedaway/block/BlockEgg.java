package com.aquabarnes.spiritedaway.block;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockEgg extends Block {

	protected static final AxisAlignedBB DRAGON_EGG_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 1.0D, 0.9375D);
	private final List<TileEntityBeacon.BeamSegment> beamSegments = Lists.<TileEntityBeacon.BeamSegment>newArrayList();
    protected World worldObj;
    protected BlockPos pos = BlockPos.ORIGIN;
    protected boolean tileEntityInvalid;
    private int blockMetadata = -1;
    private long beamRenderCounter;
    @SideOnly(Side.CLIENT)
    private float field_146014_j;
    private boolean isComplete;
    /** Level of this beacon's pyramid. */
    private int levels = -1;
    /** Primary potion effect given by this beacon. */
    private Potion primaryEffect;
    /** Secondary potion effect given by this beacon. */
    private Potion secondaryEffect;
    /** Item given to this beacon as payment. */
    private ItemStack payment;
    private String customName;
  
	  public BlockEgg(String name, Material material)
	  {
	    super(Material.dragonEgg);
	    setUnlocalizedName(name);
	    setRegistryName(name);
	  }
	  
	  @SideOnly(Side.CLIENT)
	    public List<TileEntityBeacon.BeamSegment> getBeamSegments()
	    {
	        return this.beamSegments;
	    }

	    @SideOnly(Side.CLIENT)
	    public float shouldBeamRender()
	    {
	            int i = (int)(this.worldObj.getTotalWorldTime() - this.beamRenderCounter);
	            this.beamRenderCounter = this.worldObj.getTotalWorldTime();

	            if (i > 1)
	            {
	                this.field_146014_j -= (float)i / 40.0F;

	                if (this.field_146014_j < 0.0F)
	                {
	                    this.field_146014_j = 0.0F;
	                }
	            }

	            this.field_146014_j += 0.025F;

	            if (this.field_146014_j > 1.0F)
	            {
	                this.field_146014_j = 1.0F;
	            }

	            return this.field_146014_j;
	        }
	    

public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
{
	        return DRAGON_EGG_AABB;
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
public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
{
    return true;
}
}
