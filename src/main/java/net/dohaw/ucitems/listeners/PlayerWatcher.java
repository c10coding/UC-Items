package net.dohaw.ucitems.listeners;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.lang.reflect.Field;
import java.util.List;

public class PlayerWatcher {

    private static Field KEYBIND_ARRAY = null;

    @SubscribeEvent
    public void onPlayerRender(PlayerEvent.BreakSpeed e){
        e.setNewSpeed(1.5f);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onGUI(GuiScreenEvent.InitGuiEvent.Post event){
        GuiScreen screen = event.getGui();
        if(screen instanceof GuiInventory){
            System.out.println("HERE");
            List<GuiButton> buttons = event.getButtonList();
            GuiButton button = new GuiButton(543, screen.width / 2 - 100, screen.height - (screen.height / 4) + 10, "Button");
            event.getButtonList().add(button);
            buttons.add(button);
            event.setButtonList(buttons);
        }
    }


//    @SubscribeEvent (priority = EventPriority.LOWEST)
//    public void onClientTick(InputEvent.KeyInputEvent e) {
//        if(Keyboard.isKeyDown(Keyboard.KEY_E)){
//            Minecraft.getMinecraft().displayGuiScreen(new MyScreen(Minecraft.getMinecraft().player));
//        }
//    }

}
