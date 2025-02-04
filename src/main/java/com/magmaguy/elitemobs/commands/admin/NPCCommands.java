package com.magmaguy.elitemobs.commands.admin;

import com.magmaguy.elitemobs.api.internal.RemovalReason;
import com.magmaguy.elitemobs.config.npcs.NPCsConfig;
import com.magmaguy.elitemobs.config.npcs.NPCsConfigFields;
import com.magmaguy.elitemobs.entitytracker.EntityTracker;
import com.magmaguy.elitemobs.npcs.NPCEntity;
import com.magmaguy.elitemobs.utils.Round;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class NPCCommands {

    public static void set(Player player, String npcFileName) {

        NPCsConfigFields npCsConfigFields = NPCsConfig.getNpcEntities().get(npcFileName);
        if (npCsConfigFields == null) {
            player.sendMessage("[EliteMobs] Invalid NPC filename.");
            return;
        }

        Location playerLocation = player.getLocation();

        String location = playerLocation.getWorld().getName() + ","
                + Round.twoDecimalPlaces(playerLocation.getX()) + ","
                + Round.twoDecimalPlaces(playerLocation.getY()) + ","
                + Round.twoDecimalPlaces(playerLocation.getZ()) + ","
                + Round.twoDecimalPlaces(playerLocation.getYaw()) + ","
                + Round.twoDecimalPlaces(playerLocation.getPitch());

        try {
            for (NPCEntity npcEntity : EntityTracker.getNpcEntities().values())
                if (npcEntity.npCsConfigFields.equals(npCsConfigFields))
                    npcEntity.remove(RemovalReason.REMOVE_COMMAND);
        } catch (Exception ex) {
        }

        npCsConfigFields.setEnabled(true);
        npCsConfigFields.setLocation(location);
        new NPCEntity(npCsConfigFields);

    }

}
