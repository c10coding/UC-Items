package net.dohaw.ucitems;

import net.dohaw.ucitems.commands.MyCommand;
import net.dohaw.ucitems.init.ModRecipes;
import net.dohaw.ucitems.listeners.PlayerWatcher;
import net.dohaw.ucitems.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = UCItems.MODID, name = UCItems.NAME, version = UCItems.VERSION, acceptedMinecraftVersions = UCItems.ACCEPTED_VERSIONS)
public class UCItems
{
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
    }

    @EventHandler
    public static void init(FMLInitializationEvent event){
        ModRecipes.init();
        MinecraftForge.EVENT_BUS.register(new PlayerWatcher());
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
