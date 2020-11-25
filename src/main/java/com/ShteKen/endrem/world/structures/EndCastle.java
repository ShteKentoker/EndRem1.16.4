package com.ShteKen.endrem.world.structures;

import com.ShteKen.endrem.EndRemastered;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;
import org.apache.logging.log4j.Level;

import java.util.List;


public class EndCastle extends Structure<NoFeatureConfig> implements EndCastle2 {
    public EndCastle(Codec<NoFeatureConfig> codec)  {
        super(codec);
    }

//    @Override
 //   public String getStructureName() {
  //    return EndRemastered.MOD_ID + ":end_castle";
  //  }


    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return EndCastle.Start::new;
    }

    @Override
    public GenerationStage.Decoration func_236396_f_() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }

//    private static final List<MobSpawnInfo.Spawners> STRUCTURE_CREATURES = ImmutableList.of(
//            new MobSpawnInfo.Spawners(EntityType.VILLAGER, 30, 10, 15));
//    @Override
//    public List<MobSpawnInfo.Spawners> getDefaultCreatureSpawnList() {
//        return STRUCTURE_CREATURES;
//    }


    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int refecrenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, refecrenceIn, seedIn);
        }

        @Override
        public void func_230364_a_(DynamicRegistries dynamicRegistryManager, ChunkGenerator generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig config) {
            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];

            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;

            int surfaceY = generator.getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
            BlockPos blockpos = new BlockPos(x, surfaceY, z);

            EndCastlePieces.start(templateManagerIn, blockpos, rotation, this.components, this.rand);

            this.recalculateStructureSize();

            EndRemastered.LOGGER.log(Level.DEBUG, "EndCastle at " + (blockpos.getX()) + " " + blockpos.getY() + " " + (blockpos.getZ()));

        }
    }


}