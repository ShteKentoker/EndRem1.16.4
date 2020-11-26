package com.ShteKen.endrem;


import com.ShteKen.endrem.world.structures.EndCastle;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class STStructures {

    public static final DeferredRegister<Structure<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, EndRemastered.MOD_ID);

    public static final RegistryObject<Structure<NoFeatureConfig>> END_CASTLE = setupStructure("end_castle", () -> (new EndCastle(NoFeatureConfig.field_236558_a_)));

    private static <T extends Structure<?>> RegistryObject<T> setupStructure(String name, Supplier<T> structure) {
        return DEFERRED_REGISTRY_STRUCTURE.register(name, structure);
    }
    public static void setupStructures() {
        setupStructure(
                END_CASTLE.get(), new StructureSeparationSettings(27, 20, 980547698), true);
    }
    public static <F extends Structure<?>> void setupStructure(
            F structure, StructureSeparationSettings structureSeparationSettings,
            boolean transformSurroundingLands) {

        Structure.NAME_STRUCTURE_BIMAP.put(structure.getRegistryName().toString(), structure);

        if(transformSurroundingLands){
            Structure.field_236384_t_ =
                    ImmutableList.<Structure<?>>builder()
                            .addAll(Structure.field_236384_t_)
                            .add(structure)
                            .build();
        }
        DimensionStructuresSettings.field_236191_b_ =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.field_236191_b_)
                        .put(structure, structureSeparationSettings)
                        .build();
    }
}
