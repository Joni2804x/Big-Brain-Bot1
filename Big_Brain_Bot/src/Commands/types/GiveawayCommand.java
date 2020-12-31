package Commands.types;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
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
		long endTime;
		
		
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        
           
		if(p.hasPermission(Permission.ADMINISTRATOR)) 
		{
	
			String[] args = message.getContentDisplay().split(" ");
			if(args.length < 4)
			{
				channel.sendMessage("Ein, oder mehrere Argumente sind Leer!").queue();
			}
			else
			{

			try{
				seconds = Integer.parseInt(args[1]);
				minutes = Integer.parseInt(args[2]);
				hours = Integer.parseInt(args[3]);
				
			}
			catch(Exception ignored)
			{
				message.getChannel().sendMessage("Die angegebene Zeit muss eine zahl sein!").queue();
				return;
			}
			
			VerlosungsObjekt = String.join(" ", Arrays.copyOfRange(args, 4, args.length - 0));
			
			endTime = System.currentTimeMillis() + (seconds * 1000) + (minutes * 60 * 1000) + (hours * 60 * 60 * 1000);
			Date date = new Date(endTime - System.currentTimeMillis() - 3600000);
			
			EmbedBuilder eb = new EmbedBuilder();
			eb.setTitle("🎉" + "Verlosung" + "🎉");
			eb.addField("Zu Verlosendes Objekt:", VerlosungsObjekt, true);
			eb.addField("Übrige zeit: ", formatter.format(date), true);
			eb.setColor(Color.red);
			
			Message Rmessage = message.getChannel().sendMessage(eb.build()).complete();

			
			Rmessage.editMessage(eb.build()).complete();
					
			Rmessage.addReaction("🎉").queue();	  
			
			long c = endTime - System.currentTimeMillis() - 600000;
					
			
			while(c > 0)
			{
				new java.util.Timer().schedule(
						new java.util.TimerTask() {
							
							@Override
							public void run()
							{
								Rmessage.editMessage(eb.build()).queue();
							}
						},
						c = c - 600000
						);
			}
			
			new java.util.Timer().schedule(
					new java.util.TimerTask() {
						

						@Override
						public void run() 
						{
							User Winner;
							
							for (MessageReaction i : Rmessage.getReactions()) {
							    if (i.getReactionEmote().isEmoji()) {
							        if (i.getReactionEmote().getEmoji().equals("🎉")) {
							            List<User> Users = i.retrieveUsers().complete();
							            
							            if(Users.size() > 1)
										{
											Random rand = new Random();
											do
											{
												Winner = Users.get(rand.nextInt(Users.size()));
											}
											while(Winner.isBot());
											
											channel.sendMessage("Gewonnen hat " + Winner.getAsMention() + "🎉").queue(); 
										}
							            
							            break;
							        }
							    }
							}	
							
						}
						
						
					},
					endTime - System.currentTimeMillis()
					);
			
			}
			
			
				
		}
		else
		{
			channel.sendMessage("Unzureichende Berechtigungen!").queue();
		}
		}
		
		
	}