package de.Big_Brain_Bot_listener;

import de.Big_Brain_Bot.Big_Brain_Bot;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.List;
import java.util.Random; 



public class Command_listener extends ListenerAdapter {
	
	
	
	
@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		
		String message = event.getMessage().getContentDisplay();
		
		if(event.isFromType(ChannelType.TEXT)) {
			TextChannel channel = event.getTextChannel();
		
			if(message.startsWith("!bb")) {
				String[] args = message.substring(3).split(" ");

				if(args.length > 0); {
						if(!Big_Brain_Bot.INSTANCE.getCmdMan().perform(args[0], event.getMember(), channel, event.getMessage())) {
							channel.sendMessage("Unbekannter Befehl").queue();
						}
	
				
			}
			
		}
			else if(message.toLowerCase().startsWith("prost") || message.toLowerCase().startsWith("proscht")) {	
				channel.sendMessage(event.getMember().getAsMention() + " Prost" + "!\n " + "https://tenor.com/view/u%c3%b4%cc%81ng-bia-ca%cc%a3n-ly-nh%c3%a2%cc%a3u-bia-drinking-beer-gif-12467691").queue();
				
			}
			else if(message.toLowerCase().startsWith("ich bin ") ||message.toLowerCase().startsWith("i'm") || message.toLowerCase().startsWith("i am ") ) {
				String args = message.substring(8);
				channel.sendMessage("Hallo " + args + ", Ich bin Vater!").queue();
			}
			else if(message.startsWith("Gurke") ||message.startsWith("gurke") ) {
				channel.sendMessage("https://tenor.com/view/cucumber-pickle-chop-unsolicited-nopeen-gif-17851416").queue();				
			}
			else if(message.startsWith("!bWitz")) {
				
				List<String> givenList = Arrays.asList("Was ist der schnellste Zug der Welt? Der franz�sische R�ckzug", "L�uft der Neger frei herum, schalt auf automatik um", "Mir war kalt, also habe ich den Au�en-Ventilator abgestellt. Die anderen Flugg�ste im Helikopter fanden das nicht so toll.", "Du Paul ich habe mal eine Frage. Hast du jetzt endlich eine feste Freundin? Nein, ich habe immer noch die Wabblige.", "Was ist grau und kann nicht fliegen? Eine zu fette Taube.", "Sag mal, ist der Fisch immer so nervig? Ja, er ist ein St�r.", "Von all diesen Witzen kriege ich die Budapest", "Wie war die Stimmung in der DDR? Sie hielt sich so ziemlich in Grenzen.", "Anton, findest du, dass ich dir eine schlechte Mutter bin? Ich hei�e Paul.", "Wenn du nusst, aber sie immernoch deinen Christian Lindnert", "Ich w�rde dir jetzt einen Russen-witz erz�hlen, aber jemand Stalingrad", "Haben sie Angst vor Asiaten? Ja panisch.", "Ich schlafe gerne nackt. Da kann die Stewardess noch so b�se kucken.", "treffen sich 2 Psychiater: Heil Hitler! | mach selber", "Wie viele g�nge hat ein franz�sischer Panzer? 7 r�ckwarts-g�nge und ein vorw�rtsgang, falls der Feind von hinten kommt", "Wie sieht die franz�sische Kriegsflagge aus? wei�er Adler auf wei�em Grund" ); 																		
			    Random rand = new Random();
			    String randomElement = givenList.get(rand.nextInt(givenList.size()));
			  	channel.sendMessage(randomElement).queue();
			  	
		    }
			else if(message.startsWith("HANS!")) {
				channel.sendMessage("https://tenor.com/view/blow-torch-soldier-kill-it-kill-it-fire-nope-gif-12153236").queue();
			}
			else if(message.startsWith("!bHilfe")) {
				channel.sendMessage("-!bWitz --> Ich erz�hle einen Witz\n" +
			 "-Prost --> Ich w�nsche dir Prost\n" +
			 "-Ich bin --> auf S�tze die mit |Ich bin| beginnen, antworte ich mit |Hallo + Nachricht + Ich bin Vater|\n" +
			 "-Gurke --> Ich sende eine Gurke\n" +
			 "-HANS! --> I get ze Flammenwerfer!\n").queue();
			}
			
			
			    
						
					}
		
	}
	}