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

    final double GUI_PERCENTAGE_WIDTH = 0.7;
    final double GUI_PERCENTAGE_HEIGHT = .50;

    private int guiWidth, guiHeight;
    private int guiX, guiY;
    private NBTTagCompound skillsData;

    private int buttonId = 0;

    public SkillsMenu(NBTTagCompound skillsData) {
        this.skillsData = skillsData;
    }

    @Override
    public void initGui(){
        updateGuiInfo();
        initCategoryButtons();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){

        updateGuiInfo();

        this.drawDefaultBackground();

        mc.getTextureManager().bindTexture(new ResourceLocation(UCItems.MODID, "textures/gui/testing.png"));
        drawTexturedModalRect(guiX, guiY,0, 0, guiWidth, guiHeight);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    private void initCategoryButtons(){

        final int WIDTH_BETWEEN_CATEGORIES = 10;
        final int NUM_CATEGORIES = SkillCategory.values().length;
        final int BUTTON_SPACE = guiWidth - (WIDTH_BETWEEN_CATEGORIES * (NUM_CATEGORIES + 1));
        final int BUTTON_WIDTH = BUTTON_SPACE / NUM_CATEGORIES;
        final int BUTTON_Y = guiY - 100;
        final int BUTTON_HEIGHT = 50;

        System.out.println("SPACE: " + BUTTON_SPACE);
        System.out.println("GUI X: " + guiX);
        System.out.println("GUI Y: " + guiY);

        int currentX = guiX + WIDTH_BETWEEN_CATEGORIES;
        for(SkillCategory category : SkillCategory.values()){
            int id = buttonId++;
            this.buttonList.add(new GuiButton(id, currentX, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, category.name()));
            currentX += (WIDTH_BETWEEN_CATEGORIES + BUTTON_WIDTH);
        }

    }

    private void updateGuiInfo(){
        guiWidth = (int) (width * GUI_PERCENTAGE_WIDTH);
        guiHeight = (int) (width * GUI_PERCENTAGE_HEIGHT);
        guiX = (width / 2) - (guiWidth / 2);
        guiY = (height / 2) - (guiHeight / 2);
    }

}
