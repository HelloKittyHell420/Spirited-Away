package com.aquabarnes.spiritedaway.entity;

import com.aquabarnes.spiritedaway.init.SASoundEvents;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFindEntityNearest;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ItemStackHolderInjector;

public class EntitySootball extends EntityMob {

    public EntitySootball(World worldIn)
    {
        super(worldIn);
        this.setSize(0.5F, 0.5F);
    }

    protected void initEntityAI()
    {
        //this.tasks.addTask(1, new EntityAISlimeFloat(this));
        //this.tasks.addTask(2, new EntitySlime.AISlimeAttack(this));
        //this.tasks.addTask(3, new EntitySlime.AISlimeFaceRandom(this));
        //this.tasks.addTask(5, new EntitySlime.AISlimeHop(this));
        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
        this.targetTasks.addTask(3, new EntityAIFindEntityNearest(this, EntityIronGolem.class));
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
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

    protected SoundEvent getAmbientSound()
    {
        return SASoundEvents.entity_sootball_ambient;
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

    
	@Override
	protected boolean processInteract(EntityPlayer entity, EnumHand hand, ItemStack stack){
		super.processInteract(entity,hand,stack);
		int i = (int)this.posX;
		int j = (int)this.posY;
		int k = (int)this.posZ;
		
if(true){
	
}
return dead;
}
    protected void dropRareDrop(int par1){
    this.dropItem(Items.COOKED_PORKCHOP, 1);
    }
    
    
  }
