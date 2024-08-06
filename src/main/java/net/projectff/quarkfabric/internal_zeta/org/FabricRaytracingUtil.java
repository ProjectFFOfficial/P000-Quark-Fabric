package net.projectff.quarkfabric.internal_zeta.org;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;

public class FabricRaytracingUtil extends RaytracingUtil {
    public FabricRaytracingUtil() {
    }

    @Override
    public double getEntityRange(LivingEntity playerEntity) {
        return MinecraftClient.getInstance().interactionManager.getReachDistance();
    }
}
