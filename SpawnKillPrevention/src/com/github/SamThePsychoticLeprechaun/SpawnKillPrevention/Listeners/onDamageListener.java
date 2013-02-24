package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class onDamageListener implements Listener{

	public static Player playerAttacked;
	public static Entity playerAttacker;
	public static Player playerKiller;
	
	@EventHandler
	public void onDamagePlayer(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player) {
			playerAttacked = (Player) event.getEntity();
		}
		if (!(event.getDamager() instanceof Player) && event.getDamager() != null) {
			playerAttacker = event.getDamager();
		}
		if (event.getDamager() instanceof Player) {
			playerKiller = (Player) event.getDamager();
		}
	}
}
