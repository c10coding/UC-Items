package net.dohaw.ucitems.gui;

import net.dohaw.ucitems.UCItems;
import net.dohaw.ucitems.gui.buttons.CustomGuiButton;
import net.dohaw.ucitems.skills.SkillCategory;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

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

        //this.drawDefaultBackground();

        mc.getTextureManager().bindTexture(new ResourceLocation(UCItems.MODID, "textures/gui/skill_menu_background.png"));
        drawTexturedModalRect(guiX, guiY,0, 0, guiWidth, guiHeight);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    private void initCategoryButtons(){

        final int WIDTH_BETWEEN_CATEGORIES = 10;
        final int BUTTON_HEIGHT = 20;
        final int NUM_CATEGORIES = SkillCategory.values().length;

        int buttonSpace = guiWidth - (WIDTH_BETWEEN_CATEGORIES * (NUM_CATEGORIES + 1));
        int buttonWidth = buttonSpace / NUM_CATEGORIES;
        int buttonY = guiY + 5;
        int buttonX = guiX + WIDTH_BETWEEN_CATEGORIES;

        for(SkillCategory category : SkillCategory.values()){
            int id = buttonId++;
            this.buttonList.add(new CustomGuiButton(id, buttonX, buttonY, buttonWidth, BUTTON_HEIGHT, category.name(), "button_texture"));
            buttonX += (WIDTH_BETWEEN_CATEGORIES + buttonWidth);
        }

    }

    private void updateGuiInfo(){
        guiWidth = (int) (width * GUI_PERCENTAGE_WIDTH);
        guiHeight = (int) (height * GUI_PERCENTAGE_HEIGHT);
        guiX = (width / 2) - (guiWidth / 2);
        guiY = (height / 2) - (guiHeight / 2);
    }

}
