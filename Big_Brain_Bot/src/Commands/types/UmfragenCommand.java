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
			Emote one = message.getGuild().getEmoteById("796585138846564382");
			Emote two = message.getGuild().getEmoteById("796585156751917076");
			Emote three = message.getGuild().getEmoteById("796585404958375946");
			User author = p.getUser();
			
			int seconds;
			int minutes = 0; 
			int hours = 0;
			int result1 = 1;
			int result2 = 1;
			int result3 = 1;
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
			eb.addField("Übrige Zeit: ", formatter.format(date) , true);
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
				
			
			
			
			
			long c = endTime - System.currentTimeMillis() - 600000;
			
			while(c > 0)
			{
				timer.schedule(
						new java.util.TimerTask() {
							
							@Override
							public void run()
							{
								Rmessage.editMessage(eb.build()).queue();
							}
						},
						c
						);
						c = c - 600000;
			}
			
			timer.schedule(
					new java.util.TimerTask() 
					{
						
						public void run() 
						{
							System.out.println("Debug");
							
							for (MessageReaction i : message.getChannel().getHistory().getMessageById(ID).getReactions()) 
                            {
                                if(i.getReactionEmote().getEmote().equals(one))
                                {
                                	RestAction<Message> messages = channel.retrieveMessageById(ID);
        							Message msg = messages.complete();
        							List<User> membs = new ArrayList<>();
        							for (MessageReaction reaction : msg.getReactions()){
        								if (reaction.getReactionEmote().getIdLong() == GiveawayEmote) {
        								      membs.addAll(reaction.retrieveUsers().complete());
        								      
        								      
        								}
        							}
                                }

                                if(i.getReactionEmote().getEmote().equals(two))
                                {
                                    //result2 = "number of people that reacted with this emote" - 1;
                                }

                                if(i.getReactionEmote().getEmote().equals(three))
                                {
                                    //result3 = "number of people that reacted with this emote" - 1;
                                }
                                break;
                            }
							
							author.openPrivateChannel().complete().sendMessage(
							"Die Umfrage wurde beendet!" + "\nDie Frage lautete: " + frage
							+ "\nDie verfügbaren Optionen waren: " + "\n1." + args[2] 
							+ "\n2." + args[3]
							+ "\n3." + args[4]
							+ "\nDie Ergebnisse lauten: "	
							+ result1 + " Stimme/n für " + args[2]
							+ result2 + " Stimme/n für " + args[3]
							+ result3 + " Stimme/n für " + args[4]).complete();
							
						}
						
						
					},
					endTime - System.currentTimeMillis()
					);
			
			
			//message.getChannel().sendMessage("✅").complete().delete().queueAfter(3, TimeUnit.SECONDS);
		
		}
		
	}

}
