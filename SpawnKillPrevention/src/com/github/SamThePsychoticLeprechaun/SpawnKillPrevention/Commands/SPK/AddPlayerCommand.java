package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Commands.SPK;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.SpawnKillPrevention;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Protected.AddPlayer;

public class AddPlayerCommand {
	
	
	
	public static void addPlayer(CommandSender sender, String player) {
		
		String messageOnProtect = SpawnKillPrevention.warnonprotectionmessage;
		
		List<Player> possiblePlayers = Bukkit.getServer().matchPlayer(player);
		
		if (possiblePlayers == null || possiblePlayers.size() < 1) {
			sender.sendMessage(ChatColor.WHITE + "Player " + ChatColor.DARK_RED + player + ChatColor.DARK_RED + " does not exist or is offline!");
			return;
		} else if (possiblePlayers.size() > 1) {
			sender.sendMessage(ChatColor.WHITE + "There is more than one player with a partial name of " + ChatColor.DARK_RED + player + ChatColor.WHITE + "!");
			return;
		}
		
		Player playerTarget = (Player) possiblePlayers.get(0);
		String messageToSender = ChatColor.DARK_RED + player + ChatColor.WHITE + " has been protected!";
		
		AddPlayer.addPlayer(playerTarget);
		playerTarget.sendMessage(messageOnProtect);
		sender.sendMessage(messageToSender);
		
	}
}