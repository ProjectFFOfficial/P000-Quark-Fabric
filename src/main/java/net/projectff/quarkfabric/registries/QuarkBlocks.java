package net.projectff.quarkfabric.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.projectff.quarkfabric.base.Quark;
import net.projectff.quarkfabric.config.QuarkConfigProvider;
import net.projectff.quarkfabric.config.QuarkConfigs;
import net.projectff.quarkfabric.content.automation.block.ChuteBlock;
import net.projectff.quarkfabric.content.automation.block.EnderWatcherBlock;
import net.projectff.quarkfabric.content.automation.block.GravisandBlock;

public class QuarkBlocks {
    public static Block CHUTE;
    public static Block ENDER_WATCHER;
    public static Block GRAVISAND;
    public static Block GRATE;
}
