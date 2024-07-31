package net.projectff.quarkfabric.config;

import oshi.util.tuples.Pair;

public class QuarkConfigs {
    public class Module {
        public static boolean automation = false;
        public static boolean building = false;
        public static boolean client = false;
        public static boolean decoration = false;
        public static boolean experimental = false;
        public static boolean management = false;
        public static boolean misc = false;
        public static boolean oddities = false;
        public static boolean tweaks = false;
        public static boolean vanity = false;
        public static boolean world = false;
        protected static Pair<?, ?>[] moduleStuff = {
                new Pair<>("automation", automation),
                new Pair<>("building", building),
                new Pair<>("client", client),
                new Pair<>("decoration", decoration),
                new Pair<>("experimental", experimental),
                new Pair<>("management", management),
                new Pair<>("misc", misc),
                new Pair<>("oddities", oddities),
                new Pair<>("tweaks", tweaks),
                new Pair<>("vanity", vanity),
                new Pair<>("world", world),
        };
    }

    public class Automation {
        public static boolean animalsEatFloorFood = false; // "Animals eat floor food"
        public static boolean chainLinkage = false; // "Chain linkage"
        public static boolean chute = false; // Chute
        public static boolean colorSlime = false; // "Color slime"
        public static boolean dispenserRecords = false; // "Dispenser records"
        public static boolean dispensersPlaceBlocks = false; // "Dispensers place blocks"
        public static boolean dispensersPlaceSeeds = false; // "Dispensers place seeds"
        public static boolean enderWatcher = false; // "Ender watcher"
        public static boolean gravisand = false; // Gravisand
        public static boolean metalButtons = false; // "Metal buttons"
        public static boolean obsidianPressurePlate = false; // "Obsidian pressure plate"
        public static boolean pistonBlockBreakers = false; // "Piston Block Breakers"
        public static boolean pistonsPushAndPullItems = false; // "Pistons Push and Pull Items"
        public static boolean pistonsMoveTEs = false; // "Pistons move t es"
        public static boolean rainDetector = false; // "Rain detector"
        public static boolean redstoneInductor = false; // "Redstone inductor"
        public static boolean redstoneRandomizer = false; // "Redstone randomizer"
        public static boolean sugarBlock = false; // "Sugar block"
        protected static String[] automationStuff = {
                "animalsEatFloorFood",
                "chainLinkage",
                "chute",
                "colorSlime",
                "dispenserRecords",
                "dispensersPlaceBlocks",
                "dispensersPlaceSeeds",
                "enderWatcher",
                "gravisand",
                "metalButtons",
                "obsidianPressurePlate",
                "pistonBlockBreakers",
                "pistonsPushAndPullItems",
                "pistonsMoveTEs",
                "rainDetector",
                "redstoneInductor",
                "redstoneRandomizer",
                "sugarBlock"
        };
    }
}
