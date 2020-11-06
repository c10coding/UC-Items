package net.dohaw.ucitems.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init(){
        GameRegistry.addSmelting(ModBlocks.SHADOWIRON_ORE, new ItemStack(ModItems.SHADOWIRON_INGOT, 1), 1.5f);
        GameRegistry.addSmelting(ModBlocks.DULL_COPPER_ORE, new ItemStack(ModItems.DULL_COPPER_INGOT, 1), 1.5f);
        GameRegistry.addSmelting(ModBlocks.COPPER_ORE, new ItemStack(ModItems.COPPER_INGOT, 1), 1.5f);
        GameRegistry.addSmelting(ModBlocks.AGAPITE_ORE, new ItemStack(ModItems.AGAPITE_INGOT, 1), 1.5f);
        GameRegistry.addSmelting(ModBlocks.VERITE_ORE, new ItemStack(ModItems.VERITE_INGOT, 1), 1.5f);
        GameRegistry.addSmelting(ModBlocks.VALORITE_ORE, new ItemStack(ModItems.VALORITE_INGOT, 1), 1.5f);
        GameRegistry.addSmelting(ModBlocks.BRONZE_ORE, new ItemStack(ModItems.BRONZE_INGOT, 1), 1.5f);
//        GameRegistry.addSmelting(ModBlocks.ASH_WOOD, Items.COAL.getDefaultInstance(), 1.5f);
//        GameRegistry.addSmelting(ModBlocks.BLOOD_WOOD, Items.COAL.getDefaultInstance(), 1.5f);
//        GameRegistry.addSmelting(ModBlocks.FROST_WOOD, Items.COAL.getDefaultInstance(), 1.5f);
//        GameRegistry.addSmelting(ModBlocks.HEART_WOOD, Items.COAL.getDefaultInstance(), 1.5f);
//        GameRegistry.addSmelting(ModBlocks.NORMAL_WOOD, Items.COAL.getDefaultInstance(), 1.5f);
//        GameRegistry.addSmelting(ModBlocks.YEW_WOOD, Items.COAL.getDefaultInstance(), 1.5f);
    }

}
