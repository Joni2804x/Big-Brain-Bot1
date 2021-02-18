package de.Big_Brain_Bot_listener;


import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.MessageReaction.ReactionEmote;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RollenListener extends ListenerAdapter {
	
	
	public void onMessageReactionAddEvent(MessageReactionAddEvent event)
	{
		if(event.getMessageId() == "811722098812780624")
		{
			String messageS = "811722098812780624";
			MessageChannel channel = event.getChannel();
			Message message = channel.getHistory().getMessageById(messageS);
			
			String Eins = "809091148189532202";
			String Zwei = "809091174726893688";
			String Drei = "809091205325127750";
			String Vier = "809091231111184425";
			String Fünf = "809091256968937482";
			String Sechs = "809091282907037696";
			
			Long leins = Long.parseLong(Eins);
			Long lzwei = Long.parseLong(Zwei);
			Long ldrei = Long.parseLong(Drei);
			Long lvier = Long.parseLong(Vier);
			Long lfünf = Long.parseLong(Fünf);
			Long lsechs = Long.parseLong(Sechs);
			
			Role allgemein = message.getGuild().getRoleById("753994864290562141");
			Role scpsl = message.getGuild().getRoleById("753994779452375100");
			Role hg = message.getGuild().getRoleById("753994840835883108");
			Role hoi4 = message.getGuild().getRoleById("809140303478259753");
			Role stellaris = message.getGuild().getRoleById("809140413125492837");
			Role citiesskylines = message.getGuild().getRoleById("809140450857451610");
			
			MessageReaction reaction = event.getReaction();

			Member member = event.getMember();
			
			if(reaction.getReactionEmote().getIdLong() == leins )
			{
				message.getGuild().addRoleToMember(member, allgemein).complete();
			}
			
			if(reaction.getReactionEmote().getIdLong() == lzwei )
			{
				message.getGuild().addRoleToMember(member, scpsl).complete();
			}
			
			if(reaction.getReactionEmote().getIdLong() == ldrei )
			{
				message.getGuild().addRoleToMember(member, hg).complete();
			}
			
			if(reaction.getReactionEmote().getIdLong() == lvier )
			{
				message.getGuild().addRoleToMember(member, hoi4).complete();
			}
			
			if(reaction.getReactionEmote().getIdLong() == lfünf )
			{
				message.getGuild().addRoleToMember(member, stellaris).complete();
			}
			
			if(reaction.getReactionEmote().getIdLong() == lsechs )
			{
				message.getGuild().addRoleToMember(member, citiesskylines).complete();
			}
		}
	}

}
