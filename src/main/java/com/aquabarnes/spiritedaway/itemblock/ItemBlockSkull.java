package com.aquabarnes.spiritedaway.itemblock;

import java.util.List;



import java.util.UUID;

import com.aquabarnes.spiritedaway.init.SACreativeTabs;
import com.aquabarnes.spiritedaway.init.SAItemBlocks;
import com.aquabarnes.spiritedaway.tileenitity.TileEntitySkull;
import com.mojang.authlib.GameProfile;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockSkull extends ItemBlock
{
    private static final String[] skullTypes = new String[] {"chihiro", "frogman", "haku", "kashira", "ootori", "radish", "sootball", "haku_dragon"};

    public ItemBlockSkull(Block block)
    {
    	super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (facing == EnumFacing.DOWN)
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            if (worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos))
            {
                facing = EnumFacing.UP;
                pos = pos.down();
            }
            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();
            boolean flag = block.isReplaceable(worldIn, pos);

            if (!flag)
            {
                if (!worldIn.getBlockState(pos).getMaterial().isSolid() && !worldIn.isSideSolid(pos, facing, true))
                {
                    return EnumActionResult.FAIL;
                }

                pos = pos.offset(facing);
            }

            if (playerIn.canPlayerEdit(pos, facing, stack) && SAItemBlocks.SKULL.canPlaceBlockAt(worldIn, pos))
            {
                if (worldIn.isRemote)
                {
                    return EnumActionResult.SUCCESS;
                }
                else
                {
                    worldIn.setBlockState(pos, SAItemBlocks.SKULL.getDefaultState().withProperty(BlockSkull.FACING, facing), 11);
                    int i = 0;

                    if (facing == EnumFacing.UP)
                    {
                        i = MathHelper.floor_double((double)(playerIn.rotationYaw * 16.0F / 360.0F) + 0.5D) & 15;
                    }

                    TileEntity tileentity = worldIn.getTileEntity(pos);

                    if (tileentity instanceof TileEntitySkull)
                    {
                        TileEntitySkull tileentityskull = (TileEntitySkull)tileentity;

                        if (stack.getMetadata() == 3)
                        {
                            GameProfile gameprofile = null;

                            if (stack.hasTagCompound())
                            {
                                NBTTagCompound nbttagcompound = stack.getTagCompound();

                                if (nbttagcompound.hasKey("SkullOwner", 10))
                                {
                                    gameprofile = NBTUtil.readGameProfileFromNBT(nbttagcompound.getCompoundTag("SkullOwner"));
                                }
                                else if (nbttagcompound.hasKey("SkullOwner", 8) && !nbttagcompound.getString("SkullOwner").isEmpty())
                                {
                                    gameprofile = new GameProfile((UUID)null, nbttagcompound.getString("SkullOwner"));
                                }
                            }
                        }
                        else
                        {
                            tileentityskull.setType(stack.getMetadata());
                        }

                        tileentityskull.setSkullRotation(i);
                    }

                    --stack.stackSize;
                    return EnumActionResult.SUCCESS;
                }
            }
            else
            {
                return EnumActionResult.FAIL;
            }
        }
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (int i = 0; i < skullTypes.length; ++i)
        {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }

    /**
     * Converts the given ItemStack damage value into a metadata value to be placed in the world when this Item is
     * placed as a Block (mostly used with ItemBlocks).
     */
    public int getMetadata(int damage)
    {
        return damage;
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack stack)
    {
        int i = stack.getMetadata();

        if (i < 0 || i >= skullTypes.length)
        {
            i = 0;
        }

        return super.getUnlocalizedName() + "." + skullTypes[i];
    }

}
