package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.SpawnKillPrevention;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Protected.*;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.util.ExcecuteQuery;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.util.TimeParser;

public class onLoginListener implements Listener {

	@EventHandler
	public void onPlayerLogin(PlayerJoinEvent event) {
		
		String name = event.getPlayer().getName();
		String string = null;
		try {
		string = ExcecuteQuery.getString("SELECT playerName, timeToEnd FROM Protected WHERE playerName = '" + name + "'", 1);
		} catch(Exception ex){
			string = null;
		} finally {
			if(string == null ) {
				ExcecuteQuery.setString("INSERT INTO Protected(playerName, timeToEnd) VALUES('" + name + "', '" + TimeParser.getSystDate() + "')");
			}
		}
		
		//If server owner sets to true, then protect on login.
		if (SpawnKillPrevention.protectplayeronlogin) {
			
		Player player = (Player) event.getPlayer();
		AddPlayer.addPlayer(player);
		
		}
		
	}

}
