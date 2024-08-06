package net.projectff.quarkfabric.mixin.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.BlockState;
import net.minecraft.block.piston.PistonHandler;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.projectff.quarkfabric.content.automation.module.ChainsConnectBlocksModule;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PistonHandler.class)
public abstract class PistonHandlerMixin {

    @Shadow
    protected abstract boolean tryMove(BlockPos pos, Direction dir);
    @Final
    @Shadow
    private World world;
    @Shadow
    private static boolean isBlockSticky(BlockState state) {
        throw new AssertionError();
    }

    /**Note from ProjectF>F: Own implementation for chain linkage*/
    @Redirect(method = "calculatePush", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/piston/PistonHandler;isBlockSticky(Lnet/minecraft/block/BlockState;)Z"))
    private boolean alwaysTrue0(BlockState state) {
        if (ChainsConnectBlocksModule.isEnabled) return true;
        else return isBlockSticky(state);
    }

    @Redirect(method = "tryMove", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/piston/PistonHandler;isBlockSticky(Lnet/minecraft/block/BlockState;)Z"))
    private boolean alwaysTrue1(BlockState state) {
        if (ChainsConnectBlocksModule.isEnabled) return true;
        else return isBlockSticky(state);
    }
    @Inject(method = "tryMoveAdjacentBlock", at = @At(value = "HEAD"), cancellable = true)
    private void tryMoveChainLinkedStuff(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (ChainsConnectBlocksModule.isEnabled) {
            for (Direction direction1 : Direction.values()) {
                BlockPos pos0 = pos.offset(direction1);

                BlockState blockState0 = world.getBlockState(pos0);
                BlockState blockState = world.getBlockState(pos);

                boolean isChain0 = ChainsConnectBlocksModule.isStateChainBlock(blockState0);
                boolean isChain = ChainsConnectBlocksModule.isStateChainBlock(blockState);

                Direction.Axis axis0 = isChain0 ? world.getBlockState(pos0).get(Properties.AXIS) : null;
                Direction.Axis axis = isChain ? world.getBlockState(pos).get(Properties.AXIS) : null;

                boolean axisMatch0 = axis0 == direction1.getAxis();
                boolean axisMatch = axis == direction1.getAxis();

                boolean chainLinkageCheck = isChain && axis == axis0 && axis0 != null;
                if ((axisMatch0 && chainLinkageCheck) || (isChain && !isChain0 && axisMatch) || (!isChain && isChain0 && axisMatch0)) {
                    if (!tryMove(pos0, direction1)) cir.setReturnValue(false);
                }
            }
            if (!isBlockSticky(world.getBlockState(pos))) cir.setReturnValue(true);
        }
    }

    @WrapOperation(method = "tryMoveAdjacentBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/piston/PistonHandler;tryMove(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/Direction;)Z"))
    private boolean ignoreChainUnlessConnected(PistonHandler instance, BlockPos pos, Direction dir, Operation<Boolean> original) {
        if (ChainsConnectBlocksModule.isEnabled) {
            if (ChainsConnectBlocksModule.isStateChainBlock(world.getBlockState(pos)) && world.getBlockState(pos).get(Properties.AXIS) != dir.getAxis()) {
                return true;
            }
        }
        return original.call(instance, pos, dir);
    }
}
