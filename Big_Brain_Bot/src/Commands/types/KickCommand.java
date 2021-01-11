package Commands.types;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public class KickCommand implements ServerCommand {

	@Override
	public void performCommand(Member p, TextChannel channel, Message message) {
		
		if(p.hasPermission(Permission.KICK_MEMBERS))
		{
			String[] args = message.getContentRaw().split(" ");
			
			
			
			if(args.length < 1)
			{
				message.getChannel().sendMessage("Du musst einen User angeben!").queue();
			return; }
			else if(args.length < 2)
			{
				message.getChannel().sendMessage("Du musst einen Grund angeben!").queue();
			return; }
			
			Member target = message.getMentionedMembers().get(0);	
			
			User user = target.getUser();
			if(!target.getUser().isBot())
			{
			user.openPrivateChannel().complete().sendMessage(
					"Du wurdest gekickt" +"\nGrund: " + String.join(" ", Arrays.copyOfRange(args, 2, args.length - 0))).complete();
			}
				
			message.getGuild().kick(target).queueAfter(1, TimeUnit.SECONDS);
			
			message.getChannel().sendMessage("✅").complete().delete().queueAfter(3, TimeUnit.SECONDS);
			
		}
		
	}

}
