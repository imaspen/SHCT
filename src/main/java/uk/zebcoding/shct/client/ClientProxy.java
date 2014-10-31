package uk.zebcoding.shct.client;

import net.minecraftforge.client.MinecraftForgeClient;
import uk.zebcoding.shct.client.renderers.ToolRenderer;
import uk.zebcoding.shct.common.CommonProxy;
import uk.zebcoding.shct.init.SHCTItems;

/**
 * Created by Charlotte on 29/10/2014.
 */
public class ClientProxy extends CommonProxy {
    public void initRendering() {
        MinecraftForgeClient.registerItemRenderer(SHCTItems.itemSHCTPick, new ToolRenderer());
        MinecraftForgeClient.registerItemRenderer(SHCTItems.itemSHCTShovel, new ToolRenderer());
    }
}
