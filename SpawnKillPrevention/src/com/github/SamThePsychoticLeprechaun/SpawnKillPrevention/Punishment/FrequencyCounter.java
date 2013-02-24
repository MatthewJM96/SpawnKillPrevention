package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Punishment;

import java.util.Collections;

import org.bukkit.entity.Player;

public class FrequencyCounter {
	
	public static int frequencyCount (Player player) {
		
		int freq = Collections.frequency(ProtectPlayerKilledCounter.getKillCounterList(), player);
		return freq;
		
	}
	
}
