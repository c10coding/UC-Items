package net.dohaw.ucitems.proxy;

import net.dohaw.ucitems.packets.PacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class CommonProxy {

    public void registerItemRenderer(Item item, int meta, String id){
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }

    public void openGui(GuiScreen screen){
        //Minecraft.getMinecraft().displayGuiScreen(screen);
    }

}
