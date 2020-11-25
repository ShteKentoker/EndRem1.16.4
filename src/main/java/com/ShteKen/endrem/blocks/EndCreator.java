package com.ShteKen.endrem.blocks;

import com.ShteKen.endrem.util.DetectPortal;
import com.ShteKen.endrem.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import com.ShteKen.endrem.EndRemastered;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.*;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.common.Mod;

import java.util.stream.Stream;

@Mod.EventBusSubscriber(modid = EndRemastered.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class EndCreator extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(makeCuboidShape(0, 0, 0, 16, 13, 16)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    private static final VoxelShape SHAPE_E = Stream.of(makeCuboidShape(0, 0, 0, 16, 13, 16)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    private static final VoxelShape SHAPE_S = Stream.of(makeCuboidShape(0, 0, 0, 16, 13, 16)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    private static final VoxelShape SHAPE_W = Stream.of(makeCuboidShape(0, 0, 0, 16, 13, 16)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();


    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH: default:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
        }

    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public EndCreator() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(-1f, -1f)
                .sound(SoundType.ANVIL)
                .harvestLevel(-1)
                .harvestTool(ToolType.PICKAXE)


        );
    }

    // Create the portal when all the eyes are placed

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int minX;
        int minZ;

        if (player.getHeldItemMainhand().getItem() == RegistryHandler.POWERED_CORE.get()) {
            if (!worldIn.isRemote) {
                if (DetectPortal.DetectionOfPortal(worldIn, pos)) {

                    Direction NORTH = Direction.NORTH;
                    Direction SOUTH = Direction.SOUTH;
                    Direction WEST = Direction.WEST;
                    Direction EAST= Direction.EAST;

                    switch (state.get(FACING)) {
                        case NORTH:
                            minX = -1;
                            minZ = 1;
                            break;
                        case SOUTH:
                            minX = -1;
                            minZ = -3;
                            break;
                        case EAST:
                            minX = -3;
                            minZ = -1;
                            break;
                        case WEST: default:
                            minX = 1;
                            minZ = -1;
                            break;
                    }

                    for (int x = minX; x <= minX+2 ; x++){
                        for (int z = minZ; z <= minZ+2; z++) {
                            worldIn.setBlockState(pos.add(x, 0, z), Blocks.END_PORTAL.getDefaultState());
                        }
                    }

                    worldIn.setBlockState(pos.add(0, 0, 0), RegistryHandler.END_CREATOR_ACTIVATED.get().getDefaultState());
                    player.getHeldItemMainhand().getStack().shrink(1);

                }
            }

        }
        return ActionResultType.PASS;
    }
}