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
    public static final PotionType DEFAULT_GREATER_AGILITY_POTION_TYPE = new PotionType("greater_agility_potion", new PotionEffect[]{new PotionEffect(GREATER_AGILITY_POTION_EFFECT, 2400)}).setRegistryName("greater_agility_potion");

    public static final Potion CONFLAGRATION_POTION_EFFECT = new PotionBase("conflagration_potion", false, 16728640, 0, 0);
    public static final PotionType DEFAULT_CONFLAGRATION_TYPE = new PotionType("conflagration_potion", new PotionEffect[] {new PotionEffect(CONFLAGRATION_POTION_EFFECT, 2400)}).setRegistryName("conflagration_potion");

    public static void registerPotions(){
        registerPotion(AGILITY_POTION_EFFECT, DEFAULT_AGILITY_TYPE, null);
        registerPotion(GREATER_AGILITY_POTION_EFFECT, DEFAULT_GREATER_AGILITY_POTION_TYPE, null);
        registerPotion(CONFLAGRATION_POTION_EFFECT, DEFAULT_CONFLAGRATION_TYPE, null);
    }

    private static void registerPotion(Potion effect, PotionType ...types){
        List<PotionType> validTypes = new ArrayList<>();
        ForgeRegistries.POTIONS.register(effect);
        for(PotionType type : types){
            if(type != null){
                validTypes.add(type);
                ForgeRegistries.POTION_TYPES.register(type);
            }
        }
        potions.put(effect, validTypes);
    }

}
