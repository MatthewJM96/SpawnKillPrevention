package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Protected;

import java.util.Timer;

import org.bukkit.entity.Player;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.SpawnKillPrevention;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.util.ExcecuteQuery;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.util.TimeParser;

public class AddPlayer {
	
	public static void addPlayer(Player player) {
		
		int Dur = SpawnKillPrevention.protectionperiod;
		String string = TimeParser.updateTime(Dur, "seconds");
		try {
		ExcecuteQuery.setString("UPDATE Protected SET timeToEnd = '" + string + "' WHERE playerName = '" + player.getName() + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendMessage(SpawnKillPrevention.warnonprotectionmessage);
		AlertPlayerOnLost.TimerTask(player);
		Timer timer = new Timer();
		timer.schedule(new AlertPlayerOnLost(), Dur * 1000);
		
	}
	
}
