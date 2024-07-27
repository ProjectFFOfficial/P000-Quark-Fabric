package net.projectff.quarkfabric.base;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.projectff.quarkfabric.registries.QuarkBlockEntities;
import net.projectff.quarkfabric.registries.QuarkBlocks;
import net.projectff.quarkfabric.registries.QuarkEntities;
import net.projectff.quarkfabric.internal_zeta.FabricZeta;
import net.projectff.quarkfabric.internal_zeta.Zeta;
import net.projectff.quarkfabric.internal_zeta.ZetaBock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Quark implements ModInitializer {

	public static final String MOD_ID = "quark";
	public static final String ZETA_INSTANCE_ID = "quark-zeta";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Zeta ZETA = new FabricZeta(MOD_ID, LoggerFactory.getLogger(ZETA_INSTANCE_ID));

	@Override
	public void onInitialize() {
		QuarkBlocks.registerQuarkBlocks();
		QuarkBlockEntities.registerQuarkBlockEntities();
		QuarkEntities.registerQuarkEntities();

		registerFlammableBlocks();
	}
	public static void registerFlammableBlocks() {
		addFlammableZetablock(QuarkBlocks.CHUTE);

	}
	public static void addFlammableZetablock(Block block) {
		if (block instanceof ZetaBock zetaBock) {
			FlammableBlockRegistry.getDefaultInstance().add(zetaBock, zetaBock.getFlammabilityZeta(), zetaBock.getFireSpreadSpeedZeta());
		}
	}
}