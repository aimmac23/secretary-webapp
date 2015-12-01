package com.aimmac23.secretary.irc;
import java.io.IOException;
import java.net.UnknownHostException;

import com.aimmac23.secretary.plexiglas.PlexiglasInterface;
import com.sorcix.sirc.Channel;
import com.sorcix.sirc.IrcConnection;
import com.sorcix.sirc.MessageListener;
import com.sorcix.sirc.NickNameException;
import com.sorcix.sirc.PasswordException;
import com.sorcix.sirc.User;

public class IRCHandler {
	
	private IrcConnection ircConnection;
	private PlexiglasInterface plexiglas;

	public IRCHandler(PlexiglasInterface plexiglas) throws UnknownHostException, IOException, NickNameException, PasswordException {
		this.plexiglas = plexiglas;
		ircConnection = new IrcConnection("127.0.0.1");
		ircConnection.setNick("bot");
		ircConnection.connect();
		Channel testChannel = ircConnection.createChannel("test");
		testChannel.join();
		
		ircConnection.addMessageListener(new MyMessageListener());
		
	}
	
	private class MyMessageListener implements MessageListener {

		@Override
		public void onAction(IrcConnection irc, User sender, Channel target, String action) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAction(IrcConnection irc, User sender, String action) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onCtcpReply(IrcConnection irc, User sender, String command, String message) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onMessage(IrcConnection irc, User sender, Channel target, String message) {
			if(message.contains("on")) {
				plexiglas.turnOn();
			}
			else {
				plexiglas.turnOff();
			}
			
		}

		@Override
		public void onNotice(IrcConnection irc, User sender, Channel target, String message) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onNotice(IrcConnection irc, User sender, String message) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPrivateMessage(IrcConnection irc, User sender, String message) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
