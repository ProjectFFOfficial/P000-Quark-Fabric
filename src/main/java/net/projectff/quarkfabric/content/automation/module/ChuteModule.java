package net.projectff.quarkfabric.content.automation.module;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;
import net.projectff.quarkfabric.content.automation.block.ChuteBlock;
import net.projectff.quarkfabric.content.automation.block_entity.ChuteBlockEntity;
import net.projectff.quarkfabric.internal_zeta.org.ZetaModule;
import net.projectff.quarkfabric.registries.QuarkRegistries;

public class ChuteModule extends ZetaModule {
    public static BlockEntityType<ChuteBlockEntity> chuteBlockEntityType;
    public static Block chuteBlock;
    public static final void register() {
        chuteBlock = QuarkRegistries.registerBlockAndItem("chute",
                new ChuteBlock(FabricBlockSettings
                        .of().mapColor(MapColor.OAK_TAN)
                        .strength(2.5F)
                        .sounds(BlockSoundGroup.WOOD)
                        .burnable()));
        chuteBlockEntityType = QuarkRegistries.registerBlockEntityType("chute",
                BlockEntityType.Builder.create(ChuteBlockEntity::new, chuteBlock).build());
        QuarkRegistries.addFlammableZetablock(chuteBlock);
    }
    public static final void registerClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(chuteBlock, RenderLayer.getCutoutMipped());
    }
}
