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

    private static final String AGILITY_POTION_NAME = "agility_potion";
    private static final String CONFLAGRATION_POTION_NAME = "conflagration_potion";
    private static final String CURE_POTION_NAME = "cure_potion";
    private static final String EXPLOSION_POTION_NAME = "explosion_potion";

    public static final Potion AGILITY_EFFECT = new PotionBase(AGILITY_POTION_NAME, false, 8257395, 0, 0);
    public static final PotionType AGILITY_TYPE = new PotionType(AGILITY_POTION_NAME, new PotionEffect[] {new PotionEffect(AGILITY_EFFECT, 2400)}).setRegistryName(AGILITY_POTION_NAME);

    public static final Potion CONFLAGRATION_EFFECT = new PotionBase(CONFLAGRATION_POTION_NAME, false, 16728640, 0, 0);
    public static final PotionType CONFLAGRATION_TYPE = new PotionType(CONFLAGRATION_POTION_NAME, new PotionEffect[] {new PotionEffect(CONFLAGRATION_EFFECT, 2400)}).setRegistryName(CONFLAGRATION_POTION_NAME);

    public static final Potion CURE_EFFECT = new PotionBase(CURE_POTION_NAME, false, 7449599, 0, 0);
    public static final PotionType CURE_TYPE = new PotionType(CURE_POTION_NAME, new PotionEffect[] {new PotionEffect(CURE_EFFECT, 2400)}).setRegistryName(CURE_POTION_NAME);

    public static final Potion EXPLOSION_EFFECT = new PotionBase(EXPLOSION_POTION_NAME, false, 16754502, 0, 0);
    public static final PotionType EXPLOSION_TYPE = new PotionType(EXPLOSION_POTION_NAME, new PotionEffect[] {new PotionEffect(EXPLOSION_EFFECT, 2400)}).setRegistryName(EXPLOSION_POTION_NAME);

    public static void registerPotions(){
        registerPotion(AGILITY_EFFECT, AGILITY_TYPE);
        registerPotion(CONFLAGRATION_EFFECT, CONFLAGRATION_TYPE);
        registerPotion(CURE_EFFECT, CURE_TYPE);
        registerPotion(EXPLOSION_EFFECT, EXPLOSION_TYPE);
    }

    private static void registerPotion(Potion effect, PotionType type){
        List<PotionType> validTypes = new ArrayList<>();
        ForgeRegistries.POTIONS.register(effect);
        validTypes.add(type);
        ForgeRegistries.POTION_TYPES.register(type);
        potions.put(effect, validTypes);
    }

}
