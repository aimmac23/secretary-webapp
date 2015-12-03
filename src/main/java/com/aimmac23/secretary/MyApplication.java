package com.aimmac23.secretary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@ApplicationPath("/")
public class MyApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		return new HashSet<Class<?>>(Arrays.asList(ExampleResource.class));
	}
	
	@Override
	public Set<Object> getSingletons() {
		return new HashSet<Object>(Arrays.asList(new JacksonJaxbJsonProvider()));
	}

}
