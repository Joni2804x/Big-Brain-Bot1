package Commands.types;

import java.awt.Color;
import java.security.Timestamp;
import java.time.temporal.TemporalAccessor;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GiveawayCommand implements ServerCommand {

	@Override
	public void performCommand(Member p, TextChannel channel, Message message) {
		
		String VerlosungsObjekt;
		User Autor = message.getAuthor();
		String VerlosungsDauer;	
	
		
		if(p.hasPermission(Permission.ADMINISTRATOR)) 
		{
	
			channel.sendMessage("Was soll Verlost werden?").queue();	
			if(message.getAuthor().isBot()) return;
			VerlosungsObjekt = message.getContentRaw();
			
			channel.sendMessage("Wie lange soll die verlosung gehen?").queue();
			if(message.getAuthor().isBot()) return;
			VerlosungsDauer = message.getContentRaw();
			
			
			
			
			EmbedBuilder eb = new EmbedBuilder();
			eb.setTitle("!Verlosung!");
			eb.addField("Zu Verlosendes Objekt", VerlosungsObjekt, true);
			//eb.setTimestamp(VerlosungsDauerint);
			eb.setColor(Color.red);
		
			message.getChannel().sendMessage(eb.build()).queue();;
			
			
		
			
			
			
			
		}
		else
		{
			channel.sendMessage("Unzureichende Berechtigungen!").queue();
		}
		
	}

	private void VerlosungsObjekt(MessageReceivedEvent message) {
		
		
	}
	
}


