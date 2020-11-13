package net.dohaw.ucitems.listeners;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerWatcher {

    @SubscribeEvent
    public void onPlayerRender(PlayerEvent.BreakSpeed e){
        e.setNewSpeed(1.5f);
    }

}
