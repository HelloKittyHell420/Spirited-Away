package com.aquabarnes.spiritedaway.entity;

import java.util.Map;

import com.aquabarnes.spiritedaway.enums.TrainType;
import com.aquabarnes.spiritedaway.init.SAItems;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockRailPowered;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.item.EntityMinecartCommandBlock;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.entity.item.EntityMinecartFurnace;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.item.EntityMinecartMobSpawner;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class EntityTrain extends Entity implements IWorldNameable
{
	private static final DataParameter<Integer> field_184265_a = EntityDataManager.<Integer>createKey(EntityMinecart.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> field_184266_b = EntityDataManager.<Integer>createKey(EntityMinecart.class, DataSerializers.VARINT);
	private static final DataParameter<Float> field_184267_c = EntityDataManager.<Float>createKey(EntityMinecart.class, DataSerializers.FLOAT);
	private static final DataParameter<Integer> field_184268_d = EntityDataManager.<Integer>createKey(EntityMinecart.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> field_184269_e = EntityDataManager.<Integer>createKey(EntityMinecart.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> SHOW_BLOCK = EntityDataManager.<Boolean>createKey(EntityMinecart.class, DataSerializers.BOOLEAN);
	private boolean isInReverse;
	/** Minecart rotational logic matrix */
	private static final int[][][] matrix = new int[][][] {{{0, 0, -1}, {0, 0, 1}}, {{ -1, 0, 0}, {1, 0, 0}}, {{ -1, -1, 0}, {1, 0, 0}}, {{ -1, 0, 0}, {1, -1, 0}}, {{0, 0, -1}, {0, -1, 1}}, {{0, -1, -1}, {0, 0, 1}}, {{0, 0, 1}, {1, 0, 0}}, {{0, 0, 1}, { -1, 0, 0}}, {{0, 0, -1}, { -1, 0, 0}}, {{0, 0, -1}, {1, 0, 0}}};
	/** appears to be the progress of the turn */
	private int turnProgress;
	private double minecartX;
	private double minecartY;
	private double minecartZ;
	private double minecartYaw;
	private double minecartPitch;
	@SideOnly(Side.CLIENT)
	private double velocityX;
	@SideOnly(Side.CLIENT)
	private double velocityY;
	@SideOnly(Side.CLIENT)
	private double velocityZ;
	
	public static int trainType;

	public EntityTrain(World worldIn) {
		super(worldIn);
		this.preventEntitySpawning = true;
		this.setSize(0.98F, 0.7F);
	}

	public EntityTrain(World var1, double var2, double var4, double var6, int type)
	{	
		this(var1);
		//func_70107_b(var2, var4 + this.field_70129_M, var6);
		setTrainType(type);
		//this.trainType;
	}
	
    public static EntityTrain func_184263_a(World worldIn, double x, double y, double z, TrainType typeIn)
    {
        switch (typeIn)
        {
            default:
                return new EntityTrainEmpty(worldIn, x, y, z);
        }
    }
      
	private void setTrainType(int type) 
	{
		this.trainType = type;
	}

	public int getType()
	{
		return this.trainType;
	}

	public ItemStack getItem()
	{
		return new ItemStack(SAItems.TRAIN, 1, this.trainType); 
	} 

	@Override
	protected void entityInit() {
	
    this.dataWatcher.register(field_184265_a, Integer.valueOf(0));
    this.dataWatcher.register(field_184266_b, Integer.valueOf(1));
    this.dataWatcher.register(field_184267_c, Float.valueOf(0.0F));
    this.dataWatcher.register(field_184268_d, Integer.valueOf(0));
    this.dataWatcher.register(field_184269_e, Integer.valueOf(6));
    this.dataWatcher.register(SHOW_BLOCK, Boolean.valueOf(false));
}

	public void func_174899_a(IBlockState p_174899_1_)
	{
		this.getDataManager().set(field_184268_d, Integer.valueOf(Block.getStateId(p_174899_1_)));
		this.setHasDisplayTile(true);
	}

	public void setDisplayTileOffset(int p_94086_1_)
	{
		this.getDataManager().set(field_184269_e, Integer.valueOf(p_94086_1_));
		this.setHasDisplayTile(true);
	}

	public boolean hasDisplayTile()
	{
    	return ((Boolean)this.getDataManager().get(SHOW_BLOCK)).booleanValue();
	}

	public void setHasDisplayTile(boolean p_94096_1_)
	{
    	this.getDataManager().set(SHOW_BLOCK, Boolean.valueOf(p_94096_1_));
	}
   
    private int getDisplayTileOffset()
    {
        return !this.hasDisplayTile() ? this.getDefaultDisplayTileOffset() : ((Integer)this.getDataManager().get(field_184269_e)).intValue();
    }


    private int getDefaultDisplayTileOffset() {

    	return 6;
    }
    
    public IBlockState getDisplayTile()
    {
        return !this.hasDisplayTile() ? this.getDefaultDisplayTile() : Block.getStateById(((Integer)this.getDataManager().get(field_184268_d)).intValue());
    }

    public IBlockState getDefaultDisplayTile()
    {
        return Blocks.air.getDefaultState();
    }

    protected void writeEntityToNBT(NBTTagCompound tagCompound)
    {
    if (this.hasDisplayTile())
    {
        tagCompound.setBoolean("CustomDisplayTile", true);
        IBlockState iblockstate = this.getDisplayTile();
        ResourceLocation resourcelocation = (ResourceLocation)Block.blockRegistry.getNameForObject(iblockstate.getBlock());
        tagCompound.setString("DisplayTile", resourcelocation == null ? "" : resourcelocation.toString());
        tagCompound.setInteger("DisplayData", iblockstate.getBlock().getMetaFromState(iblockstate));
        tagCompound.setInteger("DisplayOffset", this.getDisplayTileOffset());
    }
    }
    
    protected void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        if (tagCompund.getBoolean("CustomDisplayTile"))
        {
            Block block;

            if (tagCompund.hasKey("DisplayTile", 8))
            {
                block = Block.getBlockFromName(tagCompund.getString("DisplayTile"));
            }
            else
            {
                block = Block.getBlockById(tagCompund.getInteger("DisplayTile"));
            }

            int i = tagCompund.getInteger("DisplayData");
            this.func_174899_a(block == null ? Blocks.air.getDefaultState() : block.getStateFromMeta(i));
            this.setDisplayTileOffset(tagCompund.getInteger("DisplayOffset"));
        }
    }

}


