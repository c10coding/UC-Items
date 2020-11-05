package net.dohaw.ucores.init;

import net.dohaw.ucores.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block SHADOWIRON_ORE = new BlockBase("shadowiron_ore", Material.IRON);
    public static final Block DULL_COPPER_ORE = new BlockBase("dull_copper_ore", Material.IRON);
    public static final Block COPPER_ORE = new BlockBase("copper_ore", Material.IRON);
    public static final Block AGAPITE_ORE = new BlockBase("agapite_ore", Material.IRON);
    public static final Block VERITE_ORE = new BlockBase("verite_ore", Material.IRON);
    public static final Block VALORITE_ORE = new BlockBase("valorite_ore", Material.IRON);
    public static final Block BRONZE_ORE = new BlockBase("bronze_ore", Material.IRON);

}
