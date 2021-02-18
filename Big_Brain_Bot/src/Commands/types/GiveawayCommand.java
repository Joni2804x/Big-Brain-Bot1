package Commands.types;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.MessageReaction.ReactionEmote;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.pagination.ReactionPaginationAction;

public class GiveawayCommand implements ServerCommand{

	@Override
	public void performCommand(Member p, TextChannel channel, Message message) {
		
		String VerlosungsObjekt;
		int seconds;
		int minutes;
		int hours;
		long endTime;
		int verlosung;
		Timer timer = new Timer();
		String Emote = "794316713524461609";
		Guild guild;
		
		
		
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        
           
		if(p.hasPermission(Permission.ADMINISTRATOR)) 
		{
	
			String[] args = message.getContentDisplay().split(" ");
			if(args.length < 4)
			{
				channel.sendMessage("Ein, oder mehrere Argumente sind Leer! Aktuelle Länge: " + args.length).queue();
			}
			else
			{

			try
			{
				seconds = Integer.parseInt(args[1]);
				minutes = Integer.parseInt(args[2]);
				hours = Integer.parseInt(args[3]);
				
			}
			catch(Exception ignored)
			{
				message.getChannel().sendMessage("Die angegebene Zeit muss eine zahl sein!").queue();
				System.out.println(args[1] + "," + args[2] + "," + args[3]);
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
			String ID = Rmessage.getId();
		

			Emote Giveaway = Rmessage.getGuild().getEmoteById("794316713524461609");
			Rmessage.addReaction(Giveaway).queue();	  
			long GiveawayEmote = Long.parseLong(Emote);
			
			
			Rmessage.editMessage(eb.build()).queue();
			
			channel.retrieveMessageById(ID).queue( Lmessage -> {
	            
	            System.out.println(Lmessage.getReactions().size() + " debug");
	            System.out.println("args Debug " + args[4]);
	            
	        });
					
			
			
			//long c = endTime - System.currentTimeMillis() - 600000;
			
			//while(c > 0)
			//{
			//	timer.schedule(
			//			new java.util.TimerTask() {
							
				//			@Override
					//		public void run()
						//	{
							//	Rmessage.editMessage(eb.build()).queue();
								//System.out.println(Rmessage.getReactions().size());
						//	}
						//},
						//c
						//);
						//c = c - 600000;
		//	}
			
				
				
					timer.schedule(
					new java.util.TimerTask() 
					{
						
						public void run() 
						
							{
					            RestAction<Message> messages = channel.retrieveMessageById(ID);
					            Message msg = messages.complete();
					            List<User> membs = new ArrayList<>();
					            msg.getReactions().forEach(reaction -> {
					                if (reaction.getReactionEmote().getIdLong() == GiveawayEmote) {
					                    membs.addAll(reaction.retrieveUsers().complete());
					                    membs.remove(msg.getJDA().getSelfUser());

					                }
					            });
					            int i = new Random().nextInt(membs.size());
					            Member m = p.getGuild().retrieveMember(membs.get(i)).complete();


					            Rmessage.getChannel().sendMessage("Gewonnen hat " + m.getAsMention() + "🎉").queue();
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