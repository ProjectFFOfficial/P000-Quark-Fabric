package net.projectff.quarkfabric.registries;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.projectff.quarkfabric.base.Quark;
import net.projectff.quarkfabric.content.automation.entity.Gravisand;

public class QuarkEntities {

    public static final EntityType<Gravisand> GRAVISAND = registerEntityType("gravisand",
            EntityType.Builder.<Gravisand>create(Gravisand::new, SpawnGroup.MISC)
                    .setDimensions(0.98F, 0.98F)
                    .maxTrackingRange(10)
                    .trackingTickInterval(20) // update interval
                    .build());

    public static EntityType registerEntityType(String name, EntityType type) {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(Quark.MOD_ID, name), type);
    }

    public static void registerQuarkEntities() {
        Quark.LOGGER.debug("[Quark] Registering Entities");
    }
}
