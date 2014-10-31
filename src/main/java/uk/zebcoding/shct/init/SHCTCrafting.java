package uk.zebcoding.shct.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Charlotte on 23/10/2014.
 */
public class SHCTCrafting {
    public static void init() {
        ItemStack clayStack = new ItemStack(Items.clay_ball);

        GameRegistry.addShapelessRecipe(new ItemStack(SHCTItems.itemSHCTSludge), clayStack, clayStack, new ItemStack(Items.blaze_powder));

        GameRegistry.addSmelting(SHCTItems.itemSHCTSludge, new ItemStack(SHCTItems.itemSHCTIngot), 1.0F);

        GameRegistry.addShapedRecipe(new ItemStack(SHCTItems.itemSHCTPick), "CCC", " B ", " B ", 'C', SHCTItems.itemSHCTIngot, 'B', Items.blaze_rod);

        GameRegistry.addShapedRecipe(new ItemStack(SHCTItems.itemSHCTShovel), "C", "B", "B", 'C', SHCTItems.itemSHCTIngot, 'B', Items.blaze_rod);
    }
}
