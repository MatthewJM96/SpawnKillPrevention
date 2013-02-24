package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.SpawnKillPrevention;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Protected.AddPlayer;

public class onKilledListener implements Listener {
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		
		Player playerDied = (Player) event.getEntity();
		
		if (playerDied == onDamageListener.playerAttacked && onDamageListener.playerKiller != null) {
			
			//If server owner sets to true, then protect on killed.
			if (SpawnKillPrevention.protectplayeronkill) {
				
			Player player = (Player) event.getEntity();
			AddPlayer.addPlayer(player);
			
			}
		}
	}
}
