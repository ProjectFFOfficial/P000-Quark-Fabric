package net.projectff.quarkfabric.base;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FallingBlockEntityRenderer;
import net.projectff.quarkfabric.registries.QuarkBlocks;
import net.projectff.quarkfabric.registries.QuarkEntities;

public class QuarkClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(QuarkEntities.GRAVISAND, FallingBlockEntityRenderer::new);

		BlockRenderLayerMap.INSTANCE.putBlock(QuarkBlocks.CHUTE, RenderLayer.getCutoutMipped());
	}
}