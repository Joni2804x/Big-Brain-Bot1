package Commands.types;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;

public class HelpCommand implements ServerCommand {

	@Override
	public void performCommand(Member p, TextChannel channel, Message message)
	{
		channel.sendMessage("-!bbWitz --> Ich erzähle einen Witz\n" +
				"-Prost --> Ich w�nsche dir Prost\n" +
				"-Ich bin --> auf S�tze die mit |Ich bin| beginnen, antworte ich mit |Hallo + Nachricht + Ich bin Vater|\n" +
				"-Gurke --> Ich sende eine Gurke\n" +
				"-HANS! --> I get ze Flammenwerfer!\n" +
				"!bbMiesmuschel --> Ich antworte auf deine Frage\n").queue();
	}
}
	
		
	
  
