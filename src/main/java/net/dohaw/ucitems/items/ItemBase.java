package net.dohaw.ucitems.items;

import net.dohaw.ucitems.UCItems;
import net.dohaw.ucitems.init.ModItems;
import net.dohaw.ucitems.utils.IHasModel;
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
        UCItems.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
