package net.projectff.quarkfabric.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.projectff.quarkfabric.base.Quark;
import net.projectff.quarkfabric.config.QuarkConfigs;
import net.projectff.quarkfabric.internal_zeta.ZetaBock;

public class QuarkRegistries {
    public static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Quark.MOD_ID, name), block);
    }
    public static Block registerBlockWithItem(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Quark.MOD_ID, name), block);
    }
    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Quark.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }
    public static EntityType registerEntityType(String name, EntityType type) {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(Quark.MOD_ID, name), type);
    }
    public static BlockEntityType registerBlockEntityType(String name, BlockEntityType type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Quark.MOD_ID, name), type);
    }
    public static void addFlammableZetablock(Block block) {
        if (block instanceof ZetaBock zetaBock) {
            FlammableBlockRegistry.getDefaultInstance().add(zetaBock, zetaBock.getFlammabilityZeta(), zetaBock.getFireSpreadSpeedZeta());
        }
    }
}