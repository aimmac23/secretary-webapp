package com.aimmac23.secretary.irc;
import java.io.IOException;
import java.net.UnknownHostException;

import com.sorcix.sirc.Channel;
import com.sorcix.sirc.IrcConnection;
import com.sorcix.sirc.NickNameException;
import com.sorcix.sirc.PasswordException;

public class IRCHandler {
	
	private IrcConnection ircConnection;

	public IRCHandler(String hostname, int port, String serverPassword, String username) throws UnknownHostException, IOException, NickNameException, PasswordException {
		ircConnection = new IrcConnection(hostname, port, serverPassword);
		ircConnection.setUsingSSL(true);
		ircConnection.setUsername(username);
		ircConnection.setNick(username);
		ircConnection.connect();
		Channel testChannel = ircConnection.createChannel("test");
		testChannel.join();
		
		MessageRegistry registry = new MessageRegistry();
		ircConnection.addMessageListener(registry);
	}
}
