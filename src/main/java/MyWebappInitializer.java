import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;

import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;
import org.jboss.resteasy.plugins.spring.SpringContextLoaderSupport;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class MyWebappInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// XXX: I didn't want to have to do this...
		new ResteasyBootstrap().contextInitialized(new ServletContextEvent(servletContext));
				
		AnnotationConfigWebApplicationContext config = new AnnotationConfigWebApplicationContext();
		config.register(SpringConfig.class);
		new SpringContextLoaderSupport().customizeContext(servletContext, config);
		
		config.refresh();
	}

}
