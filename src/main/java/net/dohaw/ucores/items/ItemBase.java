package net.dohaw.ucores.items;

import net.dohaw.ucores.UCOres;
import net.dohaw.ucores.init.ModItems;
import net.dohaw.ucores.utils.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name){
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.MATERIALS);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        UCOres.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
