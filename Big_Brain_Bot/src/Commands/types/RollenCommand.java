package Commands.types;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;

public class RollenCommand implements ServerCommand {

	@Override
	public void performCommand(Member p, TextChannel channel, Message message) 
	{
		
		
		Emote Eins = message.getGuild().getEmoteById("809091148189532202");
		Emote Zwei = message.getGuild().getEmoteById("809091174726893688");
		Emote Drei = message.getGuild().getEmoteById("809091205325127750");
		Emote Vier = message.getGuild().getEmoteById("809091231111184425");
		Emote Fünf = message.getGuild().getEmoteById("809091256968937482");
		Emote Sechs = message.getGuild().getEmoteById("809091282907037696");
		
		if(p.hasPermission(Permission.ADMINISTRATOR))
		{
			EmbedBuilder eb = new EmbedBuilder();
			eb.setTitle("Rollenauswahl!");
			eb.addField(" ", "Diese Nachricht dient dazu, dass ihr euch die Relevanten Rollen selber aussuchen könnt. Die Rollen dienen dazu gezielte Pings an die Leute"
					+ "zu schicken, die das auch möchten. "
					+ "\nWir haben: "
					+ "\n"
					+ "\n1. Allgemein[Pings mit Allgemein "
					+ "relevanten Sachen] "
					+ "\n2. SCP:SL"
					+ "\n3. Heroes&Generals"
					+ "\n4. Hearts of Iron 4"
					+ "\n5. Stellaris"
					+ "\n6. Cities Skylines", true);
			eb.setColor(Color.DARK_GRAY);
			
			Message Rmessage = message.getChannel().sendMessage(eb.build()).complete();
			String ID = Rmessage.getId();

			Rmessage.addReaction(Eins).queue();
			Rmessage.addReaction(Zwei).complete();
			Rmessage.addReaction(Drei).complete();
			Rmessage.addReaction(Vier).complete();
			Rmessage.addReaction(Fünf).complete();
			Rmessage.addReaction(Sechs).complete();
			
		
		}
		
	}
	
	


}
