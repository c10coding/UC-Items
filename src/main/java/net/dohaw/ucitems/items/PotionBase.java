package net.dohaw.ucitems.items;

import net.dohaw.ucitems.UCItems;
import net.dohaw.ucitems.utils.IHasModel;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionBase extends Potion{

    public PotionBase(String name, boolean isBadEffectIn, int liquidColorIn, int iconIndexX, int iconIndexY) {
        super(isBadEffectIn, liquidColorIn);
        setPotionName("effect." + name);
        setIconIndex(iconIndexX, iconIndexY);
        setRegistryName(new ResourceLocation(UCItems.MODID + ":" + name));
    }

    @Override
    public boolean hasStatusIcon(){
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(UCItems.MODID + "/textures/gui/potion_effects.png"));
        return true;
    }

}
