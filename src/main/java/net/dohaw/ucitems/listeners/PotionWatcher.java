package net.dohaw.ucitems.listeners;

import net.dohaw.ucitems.init.ModPotions;
import net.dohaw.ucitems.utils.PotionFunctionality;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber
public class PotionWatcher {

    @SubscribeEvent
    public static void onPotionActive(TickEvent.PlayerTickEvent e){

        boolean isActive = false;
        for(Map.Entry<Potion, List<PotionType>> entry : ModPotions.potions.entrySet()){

            Potion potionEffect = entry.getKey();
            if(e.player.isPotionActive(potionEffect)) isActive = true;

            if(isActive){
                PotionFunctionality.execute(e.player, potionEffect);
            }

        }
    }

}
