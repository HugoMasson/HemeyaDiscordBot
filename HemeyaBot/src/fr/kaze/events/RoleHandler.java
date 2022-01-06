package fr.kaze.events;

import java.util.List;
import java.awt.Color;
import fr.kaze.commands.MessageHandler;
import fr.kaze.core.Info;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RoleHandler extends ListenerAdapter{
	
	public boolean doesRoleExists(GuildMessageReceivedEvent event, String roleName) {
		List<Role> roles = event.getGuild().getRolesByName(roleName, false);
		if(roles.size() >= 1) {
			return true;
		}
		return false;
	}
	
	public void createRole(GuildMessageReceivedEvent event, String roleName, long permissionCode) {
		if(permissionCode != -999) {	//Conversion string to long error
			event.getGuild().createRole()
			.setName(roleName)
			.setColor(Color.white)
			.setHoisted(true)
			.setPermissions(permissionCode)
			.setMentionable(false)
			.queue(role -> {
				MessageHandler.reply(event,"Role `"+roleName+"` created with `"+permissionCode+"` as permission code.");
			});
		}
	}
	
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		if(args[0].equalsIgnoreCase(Info.PREFIX + "giverole")) {			//GIVE a role and if param given take back after x millis
			if(event.getMessage().getMentionedRoles().toArray().length == 1) {
				if(event.getMessage().getMentionedUsers().toArray().length > 0) {
					List<User> users = event.getMessage().getMentionedUsers();
					for(int i = 0; i < users.size(); i++) {
						Member m = event.getGuild().getMember(users.get(i));
						Role roleToGive = event.getMessage().getMentionedRoles().get(0);
						event.getGuild().addRoleToMember(m, roleToGive).queue();
						event.getMessage().reply("Gave the role "+roleToGive.getAsMention() + " to "+m.getAsMention()).queue();
						try { 
							new java.util.Timer().schedule(new java.util.TimerTask() {
								@Override
								public void run() {
									event.getGuild().removeRoleFromMember(m, roleToGive).queue();
									event.getMessage().reply("Removed the role "+roleToGive.getAsMention() + " to "+m.getAsMention() + " after "+args[args.length-1]+"s").queue();
								}
							},Integer.parseInt(args[args.length-1])*1000);
						} catch (NumberFormatException e){  }
					}
				}
			} else {
				event.getMessage().reply("Only mention 1 role to give").queue();
			}
		} else if(args[0].equalsIgnoreCase(Info.PREFIX + "removerole")) {
			if(event.getMessage().getMentionedRoles().toArray().length == 1) {
				if(event.getMessage().getMentionedUsers().toArray().length > 0) {
					List<User> users = event.getMessage().getMentionedUsers();
					for(int i = 0; i < users.size(); i++) {
						Member m = event.getGuild().getMember(users.get(i));
						Role roleToGive = event.getMessage().getMentionedRoles().get(0);
						event.getGuild().removeRoleFromMember(m, roleToGive).queue();
						event.getMessage().reply("Removed the role "+roleToGive.getAsMention() + " to "+m.getAsMention()).queue();
					}
				}
			} else {
				event.getMessage().reply("Only mention 1 role to remove").queue();
			}
		} else if(args[0].equalsIgnoreCase(Info.PREFIX + "doesRoleExists")) {
			if(!doesRoleExists(event, args[1])) { 
				MessageHandler.reply(event, "A role with name `"+args[1]+"` does not exists. Create one ? (Y/n)");
			} else {
				MessageHandler.reply(event, "A role with name `"+args[1]+"` exists.");
			}
		}
	}

}
