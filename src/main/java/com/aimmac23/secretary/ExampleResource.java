package com.aimmac23.secretary;

import java.util.Collections;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
public class ExampleResource {
	
	private static final Logger log = LoggerFactory.getLogger(ExampleResource.class);
	
	
	@GET
	public String testMethod() {
		log.info("Hit debugging");
		return "It works!";
	}
	
	
	@PUT
	@Path("/transactions/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response putTransactions(@PathParam("id") String transactionId, Map<Object, Object> data) {
		
		log.info("Got tranaction: " + transactionId + " data: " + data);
		
		return Response.ok().entity(Collections.emptyMap()).build();
	}
	
	@PUT
	@Path("/rooms/{alias}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoomAlias(@PathParam("alias") String roomAlias) {
		
		log.info("Asked for room alias: '" + roomAlias + "', returned not found response.");
		return Response.status(Status.NOT_FOUND).entity(Collections.emptySet()).build();
	}

	@GET
	@Path("/users/{user}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("user") String user) {
		log.info("Asked for user: '" + user + "', returned not found response.");
		return Response.status(Status.NOT_FOUND).entity(Collections.emptySet()).build();
	}

}
