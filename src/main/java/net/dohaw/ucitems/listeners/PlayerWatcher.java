package net.dohaw.ucitems.listeners;

import net.dohaw.ucitems.gui.buttons.SkillsButton;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Field;
import java.util.List;

public class PlayerWatcher {

    private final int SKILLS_BUTTON_ID = 0;

    private static Field KEYBIND_ARRAY = null;

    @SubscribeEvent
    public void onPlayerRender(PlayerEvent.BreakSpeed e){
        e.setNewSpeed(1.5f);
    }

    @SubscribeEvent
    public void onGUI(GuiScreenEvent.InitGuiEvent.Post event){
        GuiScreen screen = event.getGui();
        if(screen instanceof GuiInventory){
            List<GuiButton> buttons = event.getButtonList();
            SkillsButton button = new SkillsButton(SKILLS_BUTTON_ID, 10, screen.height - 30, 40, 20, "Skills");
            buttons.add(button);
            event.setButtonList(buttons);
        }
    }

    @SubscribeEvent
    public void onPressGUIButton(GuiScreenEvent.ActionPerformedEvent e){
        GuiButton button = e.getButton();
        GuiScreen screen = e.getGui();
        if(screen instanceof GuiInventory){
            if(button.id == SKILLS_BUTTON_ID){
            }
        }
    }


//    @SubscribeEvent (priority = EventPriority.LOWEST)
//    public void onClientTick(InputEvent.KeyInputEvent e) {
//        if(Keyboard.isKeyDown(Keyboard.KEY_E)){
//            Minecraft.getMinecraft().displayGuiScreen(new MyScreen(Minecraft.getMinecraft().player));
//        }
//    }

}
