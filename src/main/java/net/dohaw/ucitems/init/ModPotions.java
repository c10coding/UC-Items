package net.dohaw.ucitems.init;

import net.dohaw.ucitems.items.PotionBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModPotions {

    public static Map<Potion, List<PotionType>> potions = new HashMap<>();

    public static final Potion YOUR_POTION_EFFECT = new PotionBase("my_potion", false, 13791173, 0, 0);

    public static final PotionType YOUR_POTION = new PotionType("my_potion", new PotionEffect[] {new PotionEffect(YOUR_POTION_EFFECT, 2400)}).setRegistryName("my_potion");
    public static final PotionType LONG_YOUR_POTION = new PotionType("my_potion", new PotionEffect[] {new PotionEffect(YOUR_POTION_EFFECT, 4800)}).setRegistryName("long_my_potion");

    public static void registerPotions(){
        compilePotions();
        registerPotion(YOUR_POTION, LONG_YOUR_POTION, YOUR_POTION_EFFECT);
    }

    private static void registerPotion(PotionType defaultPotion, PotionType longPotion, Potion effect){
        ForgeRegistries.POTIONS.register(effect);
        ForgeRegistries.POTION_TYPES.register(defaultPotion);
        ForgeRegistries.POTION_TYPES.register(longPotion);
    }

    private static void compilePotions(){
        potions.put(
            YOUR_POTION_EFFECT,
            new ArrayList<PotionType>(){{
                add(YOUR_POTION);
                add(LONG_YOUR_POTION);
            }}
        );
    }

}
