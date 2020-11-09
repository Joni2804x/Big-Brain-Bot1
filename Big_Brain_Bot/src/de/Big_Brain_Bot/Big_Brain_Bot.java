package de.Big_Brain_Bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


import javax.security.auth.login.LoginException;

import de.Big_Brain_Bot_listener.Command_listener;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

public class Big_Brain_Bot {
	
	public static Big_Brain_Bot INSTANCE;
	
	public ShardManager shardMan;
	private CommandManager cmdMan;
	private Thread Loop;

	public static void main(String[] args)  {
		try {
			new Big_Brain_Bot();
		} catch (LoginException | IllegalArgumentException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	
	public Big_Brain_Bot() throws LoginException, IllegalArgumentException {	
		INSTANCE = this;
		
		
		DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault("yes");
		
		builder.setActivity(Activity.playing("mit sich selbst"));
		builder.setStatus(OnlineStatus.ONLINE);
		
		this.cmdMan = new CommandManager();
		
		
		builder.addEventListeners(new Command_listener());
		
		shardMan = builder.build();
		System.out.println("Bot online");
		
		shutdown();
		runloop();
		
		
		
		
		

	}

	
	public void shutdown() {
		
		new Thread(()  -> {
			
			String line = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			 try {
				while((line = reader.readLine()) !=null) {
					
					if(line.equalsIgnoreCase("exit")) {
						if(shardMan != null) {
							shardMan.setStatus(OnlineStatus.OFFLINE);
							shardMan.shutdown();
							System.out.println("Bot offline");
						}
						
						if(Loop != null) {
							Loop.interrupt();
						}
						
						reader.close();
						
					}
					else {
						System.out.println("exit benutzen um Herunter zu fahren");
					}
					
				}
				
			}catch (IOException e) {
				e.printStackTrace();
				
			}
			
			
		}).start();
	}
	
	public void runloop() {
		this.Loop = new Thread(() -> {
			
			long time = System.currentTimeMillis();
			
			while(true) {
				if(System.currentTimeMillis() >= time + 1000) {
					time = System.currentTimeMillis();
					onSecond();
				}
				
			}
			
			
		});
		this.Loop.setName("Loop");	
		this.Loop.start();
		
		
	}
	
	String[] status = new String[] {"mit sich selbst.","mit dem Stromkabel.", "mit kleinen Kindern.", "mit %members Discord Usern.", "benutze !bHilfe für meine Funktionen" }; // 
	int next = 15;
	
	public void onSecond() {
		if(next <= 0) {
			Random rand = new Random();
			int i = rand.nextInt(status.length);
			
			shardMan.getShards().forEach(jda -> {
				String text = status[i].replaceAll("%members", "" + jda.getUsers().size());
				
				jda.getPresence().setActivity(Activity.playing(text));
			});
			next = 15;
		}
		else {
			next--;
		}
		
		
	}
	
	
	public CommandManager getCmdMan() {
		return cmdMan;
	}
	
	
}
