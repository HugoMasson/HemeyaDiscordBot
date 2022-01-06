package fr.kaze.core;

import javax.security.auth.login.LoginException;

import fr.kaze.dataBase.DataBaseConnector;
import fr.kaze.events.Bye;
import fr.kaze.events.DevToDoList;
import fr.kaze.events.GiveUp;
import fr.kaze.events.GuildMessageReactionAdd;
import fr.kaze.events.GuildMessageReceived;
import fr.kaze.events.Hi;
import fr.kaze.events.MyWebsites;
import fr.kaze.events.OnlineCommand;
import fr.kaze.events.RoleHandler;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class Main {

	public static void main(String[] args) throws LoginException {
		//DataBaseConnector.connectionDB();
		
		JDABuilder jda = JDABuilder.createDefault("OTI1NTcyMDQ1NTE1OTM1NzU2.YcvEIw.Iwb0kSr4jHv1oVnBEW9ZHS2DgGk");
		jda.setActivity(Activity.playing("Hating humans"));
		jda.setStatus(OnlineStatus.ONLINE);
		
		jda.addEventListeners(new Commands());
		jda.addEventListeners(new OnlineCommand());
		jda.addEventListeners(new GuildMessageReceived());
		jda.addEventListeners(new GuildMessageReactionAdd());
		jda.addEventListeners(new Hi());
		jda.addEventListeners(new Bye());
		jda.addEventListeners(new RoleHandler());
		jda.addEventListeners(new MyWebsites());
		jda.addEventListeners(new DevToDoList());
		jda.addEventListeners(new GiveUp());
		
		jda.setChunkingFilter(ChunkingFilter.ALL);
		jda.setMemberCachePolicy(MemberCachePolicy.ALL);
		jda.enableIntents(GatewayIntent.GUILD_MEMBERS);
		jda.enableIntents(GatewayIntent.GUILD_PRESENCES);
		
		jda.build();
		
	}
	
	/*
	 * REFACTOR CODE THAT'S A PRIORITY do something like that instead of ifs else !!!
	 * 		https://www.youtube.com/watch?v=NevtahMI0Ks
	 * 
	 * CREATE A CHANNEL TO PUT ALL THE LOGS AND INFOS !!!
	 * 
	 * ADD A DEV TO DO (with classification todo for the bot / other projects)
	 * 
	 * ToDo currently can't give text with space (because spaces are split)
	 * 
	 * Find a solution for that + start databases this kind of thing
	 * 
	 * Think of a connection with hugocode.com (api oe somthing to "link" to bot with another system)
	 * Something like a ping server / update bot (really good idea and hard as fk lol)
	 * 
	*/
}
