package net.projectff.quarkfabric.registries;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.resource.featuretoggle.ToggleableFeature;
import net.minecraft.util.Identifier;
import net.projectff.quarkfabric.base.Quark;

public class QuarkTags {
    public static class BlockTags {
        public static TagKey<Block> HOLLOW_LOGS = createBlockTag("hollow_logs");

        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Quark.MOD_ID, name));
        }
    }
    public static class ItemTags {


        private static TagKey<Item> createItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Quark.MOD_ID, name));
        }
    }
}
