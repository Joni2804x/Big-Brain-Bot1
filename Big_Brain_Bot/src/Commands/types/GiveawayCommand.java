package Commands.types;

import java.awt.Color;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GiveawayCommand implements ServerCommand{

	@Override
	public void performCommand(Member p, TextChannel channel, Message message) {
		
		String VerlosungsObjekt;
		int seconds;
		int minutes;
		int hours;
		long EndTime;
		 
        SimpleDateFormat StartTime = new SimpleDateFormat("hh:mm:ss");
        
        Date date = new Date();
        String result = StartTime.format(date);

        
		if(p.hasPermission(Permission.ADMINISTRATOR)) 
		{
	
			String[] args = message.getContentDisplay().split(" ");
			if(args.length < 4)
			{
				channel.sendMessage("Ein, oder mehrere Argumente sind Leer!").queue();
			}
			else
			{

			seconds = Integer.parseInt(args[1]);
			minutes = Integer.parseInt(args[2]);
			hours = Integer.parseInt(args[3]);
			VerlosungsObjekt = String.join(" ", Arrays.copyOfRange(args, 4, args.length - 0));
			
			EndTime = System.currentTimeMillis() + (seconds * 1000) + (minutes * 60 * 1000) + (hours * 60 * 60 * 1000);
			
			
			EmbedBuilder eb = new EmbedBuilder();
			eb.setTitle("🎉" + "Verlosung" + "🎉");
			eb.addField("Zu Verlosendes Objekt:", VerlosungsObjekt, true);
			eb.addField("Bis ", args[1], true);
			eb.setColor(Color.red);
		
			Message Rmessage = message.getChannel().sendMessage(eb.build()).complete();
			
			Rmessage.addReaction("🎉").queue();	       
			
			for (MessageReaction i : Rmessage.getReactions()) {
			    if (i.getReactionEmote().isEmoji()) {
			        if (i.getReactionEmote().getEmoji().equals("🎉")) {
			            User Users = i.retrieveUsers().complete();
			            
			            if(Users)
						{
							Random rand = new Random();
							do
							{
								User Winner = Users.get(rand.nextInt(0, Users.size()));
							}
							while(!Winner.isBot());
							
							channel.sendMessage("Gewonnen hat " + Winner + "🎉").queue(); 
						}
			            
			            break;
			        }
			    }
			}

			
			
				
				
		}
			
			
			
		}
		else
		{
			channel.sendMessage("Unzureichende Berechtigungen!").queue();
		}
		
	}

	
	
}