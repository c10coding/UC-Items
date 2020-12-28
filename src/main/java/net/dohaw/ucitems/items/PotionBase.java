package net.dohaw.ucitems.items;

import net.dohaw.ucitems.UCItems;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionBase extends Potion{

    private final String NAME;

    public PotionBase(String name, boolean isBadEffectIn, int liquidColorIn, int iconIndexX, int iconIndexY) {
        super(isBadEffectIn, liquidColorIn);
        this.NAME = name;
        setPotionName("effect." + name);
        setIconIndex(iconIndexX, iconIndexY);
        setRegistryName(new ResourceLocation(UCItems.MODID + ":" + name));
    }

    @Override
    public boolean hasStatusIcon(){
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(UCItems.MODID + "/textures/gui/potion_effects/" + NAME + ".png"));
        return true;
    }

}
