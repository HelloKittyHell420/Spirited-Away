package com.aquabarnes.spiritedaway.entity.ai;

import com.aquabarnes.spiritedaway.entity.EntityKashira;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathNavigateGround;

public class AIKashiraFloat extends EntityAIBase
{
    private EntityKashira kashira;

    public AIKashiraFloat(EntityKashira kashiraIn)
    {
        this.kashira = kashiraIn;
        this.setMutexBits(5);
        ((PathNavigateGround)kashiraIn.getNavigator()).setCanSwim(true);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return this.kashira.isInWater() || this.kashira.isInLava();
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        if (this.kashira.getRNG().nextFloat() < 0.8F)
        {
            this.kashira.getJumpHelper().setJumping();
        }

        ((EntitySlime.SlimeMoveHelper)this.slime.getMoveHelper()).setSpeed(1.2D);
    }
}
