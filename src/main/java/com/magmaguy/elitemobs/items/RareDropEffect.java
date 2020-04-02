package com.magmaguy.elitemobs.items;

import com.magmaguy.elitemobs.MetadataHandler;
import com.magmaguy.elitemobs.items.itemconstructor.ItemQualityColorizer;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.concurrent.ThreadLocalRandom;

public class RareDropEffect implements Listener {

    public static void runEffect(Item item) {

        if (!(ItemQualityColorizer.getItemQuality(item.getItemStack()).equals(ItemQualityColorizer.ItemQuality.LIGHT_BLUE) ||
                ItemQualityColorizer.getItemQuality(item.getItemStack()).equals(ItemQualityColorizer.ItemQuality.GOLD)))
            return;

        new BukkitRunnable() {
            int counter = 0;
            @Override
            public void run() {

                if (item == null || !item.isValid() || item.isDead()) {
                    cancel();
                    return;
                }

                for (int i = 0; i < 3; i++) {

                    Location location = item.getLocation().clone();
                    double randomizedY = ThreadLocalRandom.current().nextDouble() * 2;
                    double randomizedX = (ThreadLocalRandom.current().nextDouble() * 2 - 1) / randomizedY;
                    double randomizedZ = (ThreadLocalRandom.current().nextDouble() * 2 - 1) / randomizedY;
                    location.add(new Vector(randomizedX, randomizedY, randomizedZ));

                    location.getWorld().spawnParticle(Particle.DRAGON_BREATH, location, 1, 0, 0, 0, 0);

                }

                counter++;
                if (counter > 20 * 60 * 2)
                    cancel();
            }

        }.runTaskTimer(MetadataHandler.PLUGIN, 0, 1);

    }

    @EventHandler
    public void onItemDrop(ItemSpawnEvent event) {
        if (!ItemTagger.isEliteItem(event.getEntity().getItemStack())) return;
        runEffect(event.getEntity());
    }

}
