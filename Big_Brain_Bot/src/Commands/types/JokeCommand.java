package Commands.types;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class JokeCommand implements ServerCommand {

	@Override
	public void performCommand(Member p, TextChannel channel, Message message) 
	{
		List<String> givenList = Arrays.asList("Was ist der schnellste Zug der Welt? Der französische Rückzug", "Läuft der Neger frei herum, schalt auf automatik um", "Mir war kalt, also habe ich den Außen-Ventilator abgestellt. Die anderen Fluggäste im Helikopter fanden das nicht so toll.", "Du Paul ich habe mal eine Frage. Hast du jetzt endlich eine feste Freundin? Nein, ich habe immer noch die Wabblige.", "Was ist grau und kann nicht fliegen? Eine zu fette Taube.", "Sag mal, ist der Fisch immer so nervig? Ja, er ist ein Stör.", "Von all diesen Witzen kriege ich die Budapest", "Wie war die Stimmung in der DDR? Sie hielt sich so ziemlich in Grenzen.", "Anton, findest du, dass ich dir eine schlechte Mutter bin? Ich heiße Paul.", "Wenn du nusst, aber sie immernoch deinen Christian Lindnert", "Ich würde dir jetzt einen Russen-witz erzählen, aber jemand Stalingrad", "Haben sie Angst vor Asiaten? Ja panisch.", "Ich schlafe gerne nackt. Da kann die Stewardess noch so böse kucken.", "treffen sich 2 Psychiater: Heil Hitler! | mach selber", "Wie viele gänge hat ein französischer Panzer? 7 rückwarts-gänge und ein vorwärtsgang, falls der Feind von hinten kommt", "Wie sieht die französische Kriegsflagge aus? weißer Adler auf weißem Grund" ); 																		
	    Random rand = new Random();
	    String randomElement = givenList.get(rand.nextInt(givenList.size()));
	  	channel.sendMessage(randomElement).queue();	
	}
}

	