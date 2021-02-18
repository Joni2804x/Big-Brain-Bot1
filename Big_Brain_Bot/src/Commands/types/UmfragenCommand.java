package Commands.types;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.RestAction;

public class UmfragenCommand implements ServerCommand {

	@Override
	public void performCommand(Member p, TextChannel channel, Message message) {
		
		if(p.hasPermission(Permission.KICK_MEMBERS))
		{
			Timer timer = new Timer();
			Emote one = message.getGuild().getEmoteById("809091148189532202");
			Emote two = message.getGuild().getEmoteById("809091174726893688");
			Emote three = message.getGuild().getEmoteById("809091205325127750");
			
			String Sone = "809091148189532202";
			String Stwo = "809091174726893688";
			String Sthree = "809091205325127750";
			
			User author = p.getUser();
			
			int seconds;
			int minutes = 0; 
			int hours = 0;
			long endTime;
			String[] args = message.getContentRaw().split(" ");
			String frage = String.join(" ", Arrays.copyOfRange(args, 5, args.length - 0));
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
			
			try
			{
				seconds = Integer.parseInt(args[1]);	
			}
			catch(Exception ignored)
			{
				message.getChannel().sendMessage("Die angegebene Zeit muss eine zahl sein!").queue();
				return;
			}
			
			endTime = System.currentTimeMillis() + (seconds * 1000) + (minutes * 60 * 1000) + (hours * 60 * 60 * 1000);
			Date date = new Date(endTime - System.currentTimeMillis() - 3600000);
			
			EmbedBuilder eb = new EmbedBuilder();
			eb.setTitle("!Umfrage!");
			eb.addField("Frage: ", frage, true);
			eb.addField("Angegebene Zeit: ", formatter.format(date) , false);
			eb.addField("Option 1: ", args[2], true);
			eb.addField("Option 2: ", args[3], true);
			eb.addField("Option 3:", args[4], true);
			
			if(args.length < 4)
			{
				message.getChannel().sendMessage("Es müssen mindestens 2 Optionen zur Auswahl stehen!").complete().delete().queueAfter(3, TimeUnit.SECONDS);
				return;
			}		
			
			eb.setColor(Color.BLUE);
			
			Message Rmessage = message.getChannel().sendMessage(eb.build()).complete();
			
			Rmessage.addReaction(one).queue();
			Rmessage.addReaction(two).queue();
			Rmessage.addReaction(three).queue();
			
			String ID = Rmessage.getId();
			
			Long Lone = Long.parseLong(Sone);
			Long Ltwo = Long.parseLong(Stwo);
			Long Lthree = Long.parseLong(Sthree);
				
			
			
			timer.schedule(
					new java.util.TimerTask() 
					{
						
						public void run() 
						{
							System.out.println("Debug");
							
							EmbedBuilder peb = new EmbedBuilder();
							
                                	RestAction<Message> messages = channel.retrieveMessageById(ID);
        							Message msg = messages.complete();
        							List<User> res1 = new ArrayList<>();
        							for (MessageReaction reaction : msg.getReactions()){
        								if (reaction.getReactionEmote().getIdLong() == Lone) {
        								      res1.addAll(reaction.retrieveUsers().complete());
        								      res1.remove(msg.getJDA().getSelfUser());
        								      
        								      
        								    		  peb.setTitle("Die Umfrage wurde beendet!");
          								    		  peb.addField("Die Frage Lautete: ", frage, true);
        								    		  peb.addField("Die Ergebnisse lauten: ", res1.size() + " Stimmen für " + args[2], false);
        								    		   
        								    		    
        								      
        								}
        							}
                                

                                
                                	RestAction<Message> messages2 = channel.retrieveMessageById(ID);
        							Message msg2 = messages2.complete();
        							List<User> res2 = new ArrayList<>();
        							for (MessageReaction reaction : msg2.getReactions()){
        								if (reaction.getReactionEmote().getIdLong() == Ltwo) {
        								      res2.addAll(reaction.retrieveUsers().complete());
        								      res2.remove(msg2.getJDA().getSelfUser());
        								      
        								      
        								    		  peb.addField(" ", res2.size()  + " Stimmen für " + args[3], false);
        								     
        								      
        								}
        							}
        							
                                
                                

                                
                                	RestAction<Message> messages3 = channel.retrieveMessageById(ID);
        							Message msg3 = messages3.complete();
        							List<User> res3 = new ArrayList<>();
        							for (MessageReaction reaction : msg3.getReactions()){
        								if (reaction.getReactionEmote().getIdLong() == Lthree) {
        								      res3.addAll(reaction.retrieveUsers().complete());
        								      res3.remove(msg3.getJDA().getSelfUser());
        								      
        								     
        								    		  peb.addField(" ", res3.size()  + " Stimmen für " + args[4], false);
        								    		  author.openPrivateChannel().complete().sendMessage(peb.build()).complete();
        								     
        								      
        								}
        							}
                                	
                            Rmessage.getChannel().sendMessage("Die Umfrage wurde beendet!").queue();
                                
                            }
							
							
						
						
						
					},
					endTime - System.currentTimeMillis()
					);
				
			
			
			//message.getChannel().sendMessage("âœ…").complete().delete().queueAfter(3, TimeUnit.SECONDS);
		
		}
		
	}

}
