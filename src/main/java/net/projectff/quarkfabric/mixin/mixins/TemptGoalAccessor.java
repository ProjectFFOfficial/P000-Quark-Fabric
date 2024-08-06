package net.projectff.quarkfabric.mixin.mixins;

import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.recipe.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(TemptGoal.class)
public interface TemptGoalAccessor {

    @Accessor("food")
    Ingredient quark$getFood();
}
