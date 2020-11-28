package com.ShteKen.endrem.world.structures;


import com.ShteKen.endrem.EndRemastered;
import com.ShteKen.endrem.STStructures;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class EndCastlePieces {

    private static final ResourceLocation BOTTOM_LEFT = new ResourceLocation(EndRemastered.MOD_ID, "castle_bl");
    private static final ResourceLocation MID_LEFT = new ResourceLocation(EndRemastered.MOD_ID, "castle_ml");
    private static final ResourceLocation TOP_LEFT = new ResourceLocation(EndRemastered.MOD_ID, "castle_tl");
    private static final ResourceLocation BOTTOM_MID = new ResourceLocation(EndRemastered.MOD_ID, "castle_bm");
    private static final ResourceLocation BOTTOM_RIGHT = new ResourceLocation(EndRemastered.MOD_ID, "castle_br");
    public static final ResourceLocation MID_RIGHT = new ResourceLocation(EndRemastered.MOD_ID, "castle_mr");
    public static final ResourceLocation TOP_RIGHT = new ResourceLocation(EndRemastered.MOD_ID, "castle_tr");
    public static final ResourceLocation TOP_MID = new ResourceLocation(EndRemastered.MOD_ID, "castle_tm");
    public static final ResourceLocation MID_MID = new ResourceLocation(EndRemastered.MOD_ID, "castle_mm");
    private static final Map<ResourceLocation, BlockPos> OFFSET = new ImmutableMap.Builder<ResourceLocation, BlockPos>()
            .put(BOTTOM_LEFT, new BlockPos(0, 0, 0))
            .put(MID_LEFT, new BlockPos(0, 0, 0))
            .put(TOP_LEFT, new BlockPos(0, 0, 0))
            .put(BOTTOM_RIGHT, new BlockPos(0, 0, 0))
            .put(BOTTOM_MID, new BlockPos(0, 0, 0))
            .put(MID_RIGHT, new BlockPos(0, 0, 0))
            .put(TOP_RIGHT, new BlockPos(0, 0, 0))
            .put(TOP_MID, new BlockPos(0, 0, 0))
            .put(MID_MID, new BlockPos(0, 0, 0))
            .build();
    /*
     * Begins assembling your structure and where the pieces needs to go.
     */
    public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList, Random random) {
        int x = pos.getX();
        int z = pos.getZ();

        BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockPos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new EndCastlePieces.Piece(templateManager, BOTTOM_LEFT, blockPos, rotation));

        rotationOffSet = new BlockPos(-45, 0, 0).rotate(rotation);
        blockPos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new EndCastlePieces.Piece(templateManager, MID_LEFT, blockPos, rotation));

        rotationOffSet = new BlockPos(-68, 0, 0).rotate(rotation);
        blockPos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new EndCastlePieces.Piece(templateManager, TOP_LEFT, blockPos, rotation));

        rotationOffSet = new BlockPos(  21, 0, -24).rotate(rotation);
        blockPos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new EndCastlePieces.Piece(templateManager, BOTTOM_MID, blockPos, rotation));

        rotationOffSet = new BlockPos(  0, 0, -72).rotate(rotation);
        blockPos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new EndCastlePieces.Piece(templateManager, BOTTOM_RIGHT, blockPos, rotation));

        rotationOffSet = new BlockPos(  -44, 0, -72).rotate(rotation);
        blockPos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new EndCastlePieces.Piece(templateManager, MID_RIGHT, blockPos, rotation));

        rotationOffSet = new BlockPos(  -68, 0, -72).rotate(rotation);
        blockPos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new EndCastlePieces.Piece(templateManager, TOP_RIGHT, blockPos, rotation));

        rotationOffSet = new BlockPos(  -68, 0, -24).rotate(rotation);
        blockPos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new EndCastlePieces.Piece(templateManager, TOP_MID, blockPos, rotation));

        rotationOffSet = new BlockPos(  -20, 0, -24).rotate(rotation);
        blockPos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new EndCastlePieces.Piece(templateManager, MID_MID, blockPos, rotation));

    }

    public static class Piece extends TemplateStructurePiece {
        private ResourceLocation resourceLocation;
        private Rotation rotation;

        public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotationIn) {
            super(STStructures.EC, 0);
            this.resourceLocation = resourceLocationIn;
            BlockPos blockpos = EndCastlePieces.OFFSET.get(resourceLocation);
            this.templatePosition = pos.add(blockpos.getX(), blockpos.getY(), blockpos.getZ());
            this.rotation = rotationIn;
            this.setupPiece(templateManagerIn);
        }
        public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
            super(STStructures.EC, tagCompound);
            this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
            this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
            this.setupPiece(templateManagerIn);
        }
        private void setupPiece(TemplateManager templateManager) {
            Template template = templateManager.getTemplateDefaulted(this.resourceLocation);
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE);
            this.setup(template, this.templatePosition, placementsettings);
        }
        @Override
        protected void readAdditional(CompoundNBT tagCompound) {
            super.readAdditional(tagCompound);
            tagCompound.putString("Template", this.resourceLocation.toString());
            tagCompound.putString("Rot", this.rotation.name());
        }

        @Override
        protected void handleDataMarker(String function, BlockPos pos, IServerWorld worldIn, Random rand, MutableBoundingBox sbb) {

        }
    }
}
