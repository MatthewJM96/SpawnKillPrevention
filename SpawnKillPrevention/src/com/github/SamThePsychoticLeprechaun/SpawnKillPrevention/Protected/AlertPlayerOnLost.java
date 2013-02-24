package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Protected;

import java.util.PriorityQueue;
import java.util.TimerTask;

import org.bukkit.entity.Player;

import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.SpawnKillPrevention;

public class AlertPlayerOnLost extends TimerTask {
	
	static PriorityQueue<Player> playerList = new PriorityQueue<Player>();
	
	public static void TimerTask(Player player) {
		
		playerList.add(player);
		
	}
	
	public void run() {
		
		String message = SpawnKillPrevention.warnonlostprotectionmessage;
		
		Player player = playerList.peek();
		
		if (player != null) {
			
			player.sendMessage(message);
			playerList.poll();
			
		}
		
	}
	
}
