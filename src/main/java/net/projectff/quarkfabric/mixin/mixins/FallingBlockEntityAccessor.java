package net.projectff.quarkfabric.mixin.mixins;

import net.minecraft.block.BlockState;
import net.minecraft.entity.FallingBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(FallingBlockEntity.class)
public interface FallingBlockEntityAccessor {

    @Accessor("block")
    public void setBlockState(BlockState block);
}