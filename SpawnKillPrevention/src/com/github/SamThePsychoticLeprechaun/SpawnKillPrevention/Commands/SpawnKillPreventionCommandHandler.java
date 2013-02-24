package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Commands.SPK.AddPlayerCommand;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Commands.SPK.ListCommand;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Commands.SPK.PluginCommand;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Commands.SPK.RemovePlayerCommand;

public class SpawnKillPreventionCommandHandler implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		String missingPerm = ChatColor.WHITE + "You do not have permission to use this command!";
		
		if (args.length == 0) {
				//Here, a help menu must be implemented
				sender.sendMessage("");
				return true;
				
		} else if (args.length == 1) {
			
			if (args[0].equalsIgnoreCase("Plugin")) {
				
				if (sender.hasPermission("SpawnKillPrevention.admin.Plugin") || sender.isOp() || sender instanceof ConsoleCommandSender) {
					PluginCommand.sendMessage(sender);	
					return true;				
				} else {
					sender.sendMessage(missingPerm);
					return true;
				}
			}
			
			if (args[0].equalsIgnoreCase("List")) {
				if (sender.hasPermission("SpawnKillPrevention.admin.List") || sender.isOp() || sender instanceof ConsoleCommandSender) {
					ListCommand.sendMessage(sender);	
					return true;		
				} else {
					sender.sendMessage(missingPerm);
					return true;
				}
			}
			
			if (args[0].equalsIgnoreCase("Add")) {
				sender.sendMessage(ChatColor.WHITE + "You are missing an argument, command usage should be:" + ChatColor.DARK_RED + "/SKP Add" + ChatColor.DARK_AQUA + "<PlayerName>");
				return true;
			}
			
			if (args[0].equalsIgnoreCase("Remove")) {
				sender.sendMessage(ChatColor.WHITE + "You are missing an argument, command usage should be:" + ChatColor.DARK_RED + "/SKP Remove" + ChatColor.DARK_AQUA + "<PlayerName>");
				return true;
			}
			
		} else if (args.length == 2) {	
			
			if (args[0].equalsIgnoreCase("Add")) {
				AddPlayerCommand.addPlayer(sender, args[1]);
				return true;
			}
			
			if (args [0].equalsIgnoreCase("Remove")) {
				RemovePlayerCommand.removePlayer(sender, args[1]);
				return true;				
			}
			
			
		}
		return true;
	}

}
