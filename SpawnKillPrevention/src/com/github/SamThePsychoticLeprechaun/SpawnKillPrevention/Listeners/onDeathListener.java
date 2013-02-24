package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.SpawnKillPrevention;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Protected.AddPlayer;

public class onDeathListener implements Listener{
	
	@EventHandler
	public void onDeathEvent(PlayerDeathEvent event) {
		if (onDamageListener.playerAttacker != null && onDamageListener.playerAttacked == event.getEntity()) {
			
			//If server owner sets to true, then protect on death
			if (SpawnKillPrevention.protectplayerondeath) {
				
			Player player = (Player) event.getEntity();
			AddPlayer.addPlayer(player);
			
			}
		}
	}
}
