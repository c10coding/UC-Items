package net.dohaw.ucitems.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class MyScreen extends GuiScreen {

    private GuiButton button;

    @Override
    public void initGui(){
        this.buttonList.add(button = new GuiButton(0, this.width / 2 - 100, this.height - (this.height / 4) + 10, "Button"));
    }

    @Override
    protected void actionPerformed(GuiButton _button)  {
        if (_button == button) {
            mc.player.closeScreen();
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }

}
