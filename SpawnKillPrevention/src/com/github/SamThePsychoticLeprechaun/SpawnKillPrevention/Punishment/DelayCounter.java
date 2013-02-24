package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Punishment;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.entity.Player;

import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.SpawnKillPrevention;

public class DelayCounter {
	
	private static Player player;
	
	public static void delayCounter(Player player) {
		
		DelayCounter.player = player;
		
		if (FrequencyCounter.frequencyCount(player) <= SpawnKillPrevention.spawnkillstosecondwarn) {
			
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					RemovePlayer.removePlayer(DelayCounter.player);
				}
			}, SpawnKillPrevention.firstkilldiscountdelay);
			
		} else if (FrequencyCounter.frequencyCount(player) <= SpawnKillPrevention.spawnkillstotempban) {
			
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					RemovePlayer.removePlayer(DelayCounter.player);
				}
			}, SpawnKillPrevention.secondkilldiscountdelay);
			
		} else if (FrequencyCounter.frequencyCount(player) < SpawnKillPrevention.spawnkillstopermaban) {
			
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					RemovePlayer.removePlayer(DelayCounter.player);
				}
			}, SpawnKillPrevention.thirdkilldiscountdelay);
		}
		
	}
	
}
