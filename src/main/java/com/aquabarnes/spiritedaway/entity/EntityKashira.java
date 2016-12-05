package com.aquabarnes.spiritedaway.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
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

public class EntityKashira extends EntityMob {
	
	private boolean wasOnGround;

    public EntityKashira(World worldIn)
    {
        super(worldIn);
        this.setSize(0.9F, 1.4F);
        this.moveHelper = new EntityKashira.MoveHelper(this);
    }

    protected void initEntityAI()
    {
        //this.tasks.addTask(1, new EntitySlime.AISlimeFloat(this));
        //this.tasks.addTask(2, new EntitySlime.AISlimeAttack(this));
        //this.tasks.addTask(3, new EntitySlime.AISlimeFaceRandom(this));
        //this.tasks.addTask(5, new EntitySlime.AISlimeHop(this));;
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.WHEAT, false));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
    }
    
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setBoolean("wasOnGround", this.wasOnGround);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.wasOnGround = compound.getBoolean("wasOnGround");
    }

	/**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }
    
    protected boolean canDespawn()
    {
        return false;
	}
    
    /**
     * Returns true if the slime makes a sound when it jumps (based upon the slime's size)
     */
    @SuppressWarnings("null")
	protected boolean makesSoundOnJump()
    {
        return (Boolean) null;
    }
    
    /**
     * Gets the amount of time the slime needs to wait between jumps.
     */
    protected int getJumpDelay()
    {
        return this.rand.nextInt(20) + 10;
    }
    
    protected SoundEvent getJumpSound()
    {
        return SoundEvents.ENTITY_SMALL_SLIME_JUMP;
    }

    
		static class MoveHelper extends EntityMoveHelper
        {
            private float yRot;
            private int jumpDelay;
            private final EntityKashira kashira;
            private boolean isAggressive;

            public MoveHelper(EntityKashira kashiraIn)
            {
                super(kashiraIn);
                this.kashira = kashiraIn;
                this.yRot = 180.0F * kashiraIn.rotationYaw / (float)Math.PI;
            }

            public void setDirection(float p_179920_1_, boolean p_179920_2_)
            {
                this.yRot = p_179920_1_;
                this.isAggressive = p_179920_2_;
            }

            public void setSpeed(double speedIn)
            {
                this.speed = speedIn;
                this.action = EntityMoveHelper.Action.MOVE_TO;
            }

            public void onUpdateMoveHelper()
            {
                this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, this.yRot, 90.0F);
                this.entity.rotationYawHead = this.entity.rotationYaw;
                this.entity.renderYawOffset = this.entity.rotationYaw;

                if (this.action != EntityMoveHelper.Action.MOVE_TO)
                {
                    this.entity.setMoveForward(0.0F);
                }
                else
                {
                    this.action = EntityMoveHelper.Action.WAIT;

                    if (this.entity.onGround)
                    {
                        this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));

                        if (this.jumpDelay-- <= 0)
                        {
                            this.jumpDelay = this.kashira.getJumpDelay();

                            if (this.isAggressive)
                            {
                                this.jumpDelay /= 3;
                            }

                            this.kashira.getJumpHelper().setJumping();

                            if (this.kashira.makesSoundOnJump())
                            {
                                this.kashira.playSound(this.kashira.getJumpSound(), this.kashira.getSoundVolume(), ((this.kashira.getRNG().nextFloat() - this.kashira.getRNG().nextFloat()) * 0.2F + 1.0F) * 0.8F);
                            }
                        }
                        else
                        {
                            this.kashira.moveStrafing = 0.0F;
                            this.kashira.moveForward = 0.0F;
                            this.entity.setAIMoveSpeed(0.0F);
                        }
                    }
                    else
                    {
                        this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
                    }
                }
            }
        }
}
