package fr.kaze.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class MessageHandler {

	
	public static void reply(GuildMessageReceivedEvent event, String mess) {
		event.getMessage().reply(mess).queue();
	}
	
	public static void sendMessage(GuildMessageReceivedEvent event, String mess) {
		event.getChannel().sendMessage(mess).queue();
	}
}
