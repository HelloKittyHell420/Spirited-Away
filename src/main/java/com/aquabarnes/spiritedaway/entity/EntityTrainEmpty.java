package com.aquabarnes.spiritedaway.entity;

import com.aquabarnes.spiritedaway.enums.TrainType;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EntityTrainEmpty extends EntityTrain {

    public EntityTrainEmpty(World worldIn, double x, double y, double z)
    {
        super(worldIn);
    }

    public boolean processInitialInteract(EntityPlayer player, ItemStack stack, EnumHand hand)
    {
        //if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.entity.minecart.MinecartInteractEvent(this, player, stack, hand))) return true;

        if (player.isSneaking())
        {
            return false;
        }
        else if (this.isBeingRidden())
        {
            return true;
        }
        else
        {
            if (!this.worldObj.isRemote)
            {
                player.startRiding(this);
            }

            return true;
        }
    }

    public TrainType getType()
    {
        return TrainType.RIDEABLE;
    }
}