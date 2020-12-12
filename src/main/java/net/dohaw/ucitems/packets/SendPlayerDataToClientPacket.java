package net.dohaw.ucitems.packets;

import io.netty.buffer.ByteBuf;
import net.dohaw.play.skills.PlayerData;
import net.dohaw.play.skills.skills.AttributeType;
import net.dohaw.play.skills.skills.SkillData;
import net.dohaw.play.skills.skills.SkillType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

public class SendPlayerDataToClientPacket implements IMessage {

    private PlayerData pd;
    private final java.util.UUID UUID;

    public SendPlayerDataToClientPacket() {
        this.UUID = null;
    }

    public SendPlayerDataToClientPacket(final UUID UUID, PlayerData pd){
        this.pd = pd;
        this.UUID = UUID;
    }

    /**
     * Convert from the supplied buffer into your specific message type
     *
     * @param buf
     */
    @Override
    public void fromBytes(ByteBuf buf) {


        NBTTagCompound wrapper = ByteBufUtils.readTag(buf);
        PlayerData pd = new PlayerData(UUID);

        if(wrapper != null){

            if(wrapper.hasKey("Skills")){

                EnumMap<SkillType, SkillData> allSkillData = new EnumMap<>(SkillType.class);
                NBTTagCompound skillsTag = wrapper.getCompoundTag("Skills");
                for(SkillType type : SkillType.values()){

                    NBTTagCompound skill = skillsTag.getCompoundTag(type.toString());
                    double level = skill.getDouble("Level");
                    double timeSpent = skill.getDouble("Time Spent");
                    SkillData skillData = new SkillData(timeSpent, level);

                    allSkillData.put(type, skillData);

                }

                pd.setSkills(allSkillData);

            }

        }else{
            throw new NullPointerException("NBTTAG from SendPlayerDataToClientPacket is null!");
        }

        this.pd = pd;

    }

    /**
     * Deconstruct your message into the supplied byte buffer
     *
     * @param buf
     */
    @Override
    public void toBytes(ByteBuf buf) {

        NBTTagCompound wrapper = new NBTTagCompound();
        NBTTagCompound skillsData = new NBTTagCompound();
        //NBTTagCompound attributeData = new NBTTagCompound();

        EnumMap<SkillType, SkillData> skills = pd.getSkills();
        for(Map.Entry<SkillType, SkillData> entry : skills.entrySet()){

            SkillType type = entry.getKey();
            SkillData sd = entry.getValue();
            double level = sd.getLevel();
            double timeSpent = sd.getTimeSpent();

            NBTTagCompound skill = new NBTTagCompound();
            skill.setDouble("Time Spent", timeSpent);
            skill.setDouble("Level", timeSpent);
            skillsData.setTag(type.toString(), skill);

        }
        wrapper.setTag("Skills", skillsData);

//        EnumMap<AttributeType, Integer> attributes = pd.getAttributes();
//        for(Map.Entry<AttributeType, Integer> entry : attributes.entrySet()){
//
//            AttributeType type = entry.getKey();
//            int level = entry.getValue();
//
//            NBTTagCompound attribute = new NBTTagCompound();
//            attribute.setInteger("Level", level);
//            attributeData.setTag(type.toString(), attribute);
//
//        }
//        wrapper.setTag("Attributes", attributeData);

        ByteBufUtils.writeTag(buf, wrapper);

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
            if(ctx.side != Side.SERVER){
                System.out.println("THIS IS THE WRONG SIDE!");
            }else{
                System.out.println("SKILLS: " + message.pd.getSkills().toString());
            }
            return null;
        }
    }

}
