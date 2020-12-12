package net.dohaw.ucitems.packets;

import io.netty.buffer.ByteBuf;
import net.dohaw.play.skills.PlayerData;
import net.dohaw.play.skills.SkillsAPI;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class RequestSkillCategoryOpenPacket implements IMessage {


    public RequestSkillCategoryOpenPacket(){
    }

    /**
     * Convert from the supplied buffer into your specific message type
     *
     * @param buf
     */
    @Override
    public void fromBytes(ByteBuf buf) { }

    /**
     * Deconstruct your message into the supplied byte buffer
     *
     * @param buf
     */
    @Override
    public void toBytes(ByteBuf buf) { }

    public static class Handler implements IMessageHandler<RequestSkillCategoryOpenPacket, IMessage> {

        /**
         * Called when a message is received of the appropriate type. You can optionally return a reply message, or null if no reply
         * is needed.
         *
         * @param message The message
         * @param ctx
         * @return an optional return message
         */
        @Override
        public IMessage onMessage(RequestSkillCategoryOpenPacket message, MessageContext ctx) {
            if(ctx.side == Side.SERVER){
                final EntityPlayerMP player = ctx.getServerHandler().player;
                player.getServer().addScheduledTask(new Runnable() {
                    @Override
                    public void run() {
                        handle(message, ctx);
                    }
                });
            }
            return null;
        }

        private void handle(RequestSkillCategoryOpenPacket message, MessageContext ctx) {
            Side side = ctx.side;
            if(side == Side.SERVER){
                PlayerData pd = SkillsAPI.getPlayerData(ctx.getServerHandler().player.getUniqueID());
                PacketHandler.INSTANCE.sendTo(new RequestSkillCategoryOpenPacket(), ctx.getServerHandler().player);
            }
        }

    }

}

