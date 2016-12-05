package com.aquabarnes.spiritedaway.entity;

import com.aquabarnes.spiritedaway.entity.ai.EntityAIFollowHerd;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFindEntityNearest;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityShikigami extends EntityMob {

	    public EntityShikigami(World worldIn)
	    {
	        super(worldIn);
	        this.setSize(0.4F, 0.3F);
	    }

	    protected void initEntityAI()
	    {
	        //TODO: Make Shikigami follow one another.
	        //this.tasks.addTask(4, new EntityAIFollowHerd());
	        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
	        //TODO: Make These attack Haku Dragon if...?
	        //this.tasks.addTask(5, new EntityAIAttackHaku(this, 1.0D));
	        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
	        this.targetTasks.addTask(3, new EntityAIFindEntityNearest(this, EntityIronGolem.class));
	    }

	    protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
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
	    
	    protected boolean canDespawn()
	    {
	        return false;
	    }

	  }


