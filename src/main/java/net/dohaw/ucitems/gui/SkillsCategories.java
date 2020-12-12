package net.dohaw.ucitems.gui;

import net.dohaw.ucitems.UCItems;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class SkillsCategories extends GuiScreen {

    final int GUI_WIDTH = 150;
    final int GUI_HEIGHT = 200;

    @Override
    public void initGui(){
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){

        int guiX = (width / 2) - (GUI_WIDTH / 2);
        int guiY = (height / 2) - (GUI_HEIGHT / 2);

        this.drawDefaultBackground();

        mc.getTextureManager().bindTexture(new ResourceLocation(UCItems.MODID, "textures/gui/testing.png"));
        drawTexturedModalRect(guiX, guiY,0, 0, GUI_WIDTH, GUI_HEIGHT);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

}
