package net.dohaw.ucitems.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class MyCommand extends CommandBase {

    @Override
    public String getName() {
        return "ucitems";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "Help for UC Items";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args){
        //Minecraft.getMinecraft().displayGuiScreen(new MyScreen());
    }
}
