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
        configProvider.addAll("module.", QuarkConfigs.Module.MODULE_STUFF, true, 1);
        configProvider.newLine(1);

        configProvider.comment("Automation");
        configProvider.addAll("automation.", QuarkConfigs.Automation.AUTOMATION_STUFF, true, 1);
        configProvider.newLine(1);

        configProvider.comment("Automation.FeedingTrough");
        configProvider.add("automation.feedingTrough.loveChance", 0.333333333, 0.0, false, 1.0, true, "The chance (between 0 and 1) for an animal to enter love mode when eating from the trough", 1);
        configProvider.add("automation.feedingTrough.cooldown", 30, 1, true, Integer.MAX_VALUE, false, "How long, in game ticks, between animals being able to eat from the trough", 1);
        configProvider.add("automation.feedingTrough.maxAnimals", 32, "The maximum amount of animals allowed around the trough's range for an animal to enter love mode", 1);
        configProvider.add("automation.feedingTrough.range", 10, 1);
        configProvider.add("automation.feedingTrough.lookChance", 0.015, "Chance that an animal decides to look for a through. Closer it is to 1 the more performance it will take. Decreasing will make animals take longer to find one", 1);

    }
    private static void assignConfigs() {
        QuarkConfigs.Module.automation = configs.getOrDefault("module.automation", true);
        QuarkConfigs.Module.building = configs.getOrDefault("module.building", true);
        QuarkConfigs.Module.management = configs.getOrDefault("module.management", true);
        QuarkConfigs.Module.tools = configs.getOrDefault("module.tools", true);
        QuarkConfigs.Module.tweaks = configs.getOrDefault("module.tweaks", true);
        QuarkConfigs.Module.world = configs.getOrDefault("module.world", true);
        QuarkConfigs.Module.mobs = configs.getOrDefault("module.mobs", true);
        QuarkConfigs.Module.client = configs.getOrDefault("module.client", true);
        QuarkConfigs.Module.experimental = configs.getOrDefault("module.experimental", true);
        QuarkConfigs.Module.oddities = configs.getOrDefault("module.oddities", true);

        QuarkConfigs.Automation.chute = configs.getOrDefault("automation.chute", true);
        QuarkConfigs.Automation.ironRod = configs.getOrDefault("automation.ironRod", true);
        QuarkConfigs.Automation.enderWatcher = configs.getOrDefault("automation.enderWatcher", true);
        QuarkConfigs.Automation.chainsConnectBlocks = configs.getOrDefault("automation.chainsConnectBlocks", true);
        QuarkConfigs.Automation.dispensersPlaceBlocks = configs.getOrDefault("automation.dispensersPlaceBlocks", true);
        QuarkConfigs.Automation.obsidianPlate = configs.getOrDefault("automation.obsidianPlate", true);
        QuarkConfigs.Automation.metalButtons = configs.getOrDefault("automation.metalButtons", true);
        QuarkConfigs.Automation.gravisand = configs.getOrDefault("automation.gravisand", true);
        QuarkConfigs.Automation.pistonsMoveTileEntities = configs.getOrDefault("automation.pistonsMoveTileEntities", true);
        QuarkConfigs.Automation.feedingTrough = configs.getOrDefault("automation.feedingTrough", true);
        QuarkConfigs.Automation.redstoneRandomizer = configs.getOrDefault("automation.redstoneRandomizer", true);

        QuarkConfigs.Automation.FeedingTrough.loveChance = configs.getOrDefault("automation.feedingTrough.loveChance", 0.333333333, 0.0, false, 1.0, true);
        QuarkConfigs.Automation.FeedingTrough.cooldown = configs.getOrDefault("automation.feedingTrough.cooldown", 30, 1, true, Integer.MAX_VALUE, false);
        QuarkConfigs.Automation.FeedingTrough.maxAnimals = configs.getOrDefault("automation.feedingTrough.maxAnimals", 32);
        QuarkConfigs.Automation.FeedingTrough.range = configs.getOrDefault("automation.feedingTrough.range", 10);
        QuarkConfigs.Automation.FeedingTrough.lookChance = configs.getOrDefault("automation.feedingTrough.lookChance", 0.015);
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
                this.rawIncersion("\n");
            }
        }
        public void indentation(int indentation) {
            for (int i = 0; i < indentation; i++) {
                this.rawIncersion("    ");
            }
        }
        public void comment(String comment, int... indentation) {
            if (indentation.length > 0) this.indentation(indentation[0]);
            this.rawIncersion("# " + comment + '\n');
        }
        // config functions
        public <T> void add(String key, T value, T min, boolean min_inclusive, T max, boolean max_inclusive, int... indentation) {
            this.configList.add(new Pair<>(key, value));
            String min_incl = min_inclusive ? "[" : "(";
            String max_incl = max_inclusive ? "]" : ")";
            if (indentation.length > 0) this.indentation(indentation[0]);
            this.comment("type: " + value.getClass().getCanonicalName() + " | default_value: " + value + " | allowed_values: " + min_incl + min + "," + max + max_incl);
            if (indentation.length > 0) this.indentation(indentation[0]);
            this.rawIncersion(key + " = " + value + '\n');
        }
        public <T> void add(String key, T value, int... indentation) {
            this.configList.add(new Pair<>(key, value));
            if (indentation.length > 0) this.indentation(indentation[0]);
            this.comment("type: " + value.getClass().getCanonicalName() + " | default_value: " + value);
            if (indentation.length > 0) this.indentation(indentation[0]);
            this.rawIncersion(key + " = " + value + '\n');
        }
        public <T> void add(String key, T value, T min, boolean min_inclusive, T max, boolean max_inclusive, String comment, int... indentation) {
            this.comment(comment, indentation);
            this.add(key, value, min, min_inclusive, max, max_inclusive, indentation);
        }
        public <T> void add(String key, T value, String comment, int... indentation) {
            this.comment(comment, indentation);
            this.add(key, value, indentation);
        }
        public <T> void addAll(@NotNull String[] keys, T value, int... indentation) {
            for (String key : keys) {
                this.add(key, value, indentation);
            }
        }
        public <T> void addAll(String prefix, @NotNull String[] keys, T value, int... indentation) {
            for (String key : keys) {
                this.add(prefix + key, value, indentation);
            }
        }

        @Override
        public String get(String namespace) {
            return configContents;
        }
    }
}
