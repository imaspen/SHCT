package uk.zebcoding.shct.common;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import uk.zebcoding.shct.common.container.ContainerSHCTFurnace;
import uk.zebcoding.shct.common.tileentity.TileEntitySHCTFurnace;
import uk.zebcoding.shct.lib.GUI;

/**
 * Created by Charlotte on 29/10/2014.
 */
public class CommonProxy implements IGuiHandler {
    public void initRendering() {

    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity != null) {
            if (ID == GUI.CERAMIC_FURNACE.ordinal()) {
                return new ContainerSHCTFurnace(player.inventory, (TileEntitySHCTFurnace) tileEntity);
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }
}
