package fr.kaze.events;

import fr.kaze.core.Info;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DevToDoList extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		if(args[0].equalsIgnoreCase(Info.PREFIX + "addDev")) {
			event.getMessage().reply("Launching devToDo...").queue();
		}
	}
}
