package net.projectff.quarkfabric.config;

public class QuarkConfigs {
    public class Module {
        public static boolean automation = false;
        public static boolean building = false;
        public static boolean management = false;
        public static boolean tools = false;
        public static boolean tweaks = false;
        public static boolean world = false;
        public static boolean mobs = false;
        public static boolean client = false;
        public static boolean experimental = false;
        public static boolean oddities = false;
        protected static final String[] MODULE_STUFF = {
                "automation",
                "building",
                "management",
                "tools",
                "tweaks",
                "world",
                "mobs",
                "client",
                "experimental",
                "oddities"
        };
    }

    public class Automation {
        public static boolean chute = false;
        public static boolean ironRod = false;
        public static boolean enderWatcher = false;
        public static boolean chainsConnectBlocks = false;
        public static boolean dispensersPlaceBlocks = false;
        public static boolean obsidianPlate = false;
        public static boolean metalButtons = false;
        public static boolean gravisand = false;
        public static boolean pistonsMoveTileEntities = false;
        public static boolean feedingThrough = false;
        public static boolean redstoneRandomizer = false;
        protected static final String[] AUTOMATION_STUFF = {
                "chute",
                "ironRod",
                "enderWatcher",
                "chainsConnectBlocks",
                "dispensersPlaceBlocks",
                "obsidianPlate",
                "metalButtons",
                "gravisand",
                "pistonsMoveTileEntities",
                "feedingThrough",
                "redstoneRandomizer"
        };
        public class FeedingThrough {
            public static double loveChance = 0.333333333;
            public static int cooldown = 30;
            public static int maxAnimals = 32;
            public static double range = 10;
            public static double lookChance = 0.015;
            protected static final String[] FEEDING_THROUGH_STUFF = {
                    "loveChance",
                    "cooldown",
                    "maxAnimals",
                    "range",
                    "lookChance"
            };
        }
    }
}
