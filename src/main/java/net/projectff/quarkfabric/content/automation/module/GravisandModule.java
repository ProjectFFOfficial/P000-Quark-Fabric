package net.projectff.quarkfabric.content.automation.module;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.entity.FallingBlockEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.projectff.quarkfabric.content.automation.block.GravisandBlock;
import net.projectff.quarkfabric.content.automation.entity.Gravisand;
import net.projectff.quarkfabric.internal_zeta.org.ZetaModule;
import net.projectff.quarkfabric.registries.QuarkRegistries;

public class GravisandModule extends ZetaModule {
    public static EntityType<Gravisand> gravisandEntityType;
    public static Block gravisandBlock;
    public static final void register() {
        gravisandBlock = QuarkRegistries.registerBlockAndItem("gravisand",
                new GravisandBlock(FabricBlockSettings
                        .copy(Blocks.SAND)));
        gravisandEntityType = QuarkRegistries.registerEntityType("gravisand",
                EntityType.Builder.<Gravisand>create(Gravisand::new, SpawnGroup.MISC)
                        .setDimensions(0.98F, 0.98F)
                        .maxTrackingRange(10)
                        .trackingTickInterval(20) // update interval
                        .build());
        QuarkRegistries.addFlammableZetablock(gravisandBlock);
    }
    public static final void registerClient() {
        EntityRendererRegistry.register(gravisandEntityType, FallingBlockEntityRenderer::new);
    }
}
