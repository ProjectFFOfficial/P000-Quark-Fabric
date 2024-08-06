package net.projectff.quarkfabric.internal_zeta.org;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public interface ItemExtensionFactory {
    IZetaItemExtensions getInternal(ItemStack var1);

    default IZetaItemExtensions get(ItemStack stack) {
        Item var3 = stack.getItem();
        if (var3 instanceof IZetaItemExtensions ext) {
            return ext;
        }
        return null;
    }
}