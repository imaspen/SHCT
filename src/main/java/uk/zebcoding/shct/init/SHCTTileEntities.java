package uk.zebcoding.shct.init;

import cpw.mods.fml.common.registry.GameRegistry;
import uk.zebcoding.shct.common.tileentity.TileEntitySHCTFurnace;
import uk.zebcoding.shct.lib.Names;

/**
 * Created by Charlotte on 01/11/2014.
 */
public class SHCTTileEntities {
    public static void init() {
        GameRegistry.registerTileEntity(TileEntitySHCTFurnace.class, Names.Blocks.CT_FURNACE);
    }
}
