package net.projectff.quarkfabric.config;

import net.projectff.quarkfabric.base.Quark;

public class QuarkConfigs {
    private static SimpleConfigAPI configs;
    public static QuarkConfigProvider configProvider;

    // modules
    public static boolean module_automation = false;
    public static boolean module_building = false;
    public static boolean module_client = false;
    public static boolean module_decoration = false;
    public static boolean module_experimental = false;
    public static boolean module_management = false;
    public static boolean module_misc = false;
    public static boolean module_oddities = false;
    public static boolean module_tweaks = false;
    public static boolean module_vanity = false;
    public static boolean module_world = false;

    //automation
    public static boolean automation_AnimalsEatFloorFood = false; // "Animals eat floor food"
    public static boolean automation_ChainLinkage = false; // "Chain linkage"
    public static boolean automation_Chute = false; // Chute
    public static boolean automation_ColorSlime = false; // "Color slime"
    public static boolean automation_DispenserRecords = false; // "Dispenser records"
    public static boolean automation_DispensersPlaceBlocks = false; // "Dispensers place blocks"
    public static boolean automation_DispensersPlaceSeeds = false; // "Dispensers place seeds"
    public static boolean automation_EnderWatcher = false; // "Ender watcher"
    public static boolean automation_Gravisand = false; // Gravisand
    public static boolean automation_MetalButtons = false; // "Metal buttons"
    public static boolean automation_ObsidianPressurePlate = false; // "Obsidian pressure plate"
    public static boolean automation_PistonBlockBreakers = false; // "Piston Block Breakers"
    public static boolean automation_PistonsPushAndPullItems = false; // "Pistons Push and Pull Items"
    public static boolean automation_PistonsMoveTEs = false; // "Pistons move t es"
    public static boolean automation_RainDetector = false; // "Rain detector"
    public static boolean automation_RedstoneInductor = false; // "Redstone inductor"
    public static boolean automation_RedstoneRandomizer = false; // "Redstone randomizer"
    public static boolean automation_SugarBlock = false; // "Sugar block"

    public static void registerConfigs() {
        configProvider = new QuarkConfigProvider();
        createConfigs();

        configs = SimpleConfigAPI.of(Quark.MOD_ID + "-config").provider(configProvider).request();
        assignConfigs();
    }
    private static void createConfigs() {
        configProvider.comment("Modules");
        configProvider.add("module_automation", true);
        configProvider.newLine(1);

        configProvider.comment("Automation");
        configProvider.add("automation_Chute", true);
        configProvider.add("automation_EnderWatcher", true);
        configProvider.add("automation_Gravisand", true);
    }
    private static void assignConfigs() {
        module_automation = configs.getOrDefault("module_automation", true);
        automation_Chute = configs.getOrDefault("automation_Chute", true);
        automation_EnderWatcher = configs.getOrDefault("automation_EnderWatcher", true);
        automation_Gravisand = configs.getOrDefault("automation_Gravisand", true);
    }
}
