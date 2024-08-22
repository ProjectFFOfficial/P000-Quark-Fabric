package net.projectff.quarkfabric.content.automation.module;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChainBlock;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.projectff.quarkfabric.internal_zeta.org.IIndirectConnector;
import net.projectff.quarkfabric.internal_zeta.org.ZetaModule;
import org.apache.commons.lang3.tuple.Pair;

import java.util.function.Predicate;

public class ChainsConnectBlocksModule extends ZetaModule {

    /**Note from ProjectF>F: unused for some reason*/
    Item chain = Items.CHAIN;
    public static boolean isEnabled = false;

    public static final void register() {
        isEnabled = true;
    }


    /*
    public static class ChainConnection implements IIndirectConnector {

        public static ChainConnection INSTANCE = new ChainConnection();
        public static Predicate<BlockState> PREDICATE = state -> state.getBlock() == Blocks.CHAIN;

        @Override
        public boolean isEnabled() {
            return ChainsConnectBlocksModule.isEnabled;
        }

        @Override
        public boolean canConnectIndirectly(World world, BlockPos ourPos, BlockPos sourcePos, BlockState ourState, BlockState sourceState) {
            Direction.Axis axis = ourState.get(ChainBlock.AXIS);

            switch(axis) {
                case X:
                    if(ourPos.getX() == sourcePos.getX())
                        return false;
                    break;
                case Y:
                    if(ourPos.getY() == sourcePos.getY())
                        return false;
                    break;
                case Z:
                    if(ourPos.getZ() == sourcePos.getZ())
                        return false;
            }

            if(sourceState.getBlock() == ourState.getBlock()) {
                Direction.Axis otherAxis = sourceState.get(ChainBlock.AXIS);
                return axis == otherAxis;
            }

            return true;
        }
    }*/
    /**Note from ProjectF>F: might add custom tag check for chain-like linking blocks (from other mods) here int the future*/
    public static boolean isStateChainBlock(BlockState state) {
        return state.isOf(Blocks.CHAIN);
    }
}
