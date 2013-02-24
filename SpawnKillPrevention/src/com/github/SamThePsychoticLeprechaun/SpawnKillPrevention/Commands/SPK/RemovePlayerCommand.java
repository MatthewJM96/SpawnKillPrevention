package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Commands.SPK;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Punishment.RemovePlayer;

public class RemovePlayerCommand {
	
	public static void removePlayer(CommandSender sender, String player) {
				
		List<Player> possiblePlayers = Bukkit.getServer().matchPlayer(player);
		
		if (possiblePlayers == null || possiblePlayers.size() < 1) {
			sender.sendMessage(ChatColor.WHITE + "Player " + ChatColor.DARK_RED + player + ChatColor.DARK_RED + " does not exist or is offline!");
			return;
		} else if (possiblePlayers.size() > 1) {
			sender.sendMessage(ChatColor.WHITE + "There is more than one player with a partial name of '" + ChatColor.DARK_RED + player + ChatColor.WHITE + "'!");
			return;
		}
		
		Player playerTarget = (Player) possiblePlayers.get(0);
		String messageToSender = ChatColor.DARK_RED + playerTarget.getDisplayName() + ChatColor.WHITE + " has had their protection removed!";
		sender.sendMessage(messageToSender);
		RemovePlayer.removePlayer(playerTarget);
		
	}
}
