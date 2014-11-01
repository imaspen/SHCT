package uk.zebcoding.shct.init;

import cpw.mods.fml.common.registry.GameRegistry;
import uk.zebcoding.shct.common.blocks.BlockSHCT;
import uk.zebcoding.shct.common.blocks.BlockSHCTFurnace;
import uk.zebcoding.shct.lib.Names;

/**
 * Created by Charlotte on 01/11/2014.
 */
public class SHCTBlocks {
    public static final BlockSHCT ceramicFurnace = new BlockSHCTFurnace(false);
    public static final BlockSHCT heatedCeramicFurnace = new BlockSHCTFurnace(true);

    public static void init() {
        GameRegistry.registerBlock(ceramicFurnace, Names.Blocks.CT_FURNACE);
        GameRegistry.registerBlock(heatedCeramicFurnace, Names.Blocks.SH_FURNACE);
    }
}
