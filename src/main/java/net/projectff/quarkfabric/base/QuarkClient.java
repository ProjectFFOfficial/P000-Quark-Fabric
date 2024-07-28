package net.projectff.quarkfabric.base;

import net.fabricmc.api.ClientModInitializer;
import net.projectff.quarkfabric.config.QuarkConfigs;
import net.projectff.quarkfabric.content.automation.module.ChuteModule;
import net.projectff.quarkfabric.content.automation.module.GravisandModule;

public class QuarkClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		if (QuarkConfigs.module_automation) {
			if (QuarkConfigs.automation_Chute) ChuteModule.registerClient();
			if (QuarkConfigs.automation_Gravisand) GravisandModule.registerClient();
		}
	}
}