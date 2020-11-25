package com.ShteKen.endrem;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class STConfiguredStructures {

    public static StructureFeature<?, ?> CONFIGURED_END_CASTLE = STStructure.END_CASTLE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);

    public static void registerConfiguredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;

        FlatGenerationSettings.STRUCTURES.put(STStructure.END_CASTLE, CONFIGURED_END_CASTLE);
    }
}
