package com.aimmac23.secretary.irc;
import java.io.IOException;
import java.net.UnknownHostException;

import com.aimmac23.secretary.plexiglas.PlexiglasInterface;
import com.sorcix.sirc.Channel;
import com.sorcix.sirc.IrcConnection;
import com.sorcix.sirc.NickNameException;
import com.sorcix.sirc.PasswordException;

public class IRCHandler {
	
	private IrcConnection ircConnection;

	public IRCHandler(PlexiglasInterface plexiglas) throws UnknownHostException, IOException, NickNameException, PasswordException {
		ircConnection = new IrcConnection("127.0.0.1");
		ircConnection.setNick("bot");
		ircConnection.connect();
		Channel testChannel = ircConnection.createChannel("test");
		testChannel.join();
		
		plexiglas.turnOn();
	}

}
