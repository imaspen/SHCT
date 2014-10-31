package uk.zebcoding.shct.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import uk.zebcoding.shct.lib.*;

/**
 * Created by Charlotte on 23/10/2014.
 */
public class ItemCTPick extends ItemPickaxe {
    @SideOnly(Side.CLIENT)
    private IIcon cool;
    @SideOnly(Side.CLIENT)
    private IIcon heated;

    public ItemCTPick() {
        super(SHCTMaterials.TOOL_MATERIAL_CT);
        this.setCreativeTab(SHCTTab.SHCT_TAB);
        this.setUnlocalizedName(Names.Items.CT_PICK);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return "item." + (itemStack.getItemDamage() == 0 ? Names.Items.CT_PICK : Names.Items.SH_PICK);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        cool = iconRegister.registerIcon(ModVals.MOD_ID + ":" + Names.Items.CT_PICK);
        heated = iconRegister.registerIcon(ModVals.MOD_ID + ":" + Names.Items.SH_PICK);
    }

    @Override
    public IIcon getIconFromDamage(int damage) {
        return damage == 0 ? cool : heated;
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int meta, boolean par5) {
        itemStack = SHCTHelper.removeEnchants(itemStack);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        return SHCTHelper.superHeat(itemStack, player);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase livingBase) {
        SHCTHelper.damageSuperHeated(itemStack);
        return true;
    }
}
