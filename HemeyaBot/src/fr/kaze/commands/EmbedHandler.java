package fr.kaze.commands;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class EmbedHandler {

	public static void createEmbed(GuildMessageReceivedEvent event, String title, String description, String[][] fields, Color color, String footerTxt, String footerIcon) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.setTitle(title);
		embed.setDescription(description);
		for(int i = 0; i < fields.length; i++) {
			embed.addField(fields[i][0], fields[i][1], false);
		}
		embed.setColor(color);
		embed.setFooter(footerTxt);
		event.getChannel().sendMessage(embed.build()).queue();
		embed.clear();
	}
	
}
