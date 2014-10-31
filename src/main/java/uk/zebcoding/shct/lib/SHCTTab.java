package uk.zebcoding.shct.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by Charlotte on 23/10/2014.
 */
public class SHCTTab {
    public static final CreativeTabs SHCT_TAB = new CreativeTabs(ModVals.MOD_ID) {
        @Override
        public Item getTabIconItem() {
            return Items.golden_pickaxe;
        }
    };
}
