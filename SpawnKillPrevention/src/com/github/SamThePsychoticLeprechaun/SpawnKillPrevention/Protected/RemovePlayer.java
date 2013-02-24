package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Protected;

import org.bukkit.entity.Player;

import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.SpawnKillPrevention;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.util.ExcecuteQuery;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.util.TimeParser;

public class RemovePlayer {
	
	private String messageOnLost = SpawnKillPrevention.warnonlostprotectionmessage;
	
	public void removePlayer(Player player) {
		
		try {
		ExcecuteQuery.setString("UPDATE Protected SET timeToEnd = '" + TimeParser.getSystDate() + "' WHERE playerName = '" + player.getName() + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendMessage(messageOnLost);		
		AlertPlayerOnLost.playerList.poll();
		
	}
}


	

