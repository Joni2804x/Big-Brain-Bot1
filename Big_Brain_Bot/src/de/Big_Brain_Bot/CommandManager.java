package de.Big_Brain_Bot;

import java.util.concurrent.ConcurrentHashMap;

import Commands.types.BanCommand;
import Commands.types.ClearCommand;
import Commands.types.GiveawayCommand;
import Commands.types.HelpCommand;
import Commands.types.JokeCommand;
import Commands.types.KarmaCommand;
import Commands.types.KickCommand;
import Commands.types.MiesmuschelCommand;
import Commands.types.MuteCommand;
import Commands.types.RollenCommand;
import Commands.types.ServerCommand;
import Commands.types.UmfragenCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class CommandManager {

	public ConcurrentHashMap<String, ServerCommand> commands;
	
	public CommandManager() {
		this.commands = new ConcurrentHashMap<>();
	
		this.commands.put("clear", new ClearCommand());
		this.commands.put("hilfe", new HelpCommand());
		this.commands.put("witz",  new JokeCommand());
		this.commands.put("karma", new KarmaCommand());
		this.commands.put("giveaway", new GiveawayCommand());
		this.commands.put("kick", new KickCommand());
		this.commands.put("ban", new BanCommand());
		this.commands.put("mute", new MuteCommand());
		this.commands.put("umfrage", new UmfragenCommand());
		this.commands.put("rollen", new RollenCommand());
		this.commands.put("miesmuschel", new MiesmuschelCommand());
	
	}
	
	public boolean perform(String command, Member p, TextChannel channel, Message message ) {
		
		ServerCommand cmd;
		if((cmd = this.commands.get(command.toLowerCase())) != null) {
			cmd.performCommand(p,  channel,  message);
			return true;
		}
		
		return false;
	}
	
	
}
