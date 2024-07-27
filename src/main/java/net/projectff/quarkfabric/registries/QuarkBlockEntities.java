package net.projectff.quarkfabric.registries;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.projectff.quarkfabric.base.Quark;
import net.projectff.quarkfabric.content.automation.block_entity.ChuteBlockEntity;
import net.projectff.quarkfabric.content.automation.block_entity.EnderWatcherBlockEntity;

public class QuarkBlockEntities {

    public static final BlockEntityType<EnderWatcherBlockEntity> ENDER_WATCHER = registerBlockEntityType("ender_watcher",
            FabricBlockEntityTypeBuilder.create(EnderWatcherBlockEntity::new, QuarkBlocks.ENDER_WATCHER).build());
    public static final BlockEntityType<ChuteBlockEntity> CHUTE = registerBlockEntityType("chute",
            FabricBlockEntityTypeBuilder.create(ChuteBlockEntity::new, QuarkBlocks.CHUTE).build());

    public static BlockEntityType registerBlockEntityType(String name, BlockEntityType type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Quark.MOD_ID, name), type);
    }

    public static void registerQuarkBlockEntities() {
        Quark.LOGGER.debug("[Quark] Registering BlockEntities");
    }
}
