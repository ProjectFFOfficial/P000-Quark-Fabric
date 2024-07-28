package net.projectff.quarkfabric.base;

import net.fabricmc.api.ModInitializer;

import net.projectff.quarkfabric.config.QuarkConfigs;
import net.projectff.quarkfabric.content.automation.module.ChuteModule;
import net.projectff.quarkfabric.content.automation.module.EnderWatcherModule;
import net.projectff.quarkfabric.content.automation.module.GravisandModule;
import net.projectff.quarkfabric.internal_zeta.FabricZeta;
import net.projectff.quarkfabric.internal_zeta.Zeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Quark implements ModInitializer {

	public static final String MOD_ID = "quark";
	public static final String ZETA_INSTANCE_ID = "quark-zeta";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Zeta ZETA = new FabricZeta(MOD_ID, LoggerFactory.getLogger(ZETA_INSTANCE_ID));

	@Override
	public void onInitialize() {
        QuarkConfigs.registerConfigs();

		if (QuarkConfigs.module_automation) {
			if (QuarkConfigs.automation_Chute) ChuteModule.register();
			if (QuarkConfigs.automation_EnderWatcher) EnderWatcherModule.register();
			if (QuarkConfigs.automation_Gravisand) GravisandModule.register();
		}
	}
}