package com.aquabarnes.spiritedaway.entity.ai;

import com.aquabarnes.spiritedaway.entity.EntityKashira;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntitySlime;

public class AIKashiraHop extends EntityAIBase {
    
    public EntityKashira kashira;

    public AIKashiraHop(EntityKashira kashiraIn)
    {
        this.kashira = kashiraIn;
        this.setMutexBits(5);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return true;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        ((AIKashiraHop.KashiraMoveHelper)this.kashira.getMoveHelper()).setSpeed(1.0D);
    }
}

static class KashiraMoveHelper extends EntityMoveHelper
{
    private float field_179922_g;
    private int field_179924_h;
    private EntitySlime slime;
    private boolean field_179923_j;

    public KashiraMoveHelper(EntitySlime slimeIn)
    {
        super(slimeIn);
        this.slime = slimeIn;
        this.field_179922_g = 180.0F * slimeIn.rotationYaw / (float)Math.PI;
    }

    public void func_179920_a(float p_179920_1_, boolean p_179920_2_)
    {
        this.field_179922_g = p_179920_1_;
        this.field_179923_j = p_179920_2_;
    }

    public void setSpeed(double speedIn)
    {
        this.speed = speedIn;
        this.field_188491_h = EntityMoveHelper.Action.MOVE_TO;
    }

    public void onUpdateMoveHelper()
    {
        this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, this.field_179922_g, 90.0F);
        this.entity.rotationYawHead = this.entity.rotationYaw;
        this.entity.renderYawOffset = this.entity.rotationYaw;

        if (this.field_188491_h != EntityMoveHelper.Action.MOVE_TO)
        {
            this.entity.setMoveForward(0.0F);
        }
        else
        {
            this.field_188491_h = EntityMoveHelper.Action.WAIT;

            if (this.entity.onGround)
            {
                this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));

                if (this.field_179924_h-- <= 0)
                {
                    this.field_179924_h = this.slime.getJumpDelay();

                    if (this.field_179923_j)
                    {
                        this.field_179924_h /= 3;
                    }

                    this.slime.getJumpHelper().setJumping();

                    if (this.slime.makesSoundOnJump())
                    {
                        this.slime.playSound(this.slime.func_184710_cZ(), this.slime.getSoundVolume(), ((this.slime.getRNG().nextFloat() - this.slime.getRNG().nextFloat()) * 0.2F + 1.0F) * 0.8F);
                    }
                }
                else
                {
                    this.slime.moveStrafing = this.slime.moveForward = 0.0F;
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