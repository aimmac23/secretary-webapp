import java.io.IOException;
import java.util.Properties;

import com.aimmac23.secretary.plexiglas.PlexiglasInterface;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class MyGuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new PropsModule("config.properties"));
		bind(PlexiglasInterface.class).asEagerSingleton();
	}

	private static class PropsModule extends AbstractModule {
		
		private String propsFile;

		public PropsModule(String propsFile) {
			this.propsFile = propsFile;
		}

		@Override
		protected void configure() {
			Properties props = new Properties();
			try {
				
				props.load(this.getClass().getClassLoader().getResourceAsStream(propsFile));
			} catch (IOException e) {
				throw new IllegalArgumentException("Could not load file: " + propsFile, e);
			}
			Names.bindProperties(this.binder(),  props);
			
		}
	}

}
