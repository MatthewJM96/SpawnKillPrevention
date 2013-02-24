package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Commands.SPK;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class PluginCommand {
	
	public static void sendMessage(CommandSender sender) {
		sender.sendMessage(ChatColor.WHITE + "The Plug-in " + ChatColor.DARK_RED + "Spawn Kill Prevention" + ChatColor.WHITE + " is enabled and working!");
	}
	
}
