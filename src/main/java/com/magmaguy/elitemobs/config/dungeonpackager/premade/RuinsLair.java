package com.magmaguy.elitemobs.config.dungeonpackager.premade;

import com.magmaguy.elitemobs.config.dungeonpackager.DungeonPackagerConfigFields;
import com.magmaguy.elitemobs.utils.DiscordLinks;
import org.bukkit.util.Vector;

import java.util.Arrays;

public class RuinsLair extends DungeonPackagerConfigFields {
    public RuinsLair() {
        super("the_ruins",
                false,
                "&6The Ruins",
                DungeonLocationType.SCHEMATIC,
                Arrays.asList("&fA fight against a myth from",
                        "&fNorse mythology, be prepared for a smiting!",
                        "&6Credits: 69OzCanOfBepis, MagmaGuy"),
                Arrays.asList(
                        "ruins_boss_p1.yml:0,0,0"),
                Arrays.asList(),
                DiscordLinks.premiumMinidungeons,
                DungeonSizeCategory.LAIR,
                null,
                "em_the_ruins.schem",
                null,
                true,
                new Vector(18, -6, -19),
                new Vector(-21, 10, 20),
                new Vector(-1, -4, 18),
                0,
                0,
                0,
                "Difficulty: &cHard\n" +
                        "$bossCount level $lowestTier Big Boss!\n" +
                        "&cA tough fight against a Norse god!",
                "&8[EM] &3Those who challenge the myths must be prepared for their downfall!",
                "&8[EM] &3You now know what it takes to make a legend!");
    }
}
