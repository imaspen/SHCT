package uk.zebcoding.shct.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import uk.zebcoding.shct.common.items.*;
import uk.zebcoding.shct.lib.Names;

/**
 * Created by Charlotte on 23/10/2014.
 */
public class SHCTItems {
    public static final ItemPickaxe itemSHCTPick = new ItemSHCTPick();
    public static final ItemSpade itemSHCTShovel = new ItemSHCTShovel();
    public static final ItemSHCT itemSHCTSludge = new ItemSHCTSludge();
    public static final ItemSHCT itemSHCTIngot = new ItemSHCTIngot();

    public static void init() {
        GameRegistry.registerItem(itemSHCTPick, Names.Items.CT_PICK);
        GameRegistry.registerItem(itemSHCTShovel, Names.Items.CT_SHOVEL);
        GameRegistry.registerItem(itemSHCTSludge, Names.Items.CT_SLUDGE);
        GameRegistry.registerItem(itemSHCTIngot, Names.Items.CT_INGOT);
    }
}
