package uk.zebcoding.shct.common.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import uk.zebcoding.shct.common.tileentity.TileEntitySHCTFurnace;

/**
 * Created by Charlotte on 01/11/2014.
 */
public class ContainerSHCTFurnace extends Container {
    private TileEntitySHCTFurnace ceramicFurnace;
    private int lastCookTime;

    public ContainerSHCTFurnace(InventoryPlayer inventoryPlayer, TileEntitySHCTFurnace tileEntitySHCTFurnace) {
        this.ceramicFurnace = tileEntitySHCTFurnace;
        this.addSlotToContainer(new Slot(tileEntitySHCTFurnace, 0, 56, 17));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tileEntitySHCTFurnace, 1, 116, 35));

        int i;

        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    @Override
    public void addCraftingToCrafters(ICrafting iCrafting) {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.ceramicFurnace.cookTime);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            if (this.lastCookTime != this.ceramicFurnace.cookTime) {
                icrafting.sendProgressBarUpdate(this, 0, this.ceramicFurnace.cookTime);
            }
        }

        this.lastCookTime = this.ceramicFurnace.cookTime;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int par1, int par2) {
        if (par1 == 0) {
            this.ceramicFurnace.cookTime = par2;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.ceramicFurnace.isUseableByPlayer(entityPlayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slot) {
        return null;
    }
}
