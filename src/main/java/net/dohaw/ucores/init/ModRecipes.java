package net.dohaw.ucores.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init(){
        GameRegistry.addSmelting(ModBlocks.SHADOWIRON_ORE, new ItemStack(ModItems.SHADOWIRON_INGOT, 1), 1.5f);
        GameRegistry.addSmelting(ModBlocks.DULL_COPPER_ORE, new ItemStack(ModItems.DULL_COPPER_INGOT, 1), 1.5f);
    }

}
