package net.projectff.quarkfabric.internal_zeta;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerAbilities;

public class FabricRaytracingUtil extends RaytracingUtil {
    public FabricRaytracingUtil() {
    }

    @Override
    public double getEntityRange(LivingEntity playerEntity) {
        return MinecraftClient.getInstance().interactionManager.getReachDistance();
    }
}
