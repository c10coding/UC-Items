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

    public static final Potion AGILITY_POTION_EFFECT = new PotionBase("agility_potion", false, 8257395, 0, 0);
    public static final PotionType DEFAULT_AGILITY_TYPE = new PotionType("agility_potion", new PotionEffect[] {new PotionEffect(AGILITY_POTION_EFFECT, 2400)}).setRegistryName("agility_potion");

    public static final Potion GREATER_AGILITY_POTION_EFFECT = new PotionBase("greater_agility_potion", false, 8236625, 0, 0);
    public static final PotionType DEFAULT_GREATER_AGILITY_POTION_TYPE = new PotionType("greater_agility_potion", new PotionEffect[]{new PotionEffect(GREATER_AGILITY_POTION_EFFECT, 2400)}).setRegistryName("greater_ability_potion");

    public static void registerPotions(){
        compilePotions();
        registerPotion(AGILITY_POTION_EFFECT, DEFAULT_AGILITY_TYPE, null);
        registerPotion(GREATER_AGILITY_POTION_EFFECT, DEFAULT_GREATER_AGILITY_POTION_TYPE, null);
    }

    private static void registerPotion(Potion effect, PotionType type, PotionType longType){
        ForgeRegistries.POTIONS.register(effect);
        ForgeRegistries.POTION_TYPES.register(type);
        if(longType != null){
            ForgeRegistries.POTION_TYPES.register(longType);
        }
    }

    private static void compilePotions(){
        potions.put(
            AGILITY_POTION_EFFECT,
            new ArrayList<PotionType>(){{
                add(DEFAULT_AGILITY_TYPE);
            }}
        );
        potions.put(
            GREATER_AGILITY_POTION_EFFECT,
            new ArrayList<PotionType>(){{
                add(DEFAULT_GREATER_AGILITY_POTION_TYPE);
            }}
        );
    }

}
