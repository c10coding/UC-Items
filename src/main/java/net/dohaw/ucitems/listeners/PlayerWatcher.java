package net.dohaw.ucitems.listeners;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber
public class PlayerWatcher {

    @SubscribeEvent
    public static void onUseBrewingStand(PlayerInteractEvent.RightClickBlock e){

        if(e.getSide() == Side.SERVER){

            World world = e.getWorld();
            BlockPos pos = e.getPos();
            IBlockState iBlockState = world.getBlockState(pos);

//            if(iBlockState.getBlock() == Blocks.BREWING_STAND){
//                Map<String>
//            }

        }


    }

}
