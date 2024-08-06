package net.projectff.quarkfabric.mixin.mixins;

import net.minecraft.entity.ai.brain.sensor.TemptationsSensor;
import net.minecraft.recipe.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(TemptationsSensor.class)
public interface TemptationsSensorAccessor {

    @Accessor("ingredient")
    Ingredient quark$getIngredient();
}
