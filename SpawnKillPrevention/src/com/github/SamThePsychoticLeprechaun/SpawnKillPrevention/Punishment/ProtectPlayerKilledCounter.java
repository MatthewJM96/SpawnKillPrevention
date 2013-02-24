package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Punishment;

import java.util.PriorityQueue;

import org.bukkit.entity.Player;

public class ProtectPlayerKilledCounter {
	
	private static PriorityQueue<Player> killCounterList = new PriorityQueue<Player>();
	
	public static PriorityQueue<Player> getKillCounterList() {
		return killCounterList;
	}
	
	public static void setProtectedPlayerList(PriorityQueue<Player> killCounterList) {
		ProtectPlayerKilledCounter.killCounterList = killCounterList;
	}
	
}
