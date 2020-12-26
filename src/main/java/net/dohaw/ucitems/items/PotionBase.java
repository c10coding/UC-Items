package net.dohaw.ucitems.items;

import net.dohaw.ucitems.utils.IHasModel;
import net.minecraft.potion.Potion;

public class PotionBase extends Potion implements IHasModel {

    protected PotionBase(boolean isBadEffectIn, int liquidColorIn) {
        super(isBadEffectIn, liquidColorIn);
    }

    @Override
    public void registerModels() {

    }

}
