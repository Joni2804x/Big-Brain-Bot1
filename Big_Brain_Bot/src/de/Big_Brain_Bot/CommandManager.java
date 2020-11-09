package de.Big_Brain_Bot;

import java.util.concurrent.ConcurrentHashMap;

import Commands.types.ClearCommand;
import Commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class CommandManager {

	public ConcurrentHashMap<String, ServerCommand> commands;
	
	public CommandManager() {
		this.commands = new ConcurrentHashMap<>();
	
		this.commands.put("clear", new ClearCommand());
		this.commands.put("Hilfe", new HelpCommand());
	
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
