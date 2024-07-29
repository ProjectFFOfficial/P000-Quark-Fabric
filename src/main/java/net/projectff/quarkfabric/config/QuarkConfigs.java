package net.projectff.quarkfabric.config;

import net.projectff.quarkfabric.base.Quark;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.List;

public class QuarkConfigs {
    private static SimpleConfigAPI configs;
    public static Provider configProvider;

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
        configProvider = new Provider();
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

    public static class Provider implements SimpleConfigAPI.DefaultConfig {
        private String configContents = "";
        private final List<Pair<String, ?>> configList = new ArrayList<>();

        public Provider() {
        }

        public List<Pair<String, ?>> getConfigList() {
            return this.configList;
        }

        // formatting functions
        public void rawIncersion(String string) {
            this.configContents += string;
        }
        public void newLine(int new_lines) {
            for (int i = 0; i < new_lines; i++) {
                this.configContents += '\n';
            }
        }
        public void comment(String comment) {
            this.configContents += "# " + comment + '\n';
        }
        // config functions
        public void add(String key, Object value) {
            this.configList.add(new Pair<>(key, value));
            comment("type: " + value.getClass().getName() + "default value: " + value);
            this.configContents += key + " = " + value + '\n';
        }
        public void add(String key, Object value, String comment) {
            comment(comment);
            add(key, value);
        }

        @Override
        public String get(String namespace) {
            return configContents;
        }
    }
}
