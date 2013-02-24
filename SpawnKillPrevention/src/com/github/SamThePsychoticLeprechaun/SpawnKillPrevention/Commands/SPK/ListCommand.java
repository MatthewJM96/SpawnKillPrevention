package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Commands.SPK;

import java.util.PriorityQueue;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.util.ExcecuteQuery;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.util.TimeParser;

public class ListCommand {
	
	private static PriorityQueue<Player> protectedList;
	
		
	public static void sendMessage(CommandSender sender) {
		
		for(Player p: Bukkit.getServer().getOnlinePlayers()) {
			
			if(TimeParser.compareTimeToCurrent(ExcecuteQuery.checkPlayerProtection(p.getName()))) {
				
				protectedList.add(p);
				
			}
			
		}
		
		if(!(protectedList.isEmpty())) {
			
		sender.sendMessage(ChatColor.WHITE + "The following are protected players:");
		
		for(Player p: protectedList) {
			
			String playerName = p.getDisplayName();
			sender.sendMessage(ChatColor.DARK_RED + playerName);
			protectedList.poll();
			
		} 
		
		} else {
			
			sender.sendMessage(ChatColor.WHITE + "There are no protected players on this server.");
			
		}	
	}
}
