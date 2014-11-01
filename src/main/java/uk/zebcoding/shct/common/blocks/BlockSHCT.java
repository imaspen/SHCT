package uk.zebcoding.shct.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import uk.zebcoding.shct.lib.SHCTTab;

/**
 * Created by Charlotte on 01/11/2014.
 */
public class BlockSHCT extends BlockContainer {
    public BlockSHCT(String name) {
        this(Material.rock, name);
    }

    public BlockSHCT(Material material, String name) {
        super(material);
        setCreativeTab(SHCTTab.SHCT_TAB);
        setBlockName(name);
        setBlockTextureName(name);
        setHardness(3.0F);
        setResistance(10.0F);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return null;
    }
}
