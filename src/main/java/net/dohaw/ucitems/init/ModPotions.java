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
    private static final String GREATER_AGILITY_POTION_NAME = "greater_agility_potion";
    private static final String CONFLAGRATION_POTION_NAME = "conflagration_potion";
    private static final String GREATER_CONFLAGRATION_POTION_NAME = "greater_conflagration_potion";
    private static final String LESSER_CURE_POTION_NAME = "lesser_cure_potion";
    private static final String CURE_POTION_NAME = "cure_potion";
    private static final String GREATER_CURE_POTION_NAME = "greater_cure_potion";
    private static final String LESSER_EXPLOSION_POTION_NAME = "lesser_explosion_potion";
    private static final String EXPLOSION_POTION_NAME = "explosion_potion";
    private static final String GREATER_EXPLOSION_POTION_NAME = "greater_explosion_potion";


    public static final Potion AGILITY_EFFECT = new PotionBase(AGILITY_POTION_NAME, false, 8257395, 0, 0);
    public static final PotionType AGILITY_TYPE = new PotionType(AGILITY_POTION_NAME, new PotionEffect[] {new PotionEffect(AGILITY_EFFECT, 2400)}).setRegistryName(AGILITY_POTION_NAME);

    public static final Potion GREATER_AGILITY_EFFECT = new PotionBase(GREATER_AGILITY_POTION_NAME, false, 8236625, 0, 0);
    public static final PotionType GREATER_AGILITY_TYPE = new PotionType(GREATER_AGILITY_POTION_NAME, new PotionEffect[]{new PotionEffect(GREATER_AGILITY_EFFECT, 2400)}).setRegistryName(GREATER_AGILITY_POTION_NAME);

    public static final Potion CONFLAGRATION_EFFECT = new PotionBase(CONFLAGRATION_POTION_NAME, false, 16728640, 0, 0);
    public static final PotionType CONFLAGRATION_TYPE = new PotionType(CONFLAGRATION_POTION_NAME, new PotionEffect[] {new PotionEffect(CONFLAGRATION_EFFECT, 2400)}).setRegistryName(CONFLAGRATION_POTION_NAME);

    public static final Potion GREATER_CONFLAGRATION_EFFECT = new PotionBase(GREATER_CONFLAGRATION_POTION_NAME, false, 10240576, 0, 0);
    public static final PotionType GREATER_CONFLGRATION_TYPE = new PotionType(GREATER_CONFLAGRATION_POTION_NAME, new PotionEffect[] {new PotionEffect(GREATER_CONFLAGRATION_EFFECT, 2400)}).setRegistryName(GREATER_CONFLAGRATION_POTION_NAME);

    public static final Potion LESSER_CURE_EFFECT = new PotionBase(LESSER_CURE_POTION_NAME, false, 7457023, 0, 0);
    public static final PotionType LESSER_CURE_TYPE = new PotionType(LESSER_CURE_POTION_NAME, new PotionEffect[] {new PotionEffect(LESSER_CURE_EFFECT, 2400)}).setRegistryName(LESSER_CURE_POTION_NAME);

    public static final Potion CURE_EFFECT = new PotionBase(CURE_POTION_NAME, false, 7449599, 0, 0);
    public static final PotionType CURE_TYPE = new PotionType(CURE_POTION_NAME, new PotionEffect[] {new PotionEffect(CURE_EFFECT, 2400)}).setRegistryName(CURE_POTION_NAME);

    public static final Potion GREATER_CURE_EFFECT = new PotionBase(GREATER_CURE_POTION_NAME, false, 7439103, 0, 0);
    public static final PotionType GREATER_CURE_TYPE = new PotionType(GREATER_CURE_POTION_NAME, new PotionEffect[] {new PotionEffect(GREATER_CURE_EFFECT, 2400)}).setRegistryName(GREATER_CURE_POTION_NAME);

    public static final Potion LESSER_EXPLOSION_EFFECT = new PotionBase(LESSER_EXPLOSION_POTION_NAME, false, 16760902, 0, 0);
    public static final PotionType LESSER_EXPLOSION_TYPE = new PotionType(LESSER_EXPLOSION_POTION_NAME, new PotionEffect[] {new PotionEffect(LESSER_EXPLOSION_EFFECT, 2400)}).setRegistryName(LESSER_EXPLOSION_POTION_NAME);

    public static final Potion EXPLOSION_EFFECT = new PotionBase(EXPLOSION_POTION_NAME, false, 16754502, 0, 0);
    public static final PotionType EXPLOSION_TYPE = new PotionType(EXPLOSION_POTION_NAME, new PotionEffect[] {new PotionEffect(EXPLOSION_EFFECT, 2400)}).setRegistryName(EXPLOSION_POTION_NAME);

    public static final Potion GREATER_EXPLOSION_EFFECT = new PotionBase(GREATER_EXPLOSION_POTION_NAME, false, 16749126, 0, 0);
    public static final PotionType GREATER_EXPLOSION_TYPE = new PotionType(GREATER_EXPLOSION_POTION_NAME, new PotionEffect[] {new PotionEffect(GREATER_EXPLOSION_EFFECT, 2400)}).setRegistryName(GREATER_EXPLOSION_POTION_NAME);

    public static final Potion GREATER_EXPLOSION_EFFECT = new PotionBase(GREATER_EXPLOSION_POTION_NAME, false, 16749126, 0, 0);
    public static final PotionType GREATER_EXPLOSION_TYPE = new PotionType(GREATER_EXPLOSION_POTION_NAME, new PotionEffect[] {new PotionEffect(GREATER_EXPLOSION_EFFECT, 2400)}).setRegistryName(GREATER_EXPLOSION_POTION_NAME);

    public static void registerPotions(){
        registerPotion(AGILITY_EFFECT, AGILITY_TYPE);
        registerPotion(GREATER_AGILITY_EFFECT, GREATER_AGILITY_TYPE);
        registerPotion(CONFLAGRATION_EFFECT, CONFLAGRATION_TYPE);
        registerPotion(GREATER_CONFLAGRATION_EFFECT, GREATER_CONFLGRATION_TYPE);
        registerPotion(LESSER_CURE_EFFECT, LESSER_CURE_TYPE);
        registerPotion(CURE_EFFECT, CURE_TYPE);
        registerPotion(GREATER_CURE_EFFECT, GREATER_CURE_TYPE);
        registerPotion(LESSER_EXPLOSION_EFFECT, LESSER_EXPLOSION_TYPE);
        registerPotion(EXPLOSION_EFFECT, EXPLOSION_TYPE);
        registerPotion(GREATER_EXPLOSION_EFFECT, GREATER_EXPLOSION_TYPE);
    }

    private static void registerPotion(Potion effect, PotionType type){
        List<PotionType> validTypes = new ArrayList<>();
        ForgeRegistries.POTIONS.register(effect);
        validTypes.add(type);
        ForgeRegistries.POTION_TYPES.register(type);
        potions.put(effect, validTypes);
    }

}
