package net.dohaw.ucitems.gui;

import net.dohaw.ucitems.UCItems;
import net.dohaw.ucitems.gui.buttons.CustomGuiButton;
import net.dohaw.ucitems.skills.SkillCategory;
import net.dohaw.ucitems.skills.SkillType;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import java.util.*;

public class SkillsMenu extends GuiScreen {

    private final SkillCategory currentCategory;
    private EnumMap<SkillCategory, EnumMap<SkillType, NBTTagCompound>> skillsPerCategory = new EnumMap<>(SkillCategory.class);

    private final int MAX_SKILLS_PER_COLUMN = 4;
    private final double GUI_PERCENTAGE_WIDTH = 0.7;
    private final double GUI_PERCENTAGE_HEIGHT = .50;

    private int guiCategoryMaxY;
    private int guiWidth, guiHeight;
    private int guiX, guiY;

    private int buttonId = 0;

    /*
        Only use this when first opening the menu
     */
    public SkillsMenu(SkillCategory category, NBTTagCompound skillsData) {
        this.currentCategory = category;
        compileSkillsMap(skillsData);
    }

    public SkillsMenu(SkillCategory category, EnumMap<SkillCategory, EnumMap<SkillType, NBTTagCompound>> skillsPerCategory){
        this.skillsPerCategory = skillsPerCategory;
        this.currentCategory = category;
    }

    @Override
    public void initGui(){
        updateGuiInfo();
        initCategoryButtons();
        initCategoryLabels();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){

        updateGuiInfo();

        mc.getTextureManager().bindTexture(new ResourceLocation(UCItems.MODID, "textures/gui/skill_menu_background.png"));
        drawTexturedModalRect(guiX, guiY,0, 0, guiWidth, guiHeight);

        super.drawScreen(mouseX, mouseY, partialTicks);

//        for(GuiButton button: buttonList){
//            if(isHoveringButton(mouseX, mouseY, button)){
//                drawHoveringText("Testing", mouseX, mouseY);
//            }
//        }

    }

    private void initCategoryButtons(){

        buttonList.clear();
        final int WIDTH_BETWEEN_CATEGORIES = 10;
        final int BUTTON_HEIGHT = 20;
        final int NUM_CATEGORIES = SkillCategory.values().length;

        int buttonSpace = guiWidth - (WIDTH_BETWEEN_CATEGORIES * (NUM_CATEGORIES + 1));
        int buttonWidth = buttonSpace / NUM_CATEGORIES;
        int buttonY = guiY + 5;
        this.guiCategoryMaxY = guiY + BUTTON_HEIGHT;
        int buttonX = guiX + WIDTH_BETWEEN_CATEGORIES;

        for(SkillCategory category : SkillCategory.values()){
            int id = buttonId++;
            this.buttonList.add(new CustomGuiButton(id, buttonX, buttonY, buttonWidth, BUTTON_HEIGHT, category.name(), "button_texture"));
            buttonX += (WIDTH_BETWEEN_CATEGORIES + buttonWidth);
        }

    }

