package net.projectff.quarkfabric.content.automation.module;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.gui.screen.ingame.Generic3x3ContainerScreen;
import net.minecraft.screen.Generic3x3ContainerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.projectff.quarkfabric.config.QuarkConfigManager;
import net.projectff.quarkfabric.config.QuarkConfigs;
import net.projectff.quarkfabric.content.automation.block_entity.FeedingTroughBlockEntity;
import net.projectff.quarkfabric.internal_zeta.org.ZetaModule;

public class FeedingTroughModule extends ZetaModule {

    // configs
    public static int cooldown = QuarkConfigs.Automation.FeedingThrough.cooldown;
    public static int maxAnimals = QuarkConfigs.Automation.FeedingThrough.maxAnimals;
    public static double loveChance = QuarkConfigs.Automation.FeedingThrough.loveChance;
    public static double range = QuarkConfigs.Automation.FeedingThrough.range;
    public static double lookChance = QuarkConfigs.Automation.FeedingThrough.lookChance;


    public static ScreenHandlerType<Generic3x3ContainerScreenHandler> screenHandlerType;
    public static Block feedingTroughBlock;
    public static BlockEntityType<FeedingTroughBlockEntity> feedingTroughBlockEntityType;

    public static final void register() {
    }
    public static final void registerClient() {

    }
}
