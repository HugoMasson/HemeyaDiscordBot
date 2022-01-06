package fr.kaze.events;

import fr.kaze.core.Info;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GiveUp extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		if(args[0].equalsIgnoreCase(Info.PREFIX + "IGiveUp") || 
				args[0].equalsIgnoreCase(Info.PREFIX + "tooHard")) {
			event.getMessage().reply("No you can't give up hmm 🥺").queue();
		}
	}
}
