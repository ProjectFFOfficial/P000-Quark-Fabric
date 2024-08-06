package net.projectff.quarkfabric.registries;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;
import net.projectff.quarkfabric.base.Quark;
import net.projectff.quarkfabric.internal_zeta.org.ZetaBock;

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
    public static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(Quark.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }
    public static PointOfInterestType registerPointOfInterest(String name, int ticket_count, int search_distance, Block... blocks) {
        return PointOfInterestHelper.register(new Identifier(Quark.MOD_ID, name), ticket_count, search_distance, blocks);
    }
    public static RegistryKey<PointOfInterestType> poiRegistryKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(Quark.MOD_ID, name));
    }
    public static <T extends Entity> EntityType<T> registerEntityType(String name, EntityType<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(Quark.MOD_ID, name), type);
    }
    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntityType(String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Quark.MOD_ID, name), type);
    }
    public static <T extends ScreenHandler> ScreenHandlerType<T> registerScreenHandler(String name, ScreenHandlerType<T> type) {
        return Registry.register(Registries.SCREEN_HANDLER, new Identifier(Quark.MOD_ID, name), type);
    }
    public static void addFlammableZetablock(Block block) {
        if (block instanceof ZetaBock zetaBock) {
            FlammableBlockRegistry.getDefaultInstance().add(zetaBock, zetaBock.getFlammabilityZeta(), zetaBock.getFireSpreadSpeedZeta());
        }
    }
}
