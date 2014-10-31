package uk.zebcoding.shct.lib;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * Created by Charlotte on 29/10/2014.
 */
public class SHCTHelper {
    public static ItemStack removeEnchants(ItemStack itemStack) {
        NBTTagList enchants = itemStack.getEnchantmentTagList();

        if (enchants != null) {
            for (int i = 0; i < enchants.tagCount(); i++) {
                if (enchants.getCompoundTagAt(i).getShort("id") == 33) {
                    enchants.removeTag(i);
                    break;
                }
            }
            if (enchants.tagCount() > 0) {
                itemStack.stackTagCompound.setTag("ench", enchants);
            }
        }


        return itemStack;
    }

    public static ItemStack superHeat(ItemStack itemStack, EntityPlayer player) {
        if (player.isSneaking()) {
            ItemStack currentItem;
            String name = itemStack.getUnlocalizedName().substring(5);
            if (name.equals(Names.Items.CT_PICK) || name.equals(Names.Items.CT_SHOVEL)) {
                for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
                    currentItem = player.inventory.getStackInSlot(i);
                    if (currentItem != null && currentItem.getItem() == Items.blaze_powder) {
                        player.inventory.decrStackSize(i, 1);
                        itemStack.setItemDamage(1);
                        if (itemStack.stackTagCompound == null) {
                            itemStack.stackTagCompound = new NBTTagCompound();
                        }
                        itemStack.stackTagCompound.setByte(Names.NBT.DAMAGE, (byte) 32);
                    }
                }
            }
        }

        return itemStack;
    }

    public static ItemStack damageSuperHeated(ItemStack itemStack) {
        if (itemStack.getItemDamage() == 1) {
            itemStack.stackTagCompound.setByte(Names.NBT.DAMAGE, (byte) (itemStack.stackTagCompound.getByte(Names.NBT.DAMAGE) - 1));
            if (itemStack.stackTagCompound.getByte(Names.NBT.DAMAGE) <= 0) {
                itemStack.setItemDamage(0);
            }
        }

        return itemStack;
    }
}
