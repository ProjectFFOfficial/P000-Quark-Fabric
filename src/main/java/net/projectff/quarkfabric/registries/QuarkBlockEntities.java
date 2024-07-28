package net.projectff.quarkfabric.registries;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.projectff.quarkfabric.base.Quark;
import net.projectff.quarkfabric.config.QuarkConfigs;
import net.projectff.quarkfabric.content.automation.block_entity.ChuteBlockEntity;
import net.projectff.quarkfabric.content.automation.block_entity.EnderWatcherBlockEntity;

public class QuarkBlockEntities {
    public static BlockEntityType<ChuteBlockEntity> CHUTE;
    public static BlockEntityType<EnderWatcherBlockEntity> ENDER_WATCHER;
}
