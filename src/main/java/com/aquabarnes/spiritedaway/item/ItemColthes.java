package com.aquabarnes.spiritedaway.item;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemColthes extends ItemArmor {
	
public static final String COLTHES_PATH = "sa:/textures/models/armor/";
protected String armorTex;
@SideOnly(Side.CLIENT)
protected ModelBiped armorModel;

public ItemColthes(int unused, ItemArmor.ArmorMaterial armorMaterial, int renderIndex, EntityEquipmentSlot armorType)
{
  this(unused, armorMaterial, renderIndex, armorType, "");
}

public ItemColthes(int unused, ItemArmor.ArmorMaterial armorMaterial, int renderIndex, EntityEquipmentSlot armorType, String armorTex)
{
  super(armorMaterial, renderIndex, armorType);
  this.armorTex = armorTex;
}

@SideOnly(Side.CLIENT)
public void setModel(ModelBiped model)
{
  this.armorModel = model;
}

@SideOnly(Side.CLIENT)
public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
{
  if (this.armorModel != null)
  {
    this.armorModel.field_78116_c.field_78806_j = (armorSlot == 0);
    this.armorModel.field_78114_d.field_78806_j = (armorSlot == 0);
    this.armorModel.field_78115_e.field_78806_j = ((armorSlot == 1) || (armorSlot == 2));
    this.armorModel.field_78112_f.field_78806_j = (armorSlot == 1);
    this.armorModel.field_78113_g.field_78806_j = (armorSlot == 1);
    this.armorModel.field_78123_h.field_78806_j = ((armorSlot == 2) || (armorSlot == 3));
    this.armorModel.field_78124_i.field_78806_j = ((armorSlot == 2) || (armorSlot == 3));
    
    this.armorModel.field_78117_n = entityLiving.func_70093_af();
    this.armorModel.field_78093_q = entityLiving.func_70115_ae();
    this.armorModel.field_78091_s = entityLiving.func_70631_g_();
    this.armorModel.field_78120_m = (entityLiving.func_71124_b(0) != null ? 1 : 0);
    if ((entityLiving instanceof EntityPlayer)) {
      this.armorModel.field_78118_o = (((EntityPlayer)entityLiving).func_71057_bx() > 2);
    }
  }
  return this.armorModel;
}

@SideOnly(Side.CLIENT)
public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
{
  return "sa:textures/models/armor/" + this.armorTex;
}
}
