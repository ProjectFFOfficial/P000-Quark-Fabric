package net.projectff.quarkfabric.internal_zeta.org;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public interface IConditionalSticky {
    boolean canStickToBlock(World var1, BlockPos var2, BlockPos var3, BlockPos var4, BlockState var5, BlockState var6, Direction var7);
}
