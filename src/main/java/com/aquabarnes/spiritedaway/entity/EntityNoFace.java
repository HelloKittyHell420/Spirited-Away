package com.aquabarnes.spiritedaway.entity;

import java.util.Random;

import java.util.Set;

import com.aquabarnes.spiritedaway.enums.EnumColor;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentScore;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityNoFace extends EntityMob {
	
	private static final Set<Item> NoFaceTemptsItems = Sets.newHashSet(new Item[] {Items.gold_ingot, Items.gold_nugget, Items.golden_apple, Items.golden_carrot});
	private static final Set<Item> NoFaceTemptsWeapons = Sets.newHashSet(new Item[] {Items.golden_sword, Items.golden_pickaxe, Items.golden_axe, Items.golden_shovel, Items.golden_hoe});
	private static final Set<Block> NoFaceTemptsBlocks = Sets.newHashSet(new Block[] {Blocks.gold_block, Blocks.gold_ore});
	
    public EntityNoFace(World worldIn)
    {
        super(worldIn);
        this.setSize(0.6F, 2.9F);
        this.setPathPriority(PathNodeType.WATER, -1.0F);

    }

    protected void initEntityAI()
    {
    	//TODO: Feed him any Golden Item/Block to make him grow. He is going to have about 4 stages and last stage he will turn hostile and have a boss bar 
    	//TODO: Tempts Done but need a chat output when following player. Ah Ah Ah!
    	//TODO: Teleport/Despawns Randomly if Player hits him.
    	//TODO: Scared of something?? dont know what yet.
    	
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 2.0D, false, NoFaceTemptsItems));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
                  
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.20000000298023224D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(0.20000000298023224D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.20000000298023224D);
    }
    
	protected boolean teleportRandomly()
    {
        double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
        double d1 = this.posY + (double)(this.rand.nextInt(64) - 32);
        double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
        return this.teleportTo_(d0, d1, d2);
    }
    
    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
    
    }
    
    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);
      
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
    
    protected boolean canDespawn()
    {
        return false;
    }
    
    public boolean processInteract(EntityPlayer player, EnumHand p_184645_2_, ItemStack stack)
    {
    	if (!this.worldObj.isRemote)
    		
    	{
    	
        Random rand = new Random();
        int sel = rand.nextInt(3);
        switch (sel)
             
        {    
        case 1: 
            player.addChatComponentMessage(new TextComponentString("§7Ah Ah Ah!")); 	    

    	}
    	}
		return dead;
    }
    
	public String entityName()
    {
      return "No-Face";
    }
    
    @Override
    public boolean isNonBoss(){return false;}
    private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfoServer.Color.WHITE, BossInfoServer.Overlay.NOTCHED_6));
    @Override
    public void setBossVisibleTo(EntityPlayerMP player){super.setBossVisibleTo(player);this.bossInfo.addPlayer(player);}
    @Override
    public void setBossNonVisibleTo(EntityPlayerMP player){super.setBossNonVisibleTo(player);this.bossInfo.removePlayer(player);}
    @Override
    public void onUpdate(){super.onUpdate();this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }
	}


