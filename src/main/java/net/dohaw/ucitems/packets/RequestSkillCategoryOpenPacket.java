package net.dohaw.ucitems.packets;

import io.netty.buffer.ByteBuf;
import net.dohaw.play.skills.PlayerData;
import net.dohaw.play.skills.SkillsAPI;
import net.dohaw.play.skills.skills.SkillData;
import net.dohaw.play.skills.skills.SkillType;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

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
            final EntityPlayerMP player = ctx.getServerHandler().player;
            Side side = ctx.side;
            if (side == Side.SERVER) {
                EntityPlayerMP pmp = ctx.getServerHandler().player;
                UUID uuid = pmp.getUniqueID();
                PlayerData pd = SkillsAPI.getPlayerData(uuid);

                NBTTagCompound wrapper = new NBTTagCompound();
                NBTTagCompound skillsData = new NBTTagCompound();
                //NBTTagCompound attributeData = new NBTTagCompound();

                EnumMap<SkillType, SkillData> skills = pd.getSkills();
                for (Map.Entry<SkillType, SkillData> entry : skills.entrySet()) {

                    SkillType type = entry.getKey();
                    SkillData sd = entry.getValue();
                    double level = sd.getLevel();
                    double timeSpent = sd.getTimeSpent();

                    NBTTagCompound skill = new NBTTagCompound();
                    skill.setDouble("Time Spent", timeSpent);
                    skill.setDouble("Level", level);
                    skillsData.setTag(type.toString(), skill);

                }
                wrapper.setTag("Skills", skillsData);
                return new SendPlayerDataToClientPacket(wrapper);
            }
            return null;
        }

//        private void handle(RequestSkillCategoryOpenPacket message, MessageContext ctx) {
//            Side side = ctx.side;
//            if(side == Side.SERVER){
//                EntityPlayerMP pmp = ctx.getServerHandler().player;
//                UUID uuid = pmp.getUniqueID();
//                PlayerData pd = SkillsAPI.getPlayerData(uuid);
//
//                NBTTagCompound wrapper = new NBTTagCompound();
//                NBTTagCompound skillsData = new NBTTagCompound();
//                //NBTTagCompound attributeData = new NBTTagCompound();
//
//                EnumMap<SkillType, SkillData> skills = pd.getSkills();
//                for(Map.Entry<SkillType, SkillData> entry : skills.entrySet()){
//
//                    SkillType type = entry.getKey();
//                    SkillData sd = entry.getValue();
//                    double level = sd.getLevel();
//                    double timeSpent = sd.getTimeSpent();
//
//                    NBTTagCompound skill = new NBTTagCompound();
//                    skill.setDouble("Time Spent", timeSpent);
//                    skill.setDouble("Level", level);
//                    skillsData.setTag(type.toString(), skill);
//
//                }
//                wrapper.setTag("Skills", skillsData);
//                PacketHandler.INSTANCE.sendTo(new SendPlayerDataToClientPacket(wrapper), pmp);
//            }
//        }
        }
}

