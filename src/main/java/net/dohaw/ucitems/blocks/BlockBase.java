package net.dohaw.ucitems.blocks;

import net.dohaw.ucitems.UCItems;
import net.dohaw.ucitems.init.ModBlocks;
import net.dohaw.ucitems.init.ModItems;
import net.dohaw.ucitems.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(String name, Material material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        UCItems.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
