package fr.kaze.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReceived extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if(event.getMember().getUser().equals(event.getJDA().getSelfUser())) {
			event.getMessage().addReaction("❌").queue();
		}
	}
}
