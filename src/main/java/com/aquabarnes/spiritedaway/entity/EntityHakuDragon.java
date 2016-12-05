package com.aquabarnes.spiritedaway.entity;

import java.util.UUID;

import com.google.common.base.Optional;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.dragon.phase.PhaseList;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public class EntityHakuDragon extends EntityDragon {

	private static final DataParameter<Boolean> SADDLED = EntityDataManager.<Boolean>createKey(EntityHakuDragon.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager.<Optional<UUID>>createKey(EntityHorse.class, DataSerializers.OPTIONAL_UNIQUE_ID);
	
    public EntityHakuDragon(World worldIn)
    {
        super(worldIn);
        this.setSize(6.0F, 6.0F);
        this.isImmuneToFire = true;
        this.noClip = false;
    }

    protected void initEntityAI()

    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
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
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }
    
    public float scaleSize()
    {
        return 0.5F;
    }
    
    public float spiderScaleAmount()
    {
      return 0.5F;
    }
    
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setBoolean("Saddle", this.getSaddled());
        //tagCompound.setInteger("DragonPhase", this.phaseManager.getCurrentPhase().getPhaseList().getId());
    }
    
        public boolean getSaddled()
        {
            return ((Boolean)this.dataWatcher.get(SADDLED)).booleanValue();
        }
        
        /**
         * Set or remove the saddle of the pig.
         */
        public void setSaddled(boolean saddled)
        {
            if (saddled)
            {
                this.dataWatcher.set(SADDLED, Boolean.valueOf(true));
            }
            else
            {
                this.dataWatcher.set(SADDLED, Boolean.valueOf(false));
            }
        }


	/**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);
        this.setSaddled(tagCompund.getBoolean("Saddle"));
        if (tagCompund.hasKey("DragonPhase"))
        {
           // this.phaseManager.setPhase(PhaseList.getById(tagCompund.getInteger("DragonPhase")));
        }
    }
    
    @Override
    public boolean isNonBoss(){return false;}
    private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfoServer.Color.BLUE, BossInfoServer.Overlay.NOTCHED_10));
    @Override
    public void setBossVisibleTo(EntityPlayerMP player){super.setBossVisibleTo(player);this.bossInfo.addPlayer(player);}
    @Override
    public void setBossNonVisibleTo(EntityPlayerMP player){super.setBossNonVisibleTo(player);this.bossInfo.removePlayer(player);}
    @Override
    public void onUpdate(){super.onUpdate();this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());}
  }
