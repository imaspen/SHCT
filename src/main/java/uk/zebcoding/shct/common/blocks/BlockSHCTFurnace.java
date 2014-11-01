package uk.zebcoding.shct.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import uk.zebcoding.shct.SuperHeatedCeramicTools;
import uk.zebcoding.shct.common.tileentity.TileEntitySHCTFurnace;
import uk.zebcoding.shct.init.SHCTBlocks;
import uk.zebcoding.shct.lib.GUI;
import uk.zebcoding.shct.lib.ModVals;
import uk.zebcoding.shct.lib.Names;

import java.util.Random;

/**
 * Created by Charlotte on 01/11/2014.
 */
public class BlockSHCTFurnace extends BlockSHCT {
    private final boolean active;
    @SideOnly(Side.CLIENT)
    private IIcon frontIcon;
    @SideOnly(Side.CLIENT)
    private IIcon sideIcon;

    public BlockSHCTFurnace(boolean active) {
        super(Names.Blocks.CT_FURNACE);
        this.active = active;
    }

    @Override
    public Item getItemDropped(int par1, Random par2, int par3) {
        return Item.getItemFromBlock(SHCTBlocks.ceramicFurnace);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        frontIcon = iconRegister.registerIcon(ModVals.MOD_ID + ":" + Names.Blocks.CT_FURNACE + "Front");
        sideIcon = iconRegister.registerIcon(ModVals.MOD_ID + ":" + Names.Blocks.CT_FURNACE + "Side");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return meta == 0 ? side == 3 ? frontIcon : sideIcon : side == meta ? frontIcon : sideIcon;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase livingBase, ItemStack itemStack) {
        if (!world.isRemote) {
            int rotation = (int) livingBase.rotationYaw;
            if (rotation < 0) {
                rotation += 360;
            }

            System.out.println(rotation);

            byte side = 3;
            if (rotation >= 0 && rotation < 45)
                side = 2;
            else if (rotation >= 45 && rotation < 135)
                side = 5;
            else if (rotation >= 135 && rotation < 215)
                side = 3;
            else if (rotation >= 215 && rotation < 305)
                side = 4;
            else if (rotation >= 305 && rotation <= 360) {
                side = 2;
            }
            world.setBlockMetadataWithNotify(x, y, z, side, 2);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(SHCTBlocks.ceramicFurnace);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntitySHCTFurnace();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9) {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            TileEntitySHCTFurnace ceramicFurnace = (TileEntitySHCTFurnace)world.getTileEntity(x, y, z);

            if (ceramicFurnace != null)
            {
                entityPlayer.openGui(SuperHeatedCeramicTools.instance, GUI.CERAMIC_FURNACE.ordinal(), world, x, y, z);
            }

            return true;
        }
    }
}
