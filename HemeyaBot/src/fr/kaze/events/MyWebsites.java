package fr.kaze.events;

import fr.kaze.core.Info;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MyWebsites extends ListenerAdapter{
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		if(args[0].equalsIgnoreCase(Info.PREFIX + "hugocode")) {
			if(args.length > 1) {
				if(args[1].equalsIgnoreCase("anthill")) {
					event.getChannel().sendMessage("https://hugocode.com/anthill/antSimulation.php").queue();
				} else if(args[1].equalsIgnoreCase("quadtree")) {
					event.getChannel().sendMessage("https://hugocode.com/anthill/").queue();
				}
			}
		}
	}
	
	
	
}
