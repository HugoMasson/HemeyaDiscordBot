package fr.kaze.events;

import fr.kaze.core.Info;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class OnlineCommand extends ListenerAdapter{
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		
		if(args[0].equalsIgnoreCase(Info.PREFIX + "online")) {
			int online = 0;
			for(int i = 0; i < event.getGuild().getMembers().size(); i++) {
				if(event.getGuild().getMembers().get(i).getOnlineStatus() == OnlineStatus.ONLINE
						|| event.getGuild().getMembers().get(i).getOnlineStatus() == OnlineStatus.DO_NOT_DISTURB) {
					online++;
				}
			}
			event.getChannel().sendMessage("There are "+online+" users online out of "+event.getGuild().getMemberCount()+ " ```diff\n-|DON'T WORK|```").queue();
		} else if(args[0].equalsIgnoreCase(Info.PREFIX + "onlineHere")) {
			int onlineHere = 0;
			for(int i = 0; i < event.getChannel().getMembers().size(); i++) {
				if(event.getChannel().getMembers().get(i).getOnlineStatus() == OnlineStatus.ONLINE
						|| event.getChannel().getMembers().get(i).getOnlineStatus() == OnlineStatus.DO_NOT_DISTURB) {
					onlineHere++;
				}
			}
			event.getChannel().sendMessage("There are "+onlineHere+" users online out of "+event.getChannel().getMembers().size()+" in this channel ```diff\n-|DON'T WORK|```").queue();
		}
	}
}
