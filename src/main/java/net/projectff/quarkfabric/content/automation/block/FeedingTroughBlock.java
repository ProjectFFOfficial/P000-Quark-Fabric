package net.projectff.quarkfabric.content.automation.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.projectff.quarkfabric.content.automation.block_entity.FeedingTroughBlockEntity;
import net.projectff.quarkfabric.internal_zeta.org.ZetaBock;
import org.jetbrains.annotations.Nullable;

public class FeedingTroughBlock extends ZetaBock implements BlockEntityProvider {

    private static final BlockSoundGroup WOOD_WITH_PLANT_STEP = new BlockSoundGroup(1.0F, 1.0F, SoundEvents.BLOCK_WOOD_BREAK, SoundEvents.BLOCK_GRASS_STEP, SoundEvents.BLOCK_WOOD_PLACE, SoundEvents.BLOCK_WOOD_HIT, SoundEvents.BLOCK_WOOD_FALL);

    public static final BooleanProperty FULL = BooleanProperty.of("full");

    public static final VoxelShape CUBOID_SHAPE = createCuboidShape(0, 0, 0, 16, 8, 16);
    public static final VoxelShape EMPTY_SHAPE = VoxelShapes.combineAndSimplify(CUBOID_SHAPE, createCuboidShape(2, 2, 2, 14, 8, 14), BooleanBiFunction.ONLY_FIRST);
    public static final VoxelShape FULL_SHAPE = VoxelShapes.combineAndSimplify(CUBOID_SHAPE, createCuboidShape(2, 6, 2, 14, 8, 14), BooleanBiFunction.ONLY_FIRST);
    public static final VoxelShape ANIMAL_SHAPE = createCuboidShape(0, 0, 0, 16, 24, 16);

    public FeedingTroughBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(FULL, false));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Entity entity = context instanceof EntityShapeContext esc ? esc.getEntity() : null;
        if (entity instanceof AnimalEntity) return ANIMAL_SHAPE;
        return EMPTY_SHAPE;
    }

    @Override
    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return CUBOID_SHAPE;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(FULL) ? FULL_SHAPE : EMPTY_SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FULL);
    }

    @Override
    public BlockSoundGroup getSoundGroup(BlockState state) {
        if (state.get(FULL)) return WOOD_WITH_PLANT_STEP;
        return super.getSoundGroup(state);
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (world.getBlockState(pos).get(FULL)) {
            entity.handleFallDamage(fallDistance, 0.2f, world.getDamageSources().fall());
        } else super.onLandedUpon(world, state, pos, entity, fallDistance);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity tile = world.getBlockEntity(pos);
            if(tile instanceof FeedingTroughBlockEntity f) {
                ItemScatterer.spawn(world, pos, f);
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient)
            return ActionResult.SUCCESS;
        else {
            NamedScreenHandlerFactory container = this.createScreenHandlerFactory(state, world, pos);
            if(container != null)
                player.openHandledScreen(container);

            return ActionResult.CONSUME;
        }
    }

    @Override
    public boolean onSyncedBlockEvent(BlockState state, World world, BlockPos pos, int type, int data) {
        super.onSyncedBlockEvent(state, world, pos, type, data);

        BlockEntity tile = world.getBlockEntity(pos);
        return tile != null && tile.onSyncedBlockEvent(type, data);
    }

    @Override
    public @Nullable NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        BlockEntity tile = world.getBlockEntity(pos);
        return tile instanceof NamedScreenHandlerFactory m ? m : null;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FeedingTroughBlockEntity(pos, state);
    }
}
