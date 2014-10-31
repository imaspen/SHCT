package uk.zebcoding.shct.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import uk.zebcoding.shct.common.items.ItemCTPick;
import uk.zebcoding.shct.common.items.ItemCTShovel;
import uk.zebcoding.shct.lib.Names;

/**
 * Created by Charlotte on 23/10/2014.
 */
public class SItems {
    public static final ItemPickaxe itemCTPick = new ItemCTPick();
    public static final ItemSpade itemCTShovel = new ItemCTShovel();

    public static void init() {
        GameRegistry.registerItem(itemCTPick, Names.Items.CT_PICK);
        GameRegistry.registerItem(itemCTShovel, Names.Items.CT_SHOVEL);
    }
}
