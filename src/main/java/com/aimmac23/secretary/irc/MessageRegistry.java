package com.aimmac23.secretary.irc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sorcix.sirc.Channel;
import com.sorcix.sirc.IrcConnection;
import com.sorcix.sirc.MessageListener;
import com.sorcix.sirc.User;

public class MessageRegistry implements MessageListener {
	
	private static final Logger log = LoggerFactory.getLogger(MessageRegistry.class);
	
	Map<String, List<String>> channelEvents = new HashMap<>();

	private synchronized List<String> getChannelList(String channelName) {
		List<String> events = channelEvents.get(channelName);
		
		if(events == null) {
			events = new ArrayList<>();
			channelEvents.put(channelName,events);
		}
		
		return events;
		
	}
	
	private synchronized void addMessage(String channel, String message) {
		getChannelList(channel).add(message);
		log.info("Got message - channel: " + channel + " message: " + message);

	}
	
	@Override
	public void onAction(IrcConnection irc, User sender, Channel target, String action) {
		addMessage(target.getName(), "(action) (" + sender.getNick() + ") " + action);
		
	}

	@Override
	public void onAction(IrcConnection irc, User sender, String action) {
		addMessage(sender.getNick(), "(action) (" + sender.getNick() + ") " + action);
		
	}

	@Override
	public void onCtcpReply(IrcConnection irc, User sender, String command, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(IrcConnection irc, User sender, Channel target, String message) {
		addMessage(target.getName(), "(message) (" + sender.getNick() + ") " + message);
		
	}

	@Override
	public void onNotice(IrcConnection irc, User sender, Channel target, String message) {
		addMessage(target.getName(), "(notice) (" + sender.getNick() + ") " + message);
		
	}

	@Override
	public void onNotice(IrcConnection irc, User sender, String message) {
		addMessage(sender.getNick(), "(notice) (" + sender.getNick() + ") " + sender);
		
	}

	@Override
	public void onPrivateMessage(IrcConnection irc, User sender, String message) {
		addMessage(sender.getNick(), "(pm) (" + sender.getNick() + ") " + message);
		
	}

}
