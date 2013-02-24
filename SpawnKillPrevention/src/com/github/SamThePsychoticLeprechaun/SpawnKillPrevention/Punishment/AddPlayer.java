package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Punishment;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.SpawnKillPrevention;

public class AddPlayer {
	
	public static void addPlayer(Player player) {
		
		String firstAdminWarnMessageFIRST = ChatColor.WHITE + " has spawn killed ";
		String firstAdminWarnMessageSECOND = ChatColor.WHITE + " players!";
		String secondAdminWarnMessageFIRST = ChatColor.RED + " has spawn killed ";
		String secondAdminWarnMessageSECOND = ChatColor.RED + " players!";
		
		ProtectPlayerKilledCounter.getKillCounterList().add(player);
		DelayCounter.delayCounter(player);
		
		if (FrequencyCounter.frequencyCount(player) == SpawnKillPrevention.spawnkillstofirstwarn) {
			
			player.sendMessage(SpawnKillPrevention.firstwarn);
			
		}
		
		if (FrequencyCounter.frequencyCount(player) == SpawnKillPrevention.spawnkillstofirstadminwarn) {
			
			Player[] playersOnline = SpawnKillPrevention.onlinePlayers();
			
			for(Player x: playersOnline) {
				
				if(x.hasPermission("SpawnKillPrevention.admin.recieve")) {
					
					x.sendMessage(ChatColor.DARK_RED + player.getDisplayName() + firstAdminWarnMessageFIRST + ChatColor.DARK_AQUA + SpawnKillPrevention.spawnkillstofirstadminwarn + firstAdminWarnMessageSECOND);
					
				}
				
			}
			
		}
		
		if (FrequencyCounter.frequencyCount(player) == SpawnKillPrevention.spawnkillstokick) {
			
			player.kickPlayer(SpawnKillPrevention.messageonkick);
			
		}
		
		if (FrequencyCounter.frequencyCount(player) == SpawnKillPrevention.spawnkillstosecondwarn) {
			
			player.sendMessage(SpawnKillPrevention.secondwarn);
			
		}
		
		if (FrequencyCounter.frequencyCount(player) == SpawnKillPrevention.spawnkillstosecondadminwarn) {
			
			Player[] playersOnline = SpawnKillPrevention.onlinePlayers();
			
			for(Player x: playersOnline) {
				
				if(x.hasPermission("SpawnKillPrevention.admin.recieve")) {
					
					x.sendMessage(ChatColor.DARK_RED + player.getDisplayName() + secondAdminWarnMessageFIRST + ChatColor.DARK_AQUA + SpawnKillPrevention.spawnkillstofirstadminwarn + secondAdminWarnMessageSECOND);
					
				}
				
			}
			
		}
		
		if (FrequencyCounter.frequencyCount(player) == SpawnKillPrevention.spawnkillstotempban) {
			
			player.kickPlayer(SpawnKillPrevention.messageontempban);
			BanList.getTempBannedPlayerList().add(player);
			
		}
		
		if (FrequencyCounter.frequencyCount(player) == SpawnKillPrevention.spawnkillstothirdwarn) {
			
			player.sendMessage(SpawnKillPrevention.thirdwarn);
			
		}
		
		if (FrequencyCounter.frequencyCount(player) == SpawnKillPrevention.spawnkillstopermaban) {
			
			player.kickPlayer(SpawnKillPrevention.messageonban);
			BanList.getBannedList().add(player);
			
		}
		
	}
	
}
