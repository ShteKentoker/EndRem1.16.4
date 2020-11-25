package com.ShteKen.endrem.blocks;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nonnull;
import java.util.Random;

public class OreBlockBase extends OreBlock {
    public OreBlockBase(Properties properties) {
        super(properties);
    }

    // add experience when the oreBlock breaks
    @Override
    protected int getExperience(@Nonnull Random rand) { return MathHelper.nextInt(rand, 10, 20); }
}