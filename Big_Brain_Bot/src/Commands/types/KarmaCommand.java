package Commands.types;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class KarmaCommand implements ServerCommand
{

	@Override
	public void performCommand(Member p, TextChannel channel, Message message) 
	{
		int KarmaAmount = 0;
		
		channel.sendMessage("Du erhälst " + KarmaAmount + " Karma").queue();
	}

}
