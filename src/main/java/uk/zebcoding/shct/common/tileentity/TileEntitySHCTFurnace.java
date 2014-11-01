package uk.zebcoding.shct.common.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Charlotte on 01/11/2014.
 */
public class TileEntitySHCTFurnace extends TileEntity implements ISidedInventory {
    private static final int[] TOP_ACCESS = new int[]{0};
    private static final int[] SIDE_ACCESS = new int[]{0, 1};
    private static final int[] BOTTOM_ACCESS = new int[]{1};
    public int cookTime;
    private ItemStack[] slots = new ItemStack[2];

    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int scale)
    {
        return this.cookTime * scale / 200;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return side == 1 ? TOP_ACCESS : side == 0 ? BOTTOM_ACCESS : SIDE_ACCESS;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemStack, int side) {
        if (slot == 1) {
            return false;
        }

        int[] accessible = getAccessibleSlotsFromSide(side);
        for (int i : accessible) {
            if (accessible[i] == 0) {
                if (itemStack.isItemEqual(slots[0]) && itemStack.stackSize + slots[0].stackSize <= itemStack.getMaxStackSize()) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, int side) {
        if (slot == 0) {
            return false;
        }

        int[] accessible = getAccessibleSlotsFromSide(side);
        for (int i : accessible) {
            if (accessible[i] == 1) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int getSizeInventory() {
        return slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.slots[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        if (this.slots[slot] != null) {
            ItemStack itemstack;

            if (this.slots[slot].stackSize <= amount) {
                itemstack = this.slots[slot];
                this.slots[slot] = null;
                return itemstack;
            } else {
                itemstack = this.slots[slot].splitStack(amount);

                if (this.slots[slot].stackSize == 0) {
                    this.slots[slot] = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        this.slots[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return "container:ceramicFurnace";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
        return slot != 1 && FurnaceRecipes.smelting().getSmeltingResult(itemStack) != null;
    }
}
