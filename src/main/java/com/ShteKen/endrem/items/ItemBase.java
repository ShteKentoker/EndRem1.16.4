package com.ShteKen.endrem.items;

import com.ShteKen.endrem.EndRemastered;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().isImmuneToFire().group(EndRemastered.TAB));
    }
}
