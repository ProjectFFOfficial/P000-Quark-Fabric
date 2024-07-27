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
import net.projectff.quarkfabric.content.automation.block.ChuteBlock;
import net.projectff.quarkfabric.content.automation.block.EnderWatcherBlock;
import net.projectff.quarkfabric.content.automation.block.GravisandBlock;

public class QuarkBlocks {
    public static final Block GRAVISAND = registerBlockWithItem("gravisand",
            new GravisandBlock(FabricBlockSettings
                    .copy(Blocks.SAND)));
    public static final Block CHUTE = registerBlockWithItem("chute",
            new ChuteBlock(FabricBlockSettings
                    .of().mapColor(MapColor.OAK_TAN)
                    .strength(2.5F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()));
    public static final Block ENDER_WATCHER = registerBlockWithItem("ender_watcher",
            new EnderWatcherBlock(FabricBlockSettings
                    .create().mapColor(MapColor.GREEN)
                    .strength(3f, 10f)
                    .sounds(BlockSoundGroup.METAL)));
    public static Block GRATE;


    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Quark.MOD_ID, name), block);
    }

    private static Block registerBlockWithItem(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Quark.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Quark.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerQuarkBlocks() {
        Quark.LOGGER.debug("[Quark] Registering Blocks");
    }
}
