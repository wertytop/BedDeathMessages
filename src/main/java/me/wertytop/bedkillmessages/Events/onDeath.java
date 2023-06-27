package me.wertytop.bedkillmessages.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class onDeath implements Listener {
    private Player lastBed = null;

    public onDeath(Player lastBed) {
        this.lastBed = lastBed;
    }

    public onDeath() {
        
    }

    @EventHandler
    public void onBedEntry(PlayerBedEnterEvent e) {
        e.getPlayer();
        lastBed=e.getPlayer();
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (e.getEntity().getLastDamageCause() instanceof EntityDamageByBlockEvent cause) {
            if (cause.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
                e.getEntity();
                if (e.getEntity() == lastBed){
                    e.setDeathMessage(e.getEntity().getDisplayName() + " slept for the last time");

                }else {
                    e.setDeathMessage(e.getEntity().getDisplayName() + " was bed bombed by " + lastBed.getDisplayName());
                }

            }
            if (cause.getCause()==EntityDamageEvent.DamageCause.FIRE_TICK){
                e.setDeathMessage(e.getEntity().getDisplayName() + " was toasted to death");
            }
            if (cause.getCause()==EntityDamageEvent.DamageCause.VOID){
                e.setDeathMessage(e.getEntity().getDisplayName() + " tripped and fell into the void");
            }
        }

    }
}
