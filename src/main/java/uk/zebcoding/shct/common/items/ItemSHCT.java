package uk.zebcoding.shct.common.items;

import net.minecraft.item.Item;
import uk.zebcoding.shct.lib.ModVals;
import uk.zebcoding.shct.lib.SHCTTab;

/**
 * Created by Charlotte on 31/10/2014.
 */
public class ItemSHCT extends Item {
    public ItemSHCT(String name) {
        this(64, name);
    }
    public ItemSHCT(int stackSize, String name) {
        super();
        setUnlocalizedName(name);
        setMaxStackSize(stackSize);
        setNoRepair();
        setCreativeTab(SHCTTab.SHCT_TAB);
        setTextureName(ModVals.MOD_ID + ":" + name);
    }
}
