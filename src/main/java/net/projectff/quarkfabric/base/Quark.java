package net.projectff.quarkfabric.base;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import net.projectff.quarkfabric.config.QuarkConfigManager;
import net.projectff.quarkfabric.config.QuarkConfigs;
import net.projectff.quarkfabric.content.automation.module.*;
import net.projectff.quarkfabric.internal_zeta.org.FabricZeta;
import net.projectff.quarkfabric.internal_zeta.org.Zeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Quark implements ModInitializer {

	public static final String MOD_ID = "quark";
	public static final String ZETA_INSTANCE_ID = "quark-zeta";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Zeta ZETA = new FabricZeta(MOD_ID, LoggerFactory.getLogger(ZETA_INSTANCE_ID));

	public static Identifier asIdentifier(String name) {
		return new Identifier(Quark.MOD_ID, name);
	}

	@Override
	public void onInitialize() {
        QuarkConfigManager.registerConfigs();

		if (QuarkConfigs.Module.automation) {
			if (QuarkConfigs.Automation.chute) ChuteModule.register();
			if (QuarkConfigs.Automation.enderWatcher) EnderWatcherModule.register();
			if (QuarkConfigs.Automation.gravisand) GravisandModule.register();
			if (QuarkConfigs.Automation.feedingTrough) FeedingTroughModule.register();
			if (QuarkConfigs.Automation.chainsConnectBlocks) ChainsConnectBlocksModule.register();
		}
	}
}