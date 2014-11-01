package uk.zebcoding.shct;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraftforge.common.MinecraftForge;
import uk.zebcoding.shct.init.SHCTBlocks;
import uk.zebcoding.shct.init.SHCTCrafting;
import uk.zebcoding.shct.init.SHCTItems;
import uk.zebcoding.shct.init.SHCTTileEntities;
import uk.zebcoding.shct.lib.ModVals;
import uk.zebcoding.shct.lib.SHCTEvents;
import uk.zebcoding.shct.common.CommonProxy;

@Mod(modid = ModVals.MOD_ID, version = ModVals.MOD_VER, name = ModVals.MOD_NAME)
public class SuperHeatedCeramicTools {
    @Mod.Instance(ModVals.MOD_ID)
    public static SuperHeatedCeramicTools instance;

    @SidedProxy(clientSide = "uk.zebcoding.shct.client.ClientProxy", serverSide = "uk.zebcoding.shct.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        SHCTItems.init();
        //SHCTBlocks.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //SHCTTileEntities.init();
        //NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
        proxy.initRendering();
        MinecraftForge.EVENT_BUS.register(new SHCTEvents());
        FMLCommonHandler.instance().bus().register(new SHCTEvents());
        SHCTCrafting.init();
    }
}