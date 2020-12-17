package net.dohaw.ucitems.gui;

import net.dohaw.ucitems.UCItems;
import net.dohaw.ucitems.gui.buttons.CustomGuiButton;
import net.dohaw.ucitems.skills.SkillCategory;
import net.dohaw.ucitems.skills.SkillType;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import java.util.*;

public class SkillsMenu extends GuiScreen {

    private SkillCategory currentCategory;
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

        for(GuiButton button: buttonList){
            if(isHoveringButton(mouseX, mouseY, button)){
                drawHoveringText("Testing", mouseX, mouseY);
            }
        }

    }

    private void initCategoryButtons(){

        buttonList.clear();
        final int WIDTH_BETWEEN_CATEGORIES = 10;
        final int BUTTON_HEIGHT = 20;
        final int NUM_CATEGORIES = SkillCategory.values().length;

        int buttonSpace = guiWidth - (WIDTH_BETWEEN_CATEGORIES * (NUM_CATEGORIES + 1));
        int buttonWidth = buttonSpace / NUM_CATEGORIES;
        this.guiCategoryMaxY = guiY + 5;
        int buttonX = guiX + WIDTH_BETWEEN_CATEGORIES;

        for(SkillCategory category : SkillCategory.values()){
            int id = buttonId++;
            this.buttonList.add(new CustomGuiButton(id, buttonX, guiCategoryMaxY, buttonWidth, BUTTON_HEIGHT, category.name(), "button_texture"));
            buttonX += (WIDTH_BETWEEN_CATEGORIES + buttonWidth);
        }

    }

    private void initCategoryLabels(){

        labelList.clear();
        final int LABEL_WIDTH = 100;
        final int LABEL_HEIGHT = 20;
        final int COLUMN_VERTICAL_PADDING = 20;
        final int COLUMN_HORIZATONAL_SPACE = 20;
        final int LABEL_VERTICAL_SPACE = (guiHeight - (COLUMN_VERTICAL_PADDING * 2)) - (MAX_SKILLS_PER_COLUMN * LABEL_HEIGHT);

        Map<SkillType, NBTTagCompound> currentCategoryData = skillsPerCategory.get(currentCategory);
        int labelY = guiCategoryMaxY + COLUMN_VERTICAL_PADDING;
        int columnX;

        if(currentCategoryData.size() <= MAX_SKILLS_PER_COLUMN){
            columnX = ((guiX + guiWidth) / 2) - (LABEL_WIDTH / 2);
        }else{
            columnX = guiX + COLUMN_HORIZATONAL_SPACE;
        }

        int labelPageCount = 1;
        int labelID = 0;
        for(Map.Entry<SkillType, NBTTagCompound> entry : currentCategoryData.entrySet()){

            if(labelPageCount == (MAX_SKILLS_PER_COLUMN * 2)){
                return;
            }else{

                if(labelPageCount == MAX_SKILLS_PER_COLUMN){
                    columnX = (guiX + guiWidth) - (COLUMN_HORIZATONAL_SPACE + LABEL_WIDTH);
                }

                //GUI LABEL ARGUMENTS: ID, X, Y, WIDTH, HEIGHT, COLOR
                int id = labelID++;
                GuiLabel label = new GuiLabel(fontRenderer, id, columnX, labelY, LABEL_WIDTH, LABEL_HEIGHT, 0xFFFFFF);
                NBTTagCompound tag = entry.getValue();
                String labelText = entry.getKey().toString();
                label.addLine(labelText);
                this.labelList.add(label);

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
                    // Removes it so that it doesn't have to keep looping through skill types that are already used. // more efficient.
                    itr.remove();
                    skillsCompound.removeTag(skillType.toString());
                    categorySkills.put(skillType, skillsData.getCompoundTag("Skills").getCompoundTag(skillType.toString()));
                }
            }
            this.skillsPerCategory.put(category, categorySkills);
        }

    }

    private void updateGuiInfo(){
        guiWidth = (int) (width * GUI_PERCENTAGE_WIDTH);
        guiHeight = (int) (height * GUI_PERCENTAGE_HEIGHT);
        guiX = (width / 2) - (guiWidth / 2);
        guiY = (height / 2) - (guiHeight / 2);
    }

    private boolean isHoveringButton(int mouseX, int mouseY, GuiButton button){
        int buttonMaxX = button.x + button.width;
        int buttonMaxY = button.y + button.height;
        return mouseX >= button.x && mouseX <= buttonMaxX && mouseY >= button.y && mouseY <= buttonMaxY;
    }

}
