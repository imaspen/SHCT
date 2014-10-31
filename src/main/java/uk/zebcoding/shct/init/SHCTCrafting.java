package uk.zebcoding.shct.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Charlotte on 23/10/2014.
 */
public class SHCTCrafting {
    public static void init() {
        GameRegistry.addShapedRecipe(new ItemStack(SItems.itemCTPick), "CCC", " B ", " B ", 'C', Items.clay_ball, 'B',
                Items.blaze_rod);

        GameRegistry.addShapedRecipe(new ItemStack(SItems.itemCTShovel), "C", "B", "B", 'C', Items.clay_ball, 'B',
                Items.blaze_rod);
    }
}
