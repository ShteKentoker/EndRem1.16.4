package com.ShteKen.endrem.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EyeTemplate {

    // get all the blocks around so you cannot place twice the same eye
    public static boolean IsOldFrame(World worldIn, BlockPos pos)
    {
        for (BlockPos blockposMutable :
                BlockPos.getAllInBoxMutable(pos.add(9, 0, 9), pos.add(-9, 0, -9)))
        {
            if(worldIn.getBlockState(blockposMutable).getBlock() == RegistryHandler.OLD_FRAME.get()) {

                return true;
            }

        }
        return false;
    }

    public static boolean IsRogueFrame(World worldIn, BlockPos pos)
    {
        for (BlockPos blockposMutable :
                BlockPos.getAllInBoxMutable(pos.add(9, 0, 9), pos.add(-9, 0, -9)))
        {
            if(worldIn.getBlockState(blockposMutable).getBlock() == RegistryHandler.ROGUE_FRAME.get()) {

                return true;
            }

        }
        return false;
    }

    public static boolean IsNetherFrame(World worldIn, BlockPos pos)
    {
        for (BlockPos blockposMutable :
                BlockPos.getAllInBoxMutable(pos.add(9, 0, 9), pos.add(-9, 0, -9)))
        {
            if(worldIn.getBlockState(blockposMutable).getBlock() == RegistryHandler.NETHER_FRAME.get()) {

                return true;
            }

        }
        return false;
    }

    public static boolean IsColdFrame(World worldIn, BlockPos pos)
    {
        for (BlockPos blockposMutable :
                BlockPos.getAllInBoxMutable(pos.add(9, 0, 9), pos.add(-9, 0, -9)))
        {
            if(worldIn.getBlockState(blockposMutable).getBlock() == RegistryHandler.COLD_FRAME.get()) {

                return true;
            }

        }
        return false;
    }

    public static boolean IsCorruptedFrame(World worldIn, BlockPos pos)
    {
        for (BlockPos blockposMutable :
                BlockPos.getAllInBoxMutable(pos.add(9, 0, 9), pos.add(-9, 0, -9)))
        {
            if(worldIn.getBlockState(blockposMutable).getBlock() == RegistryHandler.CORRUPTED_FRAME.get()) {

                return true;
            }

        }
        return false;
    }

    public static boolean IsMagicalFrame(World worldIn, BlockPos pos)
    {
        for (BlockPos blockposMutable :
                BlockPos.getAllInBoxMutable(pos.add(9, 0, 9), pos.add(-9, 0, -9)))
        {
            if(worldIn.getBlockState(blockposMutable).getBlock() == RegistryHandler.MAGICAL_FRAME.get()) {

                return true;
            }

        }
        return false;
    }

    public static boolean IsBlackFrame(World worldIn, BlockPos pos)
    {
        for (BlockPos blockposMutable :
                BlockPos.getAllInBoxMutable(pos.add(9, 0, 9), pos.add(-9, 0, -9)))
        {
            if(worldIn.getBlockState(blockposMutable).getBlock() == RegistryHandler.BLACK_FRAME.get()) {

                return true;
            }

        }
        return false;
    }

    public static boolean IsLostFrame(World worldIn, BlockPos pos)
    {
        for (BlockPos blockposMutable :
                BlockPos.getAllInBoxMutable(pos.add(9, 0, 9), pos.add(-9, 0, -9)))
        {
            if(worldIn.getBlockState(blockposMutable).getBlock() == RegistryHandler.LOST_FRAME.get()) {

                return true;
            }

        }
        return false;
    }
    public static boolean IsWitherFrame(World worldIn, BlockPos pos)
    {
        for (BlockPos blockposMutable :
                BlockPos.getAllInBoxMutable(pos.add(9, 0, 9), pos.add(-9, 0, -9)))
        {
            if(worldIn.getBlockState(blockposMutable).getBlock() == RegistryHandler.WITHER_FRAME.get()) {

                return true;
            }

        }
        return false;
    }
    public static boolean IsGuardianFrame(World worldIn, BlockPos pos)
    {
        for (BlockPos blockposMutable :
                BlockPos.getAllInBoxMutable(pos.add(9, 0, 9), pos.add(-9, 0, -9)))
        {
            if(worldIn.getBlockState(blockposMutable).getBlock() == RegistryHandler.GUARDIAN_FRAME.get()) {

                return true;
            }

        }
        return false;
    }
    public static boolean IsOreFrame(World worldIn, BlockPos pos)
    {
        for (BlockPos blockposMutable :
                BlockPos.getAllInBoxMutable(pos.add(9, 0, 9), pos.add(-9, 0, -9)))
        {
            if(worldIn.getBlockState(blockposMutable).getBlock() == RegistryHandler.END_CRYSTAL_FRAME.get()) {

                return true;
            }

        }
        return false;
    }


}

