package com.magmaguy.elitemobs.config.custombosses.premade;

import com.magmaguy.elitemobs.config.custombosses.CustomBossesConfigFields;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class WoodLeagueWave44Healer extends CustomBossesConfigFields {
    public WoodLeagueWave44Healer(){
        super("wood_league_wave_44_healer",
                EntityType.PILLAGER,
                true,
                "$normalLevel Arena Healer",
                "44");
        setFollowDistance(60);
        setMainHand(new ItemStack(Material.CROSSBOW));
        setPowers(Arrays.asList("channel_healing.yml"));
        setHealthMultiplier(.5D);
    }
}
