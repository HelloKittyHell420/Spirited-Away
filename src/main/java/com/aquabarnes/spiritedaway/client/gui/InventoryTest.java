package com.aquabarnes.spiritedaway.client.gui;

import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.world.ILockableContainer;

public class InventoryTest extends InventoryBasic {

	private final ItemStack stack;
	
	public InventoryTest(ItemStack stack) {
		super("container.test", false, 27);
		this.stack = stack;

	}


}
