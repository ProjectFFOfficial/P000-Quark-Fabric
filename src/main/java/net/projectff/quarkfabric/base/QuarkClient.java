package net.projectff.quarkfabric.base;

import net.fabricmc.api.ClientModInitializer;
import net.projectff.quarkfabric.config.QuarkConfigs;
import net.projectff.quarkfabric.content.automation.module.ChuteModule;
import net.projectff.quarkfabric.content.automation.module.EnderWatcherModule;
import net.projectff.quarkfabric.content.automation.module.FeedingTroughModule;
import net.projectff.quarkfabric.content.automation.module.GravisandModule;

public class QuarkClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		if (QuarkConfigs.Module.automation) {
			if (QuarkConfigs.Automation.chute) ChuteModule.registerClient();
			if (QuarkConfigs.Automation.enderWatcher) EnderWatcherModule.registerClient();
			if (QuarkConfigs.Automation.gravisand) GravisandModule.registerClient();
			if (QuarkConfigs.Automation.feedingTrough) FeedingTroughModule.registerClient();
		}
	}
}