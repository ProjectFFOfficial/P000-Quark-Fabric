package net.projectff.quarkfabric.config;

import net.projectff.quarkfabric.base.Quark;
import org.jetbrains.annotations.NotNull;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.List;

public class QuarkConfigManager {
    private static SimpleConfigAPI configs;
    private static Provider configProvider;

    public static void registerConfigs() {
        configProvider = new Provider();
        createConfigs();

        configs = SimpleConfigAPI.of(Quark.MOD_ID + "-config").provider(configProvider).request();
        assignConfigs();
    }
    private static void createConfigs() {
        configProvider.comment("Modules");
        configProvider.addAll("module.", QuarkConfigs.Module.moduleStuff, true);
        configProvider.newLine(1);

        configProvider.comment("Automation");
        configProvider.addAll("automation.", QuarkConfigs.Automation.automationStuff, true);
    }
    private static void assignConfigs() {
        QuarkConfigs.Module.automation = configs.getOrDefault("module.automation", true);
        QuarkConfigs.Module.building = configs.getOrDefault("module.building", true);
        QuarkConfigs.Module.client = configs.getOrDefault("module.client", true);
        QuarkConfigs.Module.decoration = configs.getOrDefault("module.decoration", true);
        QuarkConfigs.Module.experimental = configs.getOrDefault("module.experimental", true);
        QuarkConfigs.Module.management = configs.getOrDefault("module.management", true);
        QuarkConfigs.Module.misc = configs.getOrDefault("module.misc", true);
        QuarkConfigs.Module.oddities = configs.getOrDefault("module.oddities", true);
        QuarkConfigs.Module.tweaks = configs.getOrDefault("module.tweaks", true);
        QuarkConfigs.Module.vanity = configs.getOrDefault("module.vanity", true);
        QuarkConfigs.Module.world = configs.getOrDefault("module.world", true);

        QuarkConfigs.Automation.animalsEatFloorFood = configs.getOrDefault("automation.animalsEatFloorFood", true);
        QuarkConfigs.Automation.chainLinkage = configs.getOrDefault("automation.chainLinkage", true);
        QuarkConfigs.Automation.chute = configs.getOrDefault("automation.chute", true);
        QuarkConfigs.Automation.colorSlime = configs.getOrDefault("automation.colorSlime", true);
        QuarkConfigs.Automation.dispenserRecords = configs.getOrDefault("automation.dispenserRecords", true);
        QuarkConfigs.Automation.dispensersPlaceBlocks = configs.getOrDefault("automation.dispensersPlaceBlocks", true);
        QuarkConfigs.Automation.dispensersPlaceSeeds = configs.getOrDefault("automation.dispensersPlaceSeeds", true);
        QuarkConfigs.Automation.enderWatcher = configs.getOrDefault("automation.enderWatcher", true);
        QuarkConfigs.Automation.gravisand = configs.getOrDefault("automation.gravisand", true);
        QuarkConfigs.Automation.metalButtons = configs.getOrDefault("automation.metalButtons", true);
        QuarkConfigs.Automation.obsidianPressurePlate = configs.getOrDefault("automation.obsidianPressurePlate", true);
        QuarkConfigs.Automation.pistonBlockBreakers = configs.getOrDefault("automation.pistonBlockBreakers", true);
        QuarkConfigs.Automation.pistonsPushAndPullItems = configs.getOrDefault("automation.pistonsPushAndPullItems", true);
        QuarkConfigs.Automation.pistonsMoveTEs = configs.getOrDefault("automation.pistonsMoveTEs", true);
        QuarkConfigs.Automation.rainDetector = configs.getOrDefault("automation.rainDetector", true);
        QuarkConfigs.Automation.redstoneInductor = configs.getOrDefault("automation.redstoneInductor", true);
        QuarkConfigs.Automation.redstoneRandomizer = configs.getOrDefault("automation.redstoneRandomizer", true);
        QuarkConfigs.Automation.sugarBlock = configs.getOrDefault("automation.sugarBlock", true);
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
        public <T> void add(String key, T value) {
            this.configList.add(new Pair<>(key, value));
            this.comment("type: " + value.getClass().getName() + " | default_value: " + value);
            this.configContents += key + " = " + value + '\n';
        }
        public <T> void add(String key, T value, String comment) {
            this.comment(comment);
            this.add(key, value);
        }
        public <T> void addAll(@NotNull String[] keys, T value) {
            for (String key : keys) {
                this.add(key, value);
            }
        }
        public <T> void addAll(String prefix, @NotNull String[] keys, T value) {
            for (String key : keys) {
                this.add(prefix + key, value);
            }
        }
        public <T> void addAll(@NotNull Pair<?,?>[] keys, T value) {
            for (Pair<?, ?> keyPair : keys) {
                if (keyPair.getA() instanceof String key) this.add(key, value);
            }
        }
        public <T> void addAll(String prefix, @NotNull Pair<?,?>[] keys, T value) {
            for (Pair<?,?> keyPair: keys) {
                if (keyPair.getA() instanceof String key) this.add(prefix + key, value);
            }
        }

        @Override
        public String get(String namespace) {
            return configContents;
        }
    }
}
