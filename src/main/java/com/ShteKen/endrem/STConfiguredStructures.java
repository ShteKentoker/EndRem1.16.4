package com.ShteKen.endrem;


import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class STConfiguredStructures {
      public static StructureFeature<?, ?> CONFIGURED_END_CASTLE = STStructures.END_CASTLE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);

      public static void registerConfiguredStructures() {
            Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
            Registry.register(registry, new ResourceLocation(EndRemastered.MOD_ID, "configured_end_castle"), CONFIGURED_END_CASTLE);
            FlatGenerationSettings.STRUCTURES.put(STStructures.END_CASTLE.get(), CONFIGURED_END_CASTLE);
      }
      }
