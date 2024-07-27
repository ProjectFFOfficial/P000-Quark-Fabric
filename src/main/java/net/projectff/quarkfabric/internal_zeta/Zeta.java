package net.projectff.quarkfabric.internal_zeta;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.slf4j.Logger;

public abstract class Zeta {
    public String id;
    public Logger logger;

    public RaytracingUtil raytracingUtil;
    public ItemExtensionFactory itemExtensions;

    public Zeta(String id, Logger logger) {
        this.id = id;
        this.logger = logger;

        this.raytracingUtil = this.createRayTracingUtil();
        this.itemExtensions = this.createItemExtensions();
    }

    public abstract ItemExtensionFactory createItemExtensions();

    public abstract RaytracingUtil createRayTracingUtil();
}
