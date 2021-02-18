package Commands.types;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class MiesmuschelCommand implements ServerCommand {

	@Override
	public void performCommand(Member p, TextChannel channel, Message message) {
		
		List<String> givenList = Arrays.asList("Ja"
				, "Nein"
				, "Vielleicht"
				, "Ganz bestimmt"
				, "Ganz bestimmt nicht"
				, "Auf jeden fall"
				, "Auf garkeinen Fall"
				, "Ich fühl mich grad nicht so danach diese Frage zu beantworten"
				, "Frag doch einfach nochmal"); 																		
	    Random rand = new Random();
	    String randomElement = givenList.get(rand.nextInt(givenList.size()));
	  	channel.sendMessage(randomElement).queue();	
		
	}

}
