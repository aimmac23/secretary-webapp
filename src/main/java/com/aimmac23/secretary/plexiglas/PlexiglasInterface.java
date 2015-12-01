package com.aimmac23.secretary.plexiglas;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlexiglasInterface {
	
	private static final Logger log = LoggerFactory.getLogger(PlexiglasInterface.class);
	
	private Client client;

	public PlexiglasInterface() {
		client = ClientBuilder.newClient();
		
	}
	
	public void turnOn() {
		WebTarget target = client.target("http://192.168.0.5:5000")
				.path("/plexiglas/device/green").path("on");
		
		try {
			Response response = target.request().buildGet().invoke();
			if(response.getStatus() != HttpStatus.SC_OK) {
				log.error("Non-200 response when hitting endpoint. Status: " + 
						response.getStatus() + " response: " + response.readEntity(String.class));
			}
			response.close();
		}
		catch (ProcessingException e) {
			log.error("Could not hit plexiglas interface", e);
		}
	}
	
	public void turnOff() {
		WebTarget target = client.target("http://192.168.0.5:5000")
				.path("/plexiglas/device/green").path("off");
		
		try {
			Response response = target.request().buildGet().invoke();
			if(response.getStatus() != HttpStatus.SC_OK) {
				log.error("Non-200 response when hitting endpoint. Status: " + 
						response.getStatus() + " response: " + response.readEntity(String.class));
			}
			response.close();
		}
		catch (ProcessingException e) {
			log.error("Could not hit plexiglas interface", e);
		}
	}

}
