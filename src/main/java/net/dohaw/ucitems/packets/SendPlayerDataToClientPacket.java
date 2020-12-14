package net.dohaw.ucitems.packets;

import io.netty.buffer.ByteBuf;
import net.dohaw.ucitems.UCItems;
import net.dohaw.ucitems.gui.SkillsMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SendPlayerDataToClientPacket implements IMessage {

    private NBTTagCompound data;

    public SendPlayerDataToClientPacket() {
        this.data = null;
    }

    public SendPlayerDataToClientPacket(NBTTagCompound data){
        this.data = data;
    }

    /**
     * Convert from the supplied buffer into your specific message type
     *
     * @param buf
     */
    @Override
    public void fromBytes(ByteBuf buf) {
        NBTTagCompound wrapper = ByteBufUtils.readTag(buf);
        this.data = wrapper;
    }

    /**
     * Deconstruct your message into the supplied byte buffer
     *
     * @param buf
     */
    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, data);
    }

    public static class Handler implements IMessageHandler<SendPlayerDataToClientPacket, IMessage> {
        /**
         * Called when a message is received of the appropriate type. You can optionally return a reply message, or null if no reply
         * is needed.
         *
         * @param message The message
         * @param ctx
         * @return an optional return message
         */
        @Override
        public IMessage onMessage(SendPlayerDataToClientPacket message, MessageContext ctx) {
            if(ctx.side == Side.CLIENT){
                NBTTagCompound data = message.data;
                openGui(data);
            }
            return null;
        }

        @SideOnly(value = Side.CLIENT)
        private void openGui(NBTTagCompound data){
            Minecraft.getMinecraft().displayGuiScreen(new SkillsMenu(data));
        }

    }

}
