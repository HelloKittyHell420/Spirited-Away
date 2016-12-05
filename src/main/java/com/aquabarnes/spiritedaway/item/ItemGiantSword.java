package com.aquabarnes.spiritedaway.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGiantSword {

	  private GiantItemIcon giantIcon;
	  
	  public ItemGiantSword(Item.ToolMaterial par2EnumToolMaterial)
	  {
	    super();
	    func_77637_a(TFItems.creativeTab);
	  }
	  
	  public boolean func_82789_a(ItemStack par1ItemStack, ItemStack par2ItemStack)
	  {
	    return par2ItemStack.func_77973_b() == TFItems.ironwoodIngot ? true : super.func_82789_a(par1ItemStack, par2ItemStack);
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public void func_94581_a(IIconRegister par1IconRegister)
	  {
	    this.field_77791_bV = Items.field_151052_q.func_77617_a(0);
	    this.giantIcon = new GiantItemIcon(this.field_77791_bV, 0.1875F, 0.3125F);
	  }
	  
	  public IIcon getIcon(ItemStack stack, int pass)
	  {
	    if (pass == -1) {
	      return this.giantIcon;
	    }
	    return super.getIcon(stack, pass);
	  }
	}

