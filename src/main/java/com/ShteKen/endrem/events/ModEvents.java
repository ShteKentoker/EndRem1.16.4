package com.ShteKen.endrem.events;


import net.minecraft.item.EnderEyeItem;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ModEvents {

  // cancel the event aof activating the End Frame and locating the Stronghold

  @SubscribeEvent
    public static void ActivatingEndFrame(PlayerInteractEvent.RightClickBlock event){
        if (event.isCancelable()) {
            if (event.getPlayer().inventory.getCurrentItem().getItem() instanceof EnderEyeItem) {
                event.setCanceled(true);
            }
        }
    }

      @SubscribeEvent
    public static void FindingStronghold(PlayerInteractEvent.RightClickItem event){
        if (event.isCancelable()) {
            if (event.getPlayer().inventory.getCurrentItem().getItem() instanceof EnderEyeItem) {
                event.setCanceled(true);
            }
        }
    }

}

