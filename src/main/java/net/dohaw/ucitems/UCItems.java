package net.dohaw.ucitems;

import net.dohaw.ucitems.init.ModPotions;
import net.dohaw.ucitems.init.ModRecipes;
import net.dohaw.ucitems.packets.PacketHandler;
import net.dohaw.ucitems.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.apache.logging.log4j.Logger;

@Mod(modid = UCItems.MODID, name = UCItems.NAME, version = UCItems.VERSION, acceptedMinecraftVersions = UCItems.ACCEPTED_VERSIONS)
public class UCItems
{

    public static final String networkChannelName = "GUIInfo";
    public static FMLEventChannel channel;

    public static final String MODID = "ucitems";
    public static final String NAME = "UC Items";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";
    public static final String CLIENT_PROXY_CLASS = "net.dohaw.ucitems.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "net.dohaw.ucitems.proxy.CommonProxy";

    private static Logger logger;

    @Mod.Instance
    public static UCItems instance;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        PacketHandler.registerMessages();
        ModPotions.registerPotions();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event){
        ModRecipes.init();
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        //event.registerServerCommand(new MyCommand());
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {
    }

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

}
