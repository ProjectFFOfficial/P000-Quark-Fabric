package net.projectff.quarkfabric.mixin.mixins.zeta;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.PistonBlock;
import net.minecraft.block.piston.PistonHandler;
import net.projectff.quarkfabric.internal_zeta.org.ZetaPistonStructureResolver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PistonBlock.class)
public abstract class PistonBlockMixin { /**Note from ProjectF>F: UNUSED*/
    /*
    @ModifyExpressionValue(
            method = {"tryMove", "move"},
            at = {@At(
                    value = "NEW",
                    target = "(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/Direction;Z)Lnet/minecraft/block/piston/PistonHandler;")}
    )
    private PistonHandler transformStructureHelper(PistonHandler prev) {
        return new ZetaPistonStructureResolver(prev);
    }
    */

    @Unique
    private void unused() {
    }
}
