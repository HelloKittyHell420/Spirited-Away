package com.aquabarnes.spiritedaway.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityHakuHuman extends EntityMob {

private static final DataParameter<Integer> CHIHIRO_TYPE = EntityDataManager.<Integer>createKey(EntityChihiro.class, DataSerializers.VARINT);
	
	public EntityHakuHuman(World worldIn)
    {
        super(worldIn);
        this.setSize(0.8F, 2.36F);
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.wheat, false));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.dataWatcher.register(CHIHIRO_TYPE, Integer.valueOf(0));
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.entity_cow_ambient;
    }

    protected SoundEvent getHurtSound()
    {
        return SoundEvents.entity_cow_hurt;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.entity_cow_death;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.entity_cow_step, 0.15F, 1.0F);
    }
    
    /**
     * Return this Frogman's type.
     */
    public int getFrogmanType()
    {
        return ((Integer)this.dataWatcher.get(CHIHIRO_TYPE)).intValue();
    }

    /**
     * Set this Frogman's type.
     */
    public void setFrogmanType(int p_82201_1_)
    {
        this.dataWatcher.set(CHIHIRO_TYPE, Integer.valueOf(p_82201_1_));
    }
    
    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);

        if (tagCompund.hasKey("ChihiroType", 99))
        {
            int i = tagCompund.getByte("ChihiroType");
            this.setFrogmanType(i);
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setByte("ChihiroType", (byte)this.getFrogmanType());
    }



    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }
    
    public float scaleSize()
    {
        return 1.0F;
    }
    
    public float spiderScaleAmount()
    {
      return 0.5F;
    }
    
    protected boolean canDespawn()
    {
        return false;
    }

    
}


