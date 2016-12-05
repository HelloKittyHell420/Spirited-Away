package com.aquabarnes.spiritedaway.entity.ai;

import com.aquabarnes.spiritedaway.entity.EntityKashira;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class AIKashiraAttack extends EntityAIBase
{
    private EntityKashira kashira;
    private int field_179465_b;

    public AIKashiraAttack(EntityKashira kashiraIn)
    {
        this.kashira = kashiraIn;
        this.setMutexBits(2);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        EntityLivingBase entitylivingbase = this.kashira.getAttackTarget();
        return entitylivingbase == null ? false : (!entitylivingbase.isEntityAlive() ? false : !(entitylivingbase instanceof EntityPlayer) || !((EntityPlayer)entitylivingbase).capabilities.disableDamage);
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.field_179465_b = 300;
        super.startExecuting();
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        EntityLivingBase entitylivingbase = this.kashira.getAttackTarget();
        return entitylivingbase == null ? false : (!entitylivingbase.isEntityAlive() ? false : (entitylivingbase instanceof EntityPlayer && ((EntityPlayer)entitylivingbase).capabilities.disableDamage ? false : --this.field_179465_b > 0));
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        this.kashira.faceEntity(this.kashira.getAttackTarget(), 10.0F, 10.0F);
        ((EntitySlime.SlimeMoveHelper)this.kashira.getMoveHelper()).func_179920_a(this.kashira.rotationYaw);
    }
}