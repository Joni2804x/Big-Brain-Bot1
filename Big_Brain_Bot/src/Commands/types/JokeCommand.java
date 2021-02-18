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
		List<String> givenList = Arrays.asList(
				 "Was ist der schnellste Zug der Welt? Der franz�sische R�ckzug"
				,"L�uft der Neger frei herum, schalt auf automatik um"
				, "Mir war kalt, also habe ich den Au�en-Ventilator abgestellt. Die anderen Flugg�ste im Helikopter fanden das nicht so toll."
				, "Du Paul ich habe mal eine Frage. Hast du jetzt endlich eine feste Freundin? Nein, ich habe immer noch die Wabblige."
				, "Was ist grau und kann nicht fliegen? Eine zu fette Taube."
				, "Sag mal, ist der Fisch immer so nervig? Ja, er ist ein St�r."
				, "Von all diesen Witzen kriege ich die Budapest"
				, "Wie war die Stimmung in der DDR? Sie hielt sich so ziemlich in Grenzen."
				, "Anton, findest du, dass ich dir eine schlechte Mutter bin? Ich hei�e Paul."
				, "Wenn du nusst, aber sie immernoch deinen Christian Lindnert"
				, "Ich w�rde dir jetzt einen Russen-witz erz�hlen, aber jemand Stalingrad"
				, "Haben sie Angst vor Asiaten? Ja panisch."
				, "Ich schlafe gerne nackt. Da kann die Stewardess noch so b�se kucken."
				, "treffen sich 2 Psychiater: Heil Hitler! | mach selber"
				, "Wie viele G�nge hat ein franz�sischer Panzer? 7 r�ckwarts-G�nge und einen Vorw�rtsgang, falls der Feind von hinten kommt"
				, "Wie sieht die franz�sische Kriegsflagge aus? wei�er Adler auf wei�em Grund"
				, "Ich kann total gut Mitmenschen umgehen."
				, "Deine Mutter ist so fett, sie hat kleinere Frauen in ihrer Umlaufbahn"
				, "Deine Mutter zerrei�t Telefonb�cher bei Wetten das"
				, "Deine Mutter hat Hausverbot bei Fressnapf"
				, "Deine Mutter geht mit einer kaputten Brille zu Carglass"
				, "Deine Mutter arbeitet im Spiel als Grafikfehler"
				, "Bestraf mich! | sagte sie | Alles klar. | sagte er und installierte Windows 8 auf ihrem Laptop."
				, "Deine Mutter steht um 8 Uhr morgens vor Aldi und singt It's the final countdown"
				, "Niemand hat die absicht eine Mauer zu errichten"
				); 																		
	    Random rand = new Random();
	    String randomElement = givenList.get(rand.nextInt(givenList.size()));
	  	channel.sendMessage(randomElement).queue();	
	}
}

	
