package net.dohaw.ucitems.gui;

import net.dohaw.play.skills.PlayerData;
import net.dohaw.ucitems.UCItems;
import net.dohaw.ucitems.skills.SkillCategory;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class SkillsMenu extends GuiScreen {

    final int GUI_WIDTH = 150;
    final int GUI_HEIGHT = 200;

    private int guiX, guiY;
    private NBTTagCompound skillsData;

    private int buttonId = 0;

    public SkillsMenu(NBTTagCompound skillsData) {
        this.skillsData = skillsData;
    }

    @Override
    public void initGui(){
        initCategoryButtons();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){

        guiX = (width / 2) - (GUI_WIDTH / 2);
        guiY = (height / 2) - (GUI_HEIGHT / 2);

        this.drawDefaultBackground();

        mc.getTextureManager().bindTexture(new ResourceLocation(UCItems.MODID, "textures/gui/testing.png"));
        drawTexturedModalRect(guiX, guiY,0, 0, GUI_WIDTH, GUI_HEIGHT);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    private void initCategoryButtons(){

        final int WIDTH_BETWEEN_CATEGORIES = 10;
        final int NUM_CATEGORIES = SkillCategory.values().length;
        final int BUTTON_SPACE = GUI_WIDTH - (WIDTH_BETWEEN_CATEGORIES * (NUM_CATEGORIES + 1));
        final int BUTTON_WIDTH = BUTTON_SPACE / NUM_CATEGORIES;
        final int BUTTON_Y = guiY - 20;
        final int BUTTON_HEIGHT = 50;

        int currentX = guiX + WIDTH_BETWEEN_CATEGORIES;
        for(SkillCategory category : SkillCategory.values()){
            int id = buttonId++;
            this.buttonList.add(new GuiButton(buttonId++, currentX, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, category.name()));
            currentX += (WIDTH_BETWEEN_CATEGORIES + BUTTON_WIDTH);
        }

    }

}
