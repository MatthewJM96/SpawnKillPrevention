package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Punishment.BanList;

public class onBannedLoginListener implements Listener {
	
	private String messageonban;
	private String messageontempban;
	
	public onBannedLoginListener(String string, String string2) {
		this.messageonban = string;
		this.messageontempban = string2;
	}
	
	@EventHandler (priority = EventPriority.HIGH)
	public void onBannedLogin(PlayerJoinEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (BanList.getBannedList().contains(player)) {
			
			player.kickPlayer(messageonban);
			
		} else if (BanList.getTempBannedPlayerList().contains(player)) {
			
			player.kickPlayer(messageontempban);
			
		}
		
	}
	
}
 