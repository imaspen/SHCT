package uk.zebcoding.shct.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import uk.zebcoding.shct.client.gui.GuiSHCTFurnace;
import uk.zebcoding.shct.client.renderers.ToolRenderer;
import uk.zebcoding.shct.common.CommonProxy;
import uk.zebcoding.shct.common.container.ContainerSHCTFurnace;
import uk.zebcoding.shct.common.tileentity.TileEntitySHCTFurnace;
import uk.zebcoding.shct.init.SHCTItems;
import uk.zebcoding.shct.lib.GUI;

/**
 * Created by Charlotte on 29/10/2014.
 */
public class ClientProxy extends CommonProxy {
    public void initRendering() {
        MinecraftForgeClient.registerItemRenderer(SHCTItems.itemSHCTPick, new ToolRenderer());
        MinecraftForgeClient.registerItemRenderer(SHCTItems.itemSHCTShovel, new ToolRenderer());
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity != null) {
            if (ID == GUI.CERAMIC_FURNACE.ordinal()) {
                return new GuiSHCTFurnace(player.inventory, (TileEntitySHCTFurnace) tileEntity);
            }
        }
        return null;
    }
}
