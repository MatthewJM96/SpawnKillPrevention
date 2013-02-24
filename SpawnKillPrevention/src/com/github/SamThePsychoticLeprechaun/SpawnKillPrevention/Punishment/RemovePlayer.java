package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Punishment;

import org.bukkit.entity.Player;

public class RemovePlayer {

	public static void removePlayer(Player player) {
		
		ProtectPlayerKilledCounter.getKillCounterList().remove(player);
		
	}
	
}
