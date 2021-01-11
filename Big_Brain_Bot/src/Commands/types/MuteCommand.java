package Commands.types;

import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

public class MuteCommand implements ServerCommand {

	@Override
	public void performCommand(Member p, TextChannel channel, Message message) {
		
	if(p.hasPermission(Permission.VOICE_MUTE_OTHERS))
	{
		String[] args = message.getContentRaw().split(" ");
		
		int Minuten;
		
		if(args.length == 2)
		{
			Member member = message.getMentionedMembers().get(0);
			Role role = message.getGuild().getRoleById("793183920850075681");
			
			if(!member.getRoles().contains(role))
			{
				message.getChannel().sendMessage("Muted " + args[1] + ".").complete().delete().queueAfter(3, TimeUnit.SECONDS);
				message.getGuild().addRoleToMember(member, role).complete();
			}
			else
			{
				message.getChannel().sendMessage("Unmuted " + args[1] + ".").complete().delete().queueAfter(3, TimeUnit.SECONDS);
				message.getGuild().removeRoleFromMember(member, role).complete();
				
		}
		}
		else if(args.length == 3) 
		{
			Member member = message.getMentionedMembers().get(0);
			Role role = message.getGuild().getRoleById("793183920850075681");
			
			message.getChannel().sendMessage("Muted " + args[1] + " für " + args[2] + " Minuten.").complete().delete().queueAfter(3, TimeUnit.SECONDS);
			message.getGuild().addRoleToMember(member, role).complete();
			
			try
			{
				Minuten = Integer.parseInt(args[2]) * 60000;
			} catch(Exception ignored)
			{
				message.getChannel().sendMessage("Die Zeitangabe muss eine Zahl sein!").queue();
				return;
			}
			
				new java.util.Timer().schedule(
					new java.util.TimerTask() {

						@Override
						public void run() {
							message.getChannel().sendMessage("Unmuted " + args[1] + ".").complete().delete().queueAfter(3, TimeUnit.SECONDS);
							message.getGuild().removeRoleFromMember(member, role).complete();							
						}
					},
					Minuten
					);

			
		}
		else
		{
			message.getChannel().sendMessage("Die Formatierung lautet: [User] [Zeit in Minuten(Optional)]").queue();
		}
		
		if(args[1].isEmpty())
		{
			message.getChannel().sendMessage("Es muss ein User angegeben werden").queue();
		}
	
	}
	}

}
