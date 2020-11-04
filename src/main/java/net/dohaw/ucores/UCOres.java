package net.dohaw.ucores;

import net.dohaw.ucores.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = UCOres.MODID, name = UCOres.NAME, version = UCOres.VERSION, acceptedMinecraftVersions = UCOres.ACCEPTED_VERSIONS)
public class UCOres
{
    public static final String MODID = "ucores";
    public static final String NAME = "UC Ores";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";
    public static final String CLIENT_PROXY_CLASS = "net.dohaw.ucores.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "net.dohaw.ucores.proxy.CommonProxy";

    private static Logger logger;

    @Mod.Instance
    public static UCOres instance;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {

    }

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

}
