package com.magmaguy.elitemobs.config.customitems.premade;

import com.magmaguy.elitemobs.config.customitems.CustomItemsConfigFields;
import com.magmaguy.elitemobs.items.customitems.CustomItem;
import org.bukkit.Material;

import java.util.Arrays;

public class ChallengersChestplateConfig extends CustomItemsConfigFields {
    public ChallengersChestplateConfig(){
        super("challengers_chestplate", true, Material.DIAMOND_CHESTPLATE, "&cChallenger's Chestplate", Arrays.asList("&2Awarded to those who challenge the", "&2Wood League Arena!"));
        setEnchantments(Arrays.asList("PROTECTION_ENVIRONMENTAL,40", "PROTECTION_EXPLOSIONS,20", "PROTECTION_PROJECTILE,20", "MENDING,1", "DURABILITY,5"));
        setItemType(CustomItem.ItemType.UNIQUE);
    }
}
