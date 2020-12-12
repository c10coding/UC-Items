package net.dohaw.ucitems.packets;

import net.minecraftforge.fml.common.network.FMLIndexedMessageToMessageCodec;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {

    private static int packetId = 0;
    public static SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("Testing");
    public PacketHandler(){}

    public static int nextID(){
        return packetId++;
    }

//    public static void registerMessages(String channelName){
//        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);
//    }

    public static void registerMessages(){
        INSTANCE.registerMessage(MyPacket.Handler.class, MyPacket.class, nextID(), Side.CLIENT);
        INSTANCE.registerMessage(MyPacket.Handler.class, MyPacket.class, nextID(), Side.SERVER);
    }

}
