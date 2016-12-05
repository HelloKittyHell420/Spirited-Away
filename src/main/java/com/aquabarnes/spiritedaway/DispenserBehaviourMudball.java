package com.aquabarnes.spiritedaway;

import com.aquabarnes.spiritedaway.entity.EntityMudball;

import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DispenserBehaviourMudball extends BehaviorProjectileDispense {
	
protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stack) {
{
  return new EntityMudball(worldIn, position.getX(), position.getY(), position.getZ());
}

}
}
