package net.dohaw.ucitems.packets;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MyPacket implements IMessage {

    private String data;

    public MyPacket() {
        data = "TESTING";
    }

    public MyPacket(String data){
        this.data = data;
    }

    /**
     * Convert from the supplied buffer into your specific message type
     *
     * @param buf
     */
    @Override
    public void fromBytes(ByteBuf buf) {
        data = ByteBufUtils.readUTF8String(buf);
    }

    /**
     * Deconstruct your message into the supplied byte buffer
     *
     * @param buf
     */
    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, data);
    }

    public static class Handler implements IMessageHandler<MyPacket, IMessage> {

        /**
         * Called when a message is received of the appropriate type. You can optionally return a reply message, or null if no reply
         * is needed.
         *
         * @param message The message
         * @param ctx
         * @return an optional return message
         */
        @Override
        public IMessage onMessage(MyPacket message, MessageContext ctx) {
            if(ctx.side != Side.CLIENT){
                System.out.println("WRONG SIDE!");
                return null;
            }
            final EntityPlayerMP player = ctx.getServerHandler().player;
            Minecraft.getMinecraft().addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    handle(message, ctx, player);
                }
            });
            return null;
        }

        private void handle(MyPacket message, MessageContext ctx, EntityPlayerMP player) {
            // This code is run on the server side. So you can do server-side calculations here
            EntityPlayerMP playerEntity = ctx.getServerHandler().player;
            System.out.println("GOT STRING FROM CLIENT: " + message.data);
        }
    }

}

