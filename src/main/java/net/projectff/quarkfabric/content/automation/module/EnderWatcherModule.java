package net.projectff.quarkfabric.content.automation.module;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.projectff.quarkfabric.content.automation.block.EnderWatcherBlock;
import net.projectff.quarkfabric.content.automation.block_entity.EnderWatcherBlockEntity;
import net.projectff.quarkfabric.internal_zeta.ZetaModule;
import net.projectff.quarkfabric.registries.QuarkBlocks;
import net.projectff.quarkfabric.registries.QuarkRegistries;

public class EnderWatcherModule extends ZetaModule {
    public static BlockEntityType<EnderWatcherBlockEntity> enderWatcherBlockEntityType;
    public static Block enderWatcherBlock;
    public static final void register() {
        enderWatcherBlock = QuarkRegistries.registerBlockWithItem("ender_watcher",
                new EnderWatcherBlock(FabricBlockSettings
                        .create().mapColor(MapColor.GREEN)
                        .strength(3f, 10f)
                        .sounds(BlockSoundGroup.METAL)));
        enderWatcherBlockEntityType = QuarkRegistries.registerBlockEntityType("ender_watcher",
                FabricBlockEntityTypeBuilder.create(EnderWatcherBlockEntity::new, enderWatcherBlock).build());
    }
}
