package net.projectff.quarkfabric.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.projectff.quarkfabric.base.Quark;
import net.projectff.quarkfabric.internal_zeta.ZetaBock;

import java.util.Optional;

public class QuarkRegistries {
    public static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Quark.MOD_ID, name), block);
    }
    public static Block registerBlockAndItem(String name, Block block) {
        registerBlockItem(name, block);
        return registerBlock(name, block);
    }
    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Quark.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }
    public static <T extends Entity> EntityType registerEntityType(String name, EntityType<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(Quark.MOD_ID, name), type);
    }
    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntityType(String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Quark.MOD_ID, name), type);
    }
    public static <T> T registerAnything(String name, T obj, Optional<Mode> mode) {
        if (obj instanceof Block block) {
            if (mode.isPresent()) {
                if (mode.get() == Mode.BLOCK) registerBlock(name, block);
                if (mode.get() == Mode.BLOCK_AND_ITEM) registerBlockAndItem(name, block);
                if (mode.get() == Mode.BLOCKITEM) registerBlockItem(name, block);
            }
            registerBlock(name, block);
        }
        if (obj instanceof EntityType<?> entityType) registerEntityType(name, entityType);
        if (obj instanceof BlockEntityType<?> blockEntityType) registerBlockEntityType(name, blockEntityType);
        return obj;
    }

    public enum Mode {
        BLOCK, BLOCK_AND_ITEM, BLOCKITEM
    }

    public static void addFlammableZetablock(Block block) {
        if (block instanceof ZetaBock zetaBock) {
            FlammableBlockRegistry.getDefaultInstance().add(zetaBock, zetaBock.getFlammabilityZeta(), zetaBock.getFireSpreadSpeedZeta());
        }
    }
}
