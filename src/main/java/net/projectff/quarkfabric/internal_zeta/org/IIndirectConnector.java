package net.projectff.quarkfabric.internal_zeta.org;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Pair;


import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public interface IIndirectConnector {
    List<Pair<Predicate<BlockState>, IIndirectConnector>> INDIRECT_STICKY_BLOCKS = new LinkedList<>();

    default boolean isEnabled() {
        return true;
    }

    default IConditionalSticky getStickyCondition() {
        return (w, pp, op, sp, os, ss, d) -> this.canConnectIndirectly(w, op, sp, os, ss);
    }
    boolean canConnectIndirectly(World var1, BlockPos var2, BlockPos var3, BlockState var4, BlockState var5);
}
