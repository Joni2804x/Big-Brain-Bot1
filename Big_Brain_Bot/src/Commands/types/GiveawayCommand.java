package Commands.types;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class GiveawayCommand implements ServerCommand {

	@Override
	public void performCommand(Member p, TextChannel channel, Message message) {
		
		String VerlosungsObjekt;
		String VerlosungsDauer;
		String VerlosungsRolle;
		
		String[] args = message.getContentDisplay().split(" ");
		
		
		if(p.hasPermission(Permission.ADMINISTRATOR)) 
		{
			VerlosungsObjekt = args[0];
			VerlosungsDauer = args[1];		
			
			channel.sendMessage("Welche Rolle soll teilnehmen?").queue();
			
			VerlosungsRolle = args[2];
			
			channel.sendMessage(VerlosungsObjekt + " " + VerlosungsDauer + " " + VerlosungsRolle).queue();
			
			
			
			
		}
		else
		{
			channel.sendMessage("Unzureichende Berechtigungen!").queue();
		}
		
	}

}