    private void initCategoryLabels(){

        labelList.clear();
        final int LABEL_WIDTH = 100;
        final int LABEL_HEIGHT = 50;
        final int COLUMN_VERTICAL_PADDING = 20;
        final int COLUMN_HORIZONTAL_SPACE = 20;
        final int LABEL_VERTICAL_SPACE = (guiHeight - (guiCategoryMaxY - guiY)) / 5/*+ (COLUMN_VERTICAL_PADDING * 2)*/ ;

        System.out.println("BRUH2 : " + guiHeight);
        System.out.println("LABEL VERT: " + LABEL_VERTICAL_SPACE);

        Map<SkillType, NBTTagCompound> currentCategoryData = skillsPerCategory.get(currentCategory);
        int labelY = guiCategoryMaxY + LABEL_VERTICAL_SPACE;
        int columnX = guiX + COLUMN_HORIZONTAL_SPACE;

        int labelPageCount = 1;
        int labelID = 0;
        for(Map.Entry<SkillType, NBTTagCompound> entry : currentCategoryData.entrySet()){

            if(labelPageCount == (MAX_SKILLS_PER_COLUMN * 2)){
                return;
            }else{

                if(labelPageCount == MAX_SKILLS_PER_COLUMN){
                    columnX = (guiX + guiWidth) - (COLUMN_HORIZONTAL_SPACE + LABEL_WIDTH);
                }

                //GUI LABEL ARGUMENTS: ID, X, Y, WIDTH, HEIGHT, COLOR
                int id = labelID++;
                GuiLabel skillNameLabel = new GuiLabel(fontRenderer, id, columnX, labelY, LABEL_WIDTH, LABEL_HEIGHT, 0xFFFFFF);
                String labelText = entry.getKey().toString();
                int skillLevelNameWidth = fontRenderer.getStringWidth(labelText);

                skillNameLabel.addLine(labelText);

                NBTTagCompound tag = entry.getValue();

                int levelLabelX = skillNameLabel.x + skillLevelNameWidth + 10;
                GuiLabel levelLabel = new GuiLabel(fontRenderer, id, levelLabelX, labelY, LABEL_WIDTH, LABEL_HEIGHT, 0xFFFFFF);
                double level = tag.getDouble("Level");
                String levelLine = "Level: " + level;
                levelLabel.addLine(levelLine);

                int levelLineWidth = fontRenderer.getStringWidth(levelLine);
                int timeSpentLabelX = levelLabel.x + levelLineWidth + 10;
                GuiLabel timeSpentLabel = new GuiLabel(fontRenderer, id, timeSpentLabelX, labelY, LABEL_WIDTH, LABEL_HEIGHT, 0xFFFFFF);

                double timeSpent = tag.getDouble("Time Spent");
                timeSpentLabel.addLine("Time Spent: " + timeSpent);

                this.labelList.add(skillNameLabel);
                this.labelList.add(levelLabel);
                this.labelList.add(timeSpentLabel);

                labelY += LABEL_VERTICAL_SPACE;
                labelPageCount++;

            }
        }

    }

    private void compileSkillsMap(NBTTagCompound skillsData){

        List<SkillType> skillTypes = new ArrayList<>(Arrays.asList(SkillType.values()));
        NBTTagCompound skillsCompound = skillsData.getCompoundTag("Skills");
        //TODO: Refactor this later down the road to where it categorizes the nbtdata in categories instead of doing it here.
        for(SkillCategory category : SkillCategory.values()){
            EnumMap<SkillType, NBTTagCompound> categorySkills = new EnumMap<>(SkillType.class);
            Iterator<SkillType> itr = skillTypes.iterator();
            while(itr.hasNext()){
                SkillType skillType = itr.next();
                if(skillType.getCategory() == category){
                    categorySkills.put(skillType, skillsCompound.getCompoundTag(skillType.toString()));
                    // Removes it so that it doesn't have to keep looping through skill types that are already used. // more efficient.
                    skillsCompound.removeTag(skillType.toString());
                    itr.remove();
                }
            }
            this.skillsPerCategory.put(category, categorySkills);
        }

        System.out.println("SKILLS CATEGORY: " + skillsPerCategory.toString());

    }

    private void updateGuiInfo(){
        guiWidth = (int) (width * GUI_PERCENTAGE_WIDTH);
        guiHeight = (int) (height * GUI_PERCENTAGE_HEIGHT);
        guiX = (width / 2) - (guiWidth / 2);
        guiY = (height / 2) - (guiHeight / 2);
    }

//    private boolean isHoveringButton(int mouseX, int mouseY, GuiButton button){
//        int buttonMaxX = button.x + button.width;
//        int buttonMaxY = button.y + button.height;
//        return mouseX >= button.x && mouseX <= buttonMaxX && mouseY >= button.y && mouseY <= buttonMaxY;
//    }

//    private boolean isHoveringLabel(int mouseX, int mouseY, GuiLabel label){
//        int labelMaxX = label.x + fontRenderer.getStringWidth(label.);
//        int buttonMaxY = button.y + button.height;
//        return mouseX >= button.x && mouseX <= buttonMaxX && mouseY >= button.y && mouseY <= buttonMaxY;
//    }

}
