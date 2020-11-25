package com.ShteKen.endrem.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.function.Supplier;

public class DetectPortal {


    public static boolean DetectionOfPortal(World worldIn, BlockPos pos)
    {
        int activeFrameCounter = 0;
        IForgeRegistryEntry frameArray[];

        frameArray = new IForgeRegistryEntry[]{
                RegistryHandler.OLD_FRAME.get(),
                RegistryHandler.ROGUE_FRAME.get(),
                RegistryHandler.NETHER_FRAME.get(),
                RegistryHandler.COLD_FRAME.get(),
                RegistryHandler.CORRUPTED_FRAME.get(),
                RegistryHandler.MAGICAL_FRAME.get(),
                RegistryHandler.BLACK_FRAME.get(),
                RegistryHandler.LOST_FRAME.get(),
                RegistryHandler.WITHER_FRAME.get(),
                RegistryHandler.GUARDIAN_FRAME.get(),
                RegistryHandler.END_CRYSTAL_FRAME.get()};

        for (BlockPos blockposMutable :
                BlockPos.getAllInBoxMutable(pos.add(9, 9, 9), pos.add(-9, -9, -9))) {

            for (IForgeRegistryEntry frame : frameArray) {
                if (worldIn.getBlockState(blockposMutable).getBlock() == frame) {
                    activeFrameCounter += 1;
                }
            }
        }
    return activeFrameCounter == frameArray.length;
    }
}
