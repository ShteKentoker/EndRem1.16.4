package com.ShteKen.endrem.events;

import com.ShteKen.endrem.EndRemastered;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndRemastered.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterEventHandler {

    public static final String MOD_ID = "endrem";

    //register the biome

    public  static ResourceLocation location(String name) {
        return new ResourceLocation(EndRemastered.MOD_ID, name);
    }
}
