package com.ShteKen.endrem;



import com.ShteKen.endrem.world.structures.EndCastle;
import com.ShteKen.endrem.world.structures.EndCastlePieces;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.event.RegistryEvent.Register;

public class STStructure {


    public static Structure<NoFeatureConfig> END_CASTLE = new EndCastle(NoFeatureConfig.field_236558_a_);
    public static IStructurePieceType ENDC = EndCastlePieces.Piece::new;

    public static void registerStructure(Register<Structure<?>> event) {

        EndRemastered.register(event.getRegistry(), END_CASTLE, "run_down_house");

        registerStructure(
                END_CASTLE,
                new StructureSeparationSettings(27, 20, 958739948),true);

        STStructure.registerAllPieces();

    }

    public static <F extends Structure<?>> void registerStructure(
            F structure, StructureSeparationSettings structureSeparationSettings,
            boolean transformSurroundingLand)
    {

        Structure.NAME_STRUCTURE_BIMAP.put(structure.getRegistryName().toString(), structure);

        // create blocks under structure like villages

        if (transformSurroundingLand) {
            Structure.field_236384_t_ =
                    ImmutableList.<Structure<?>>builder()
                            .addAll(Structure.field_236384_t_)
                            .add(structure)
                            .build();

    }
        Structure.NAME_STRUCTURE_BIMAP.put(structure.getRegistryName().toString(), structure);

        DimensionStructuresSettings.field_236191_b_ =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.field_236191_b_)
                        .put(structure, structureSeparationSettings)
                        .build();
    }

    public static void registerAllPieces() {
        registerStructurePiece(ENDC, new ResourceLocation(EndRemastered.MOD_ID, "endc"));
    }


    static void registerStructurePiece(IStructurePieceType structurePiece, ResourceLocation en) {
        Registry.register(Registry.STRUCTURE_PIECE, en, structurePiece);
    }

}
