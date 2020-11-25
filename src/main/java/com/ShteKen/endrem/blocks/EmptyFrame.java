package com.ShteKen.endrem.blocks;


import com.ShteKen.endrem.util.EyeTemplate;
import com.ShteKen.endrem.util.RegistryHandler;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Light;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.stream.Stream;

public class EmptyFrame extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(makeCuboidShape(0, 0, 0, 16, 13, 16)).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(makeCuboidShape(0, 0, 0, 16, 13, 16)).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(makeCuboidShape(0, 0, 0, 16, 13, 16)).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(makeCuboidShape(0, 0, 0, 16, 13, 16)).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();





    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
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

    public EmptyFrame() {
        super(Block.Properties.create(Material.ROCK)
        .harvestTool(ToolType.PICKAXE)
        .harvestLevel(-1)
        .sound(SoundType.ANVIL)
                        .hardnessAndResistance(-1f, -1f)
        );
    }
    // Change the empty frame for one of the 11 frames

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {


        if (player.getHeldItemMainhand().getItem() == RegistryHandler.OLD_PEARL.get()) {
            if (!worldIn.isRemote) {
                if (EyeTemplate.IsOldFrame(worldIn, pos) == false) {

                    worldIn.setBlockState(pos.add(0, 0, 0), RegistryHandler.OLD_FRAME.get().getDefaultState());

                    player.getHeldItemMainhand().getStack().shrink(1);

                }
            }
        }

        else if (player.getHeldItemMainhand().getItem() == RegistryHandler.ROGUE_PEARL.get()) {
            if (!worldIn.isRemote) {
                if (EyeTemplate.IsRogueFrame(worldIn, pos) == false) {


                    worldIn.setBlockState(pos.add(0, 0, 0), RegistryHandler.ROGUE_FRAME.get().getDefaultState());

                    player.getHeldItemMainhand().getStack().shrink(1);
                }
            }

        }
        else if (player.getHeldItemMainhand().getItem() == RegistryHandler.NETHER_PEARL.get()) {
            if (!worldIn.isRemote) {
                if (EyeTemplate.IsNetherFrame(worldIn, pos) == false) {


                    worldIn.setBlockState(pos.add(0, 0, 0), RegistryHandler.NETHER_FRAME.get().getDefaultState());

                    player.getHeldItemMainhand().getStack().shrink(1);
                }
            }

        }
        else if (player.getHeldItemMainhand().getItem() == RegistryHandler.CORRUPTED_PEARL.get()) {
            if (!worldIn.isRemote) {
                if (EyeTemplate.IsCorruptedFrame(worldIn, pos) == false) {


                    worldIn.setBlockState(pos.add(0, 0, 0), RegistryHandler.CORRUPTED_FRAME.get().getDefaultState());

                    player.getHeldItemMainhand().getStack().shrink(1);
                }
            }

        }
        else if (player.getHeldItemMainhand().getItem() == RegistryHandler.COLD_PEARL.get()) {
            if (!worldIn.isRemote) {
                if (EyeTemplate.IsColdFrame(worldIn, pos) == false) {


                    worldIn.setBlockState(pos.add(0, 0, 0), RegistryHandler.COLD_FRAME.get().getDefaultState());

                    player.getHeldItemMainhand().getStack().shrink(1);
                }
            }

        }
        else if (player.getHeldItemMainhand().getItem() == RegistryHandler.MAGICAL_PEARL.get()) {
            if (!worldIn.isRemote) {
                if (EyeTemplate.IsMagicalFrame(worldIn, pos) == false) {


                    worldIn.setBlockState(pos.add(0, 0, 0), RegistryHandler.MAGICAL_FRAME.get().getDefaultState());

                    player.getHeldItemMainhand().getStack().shrink(1);
                }
            }

        }
        else if (player.getHeldItemMainhand().getItem() == RegistryHandler.BLACK_PEARL.get()) {
            if (!worldIn.isRemote) {
                if (EyeTemplate.IsBlackFrame(worldIn, pos) == false) {


                    worldIn.setBlockState(pos.add(0, 0, 0), RegistryHandler.BLACK_FRAME.get().getDefaultState());

                    player.getHeldItemMainhand().getStack().shrink(1);
                }
            }

        }
        else if (player.getHeldItemMainhand().getItem() == RegistryHandler.LOST_PEARL.get()) {
            if (!worldIn.isRemote) {
                if (EyeTemplate.IsLostFrame(worldIn, pos) == false) {


                    worldIn.setBlockState(pos.add(0, 0, 0), RegistryHandler.LOST_FRAME.get().getDefaultState());

                    player.getHeldItemMainhand().getStack().shrink(1);

                }
            }

        }
        else if (player.getHeldItemMainhand().getItem() == RegistryHandler.WITHER_PEARL.get()) {
            if (!worldIn.isRemote) {
                if (EyeTemplate.IsWitherFrame(worldIn, pos) == false) {


                    worldIn.setBlockState(pos.add(0, 0, 0), RegistryHandler.WITHER_FRAME.get().getDefaultState());

                    player.getHeldItemMainhand().getStack().shrink(1);

                }
            }

        }
        else if (player.getHeldItemMainhand().getItem() == RegistryHandler.GUARDIAN_PEARL.get()) {
            if (!worldIn.isRemote) {
                if (EyeTemplate.IsGuardianFrame(worldIn, pos) == false) {


                    worldIn.setBlockState(pos.add(0, 0, 0), RegistryHandler.GUARDIAN_FRAME.get().getDefaultState());

                    player.getHeldItemMainhand().getStack().shrink(1);

                }
            }

        }
        else if (player.getHeldItemMainhand().getItem() == RegistryHandler.END_CRYSTAL_PEARL.get()) {
            if (!worldIn.isRemote) {
                if (EyeTemplate.IsOreFrame(worldIn, pos) == false) {


                    worldIn.setBlockState(pos.add(0, 0, 0), RegistryHandler.END_CRYSTAL_FRAME.get().getDefaultState());

                    player.getHeldItemMainhand().getStack().shrink(1);

                }
            }

        }

        return ActionResultType.PASS;

    }

}


