import java.io.IOException;
import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aimmac23.secretary.irc.IRCHandler;
import com.aimmac23.secretary.plexiglas.PlexiglasInterface;
import com.sorcix.sirc.NickNameException;
import com.sorcix.sirc.PasswordException;

@Configuration
public class SpringConfig {
	
	@Bean
	public IRCHandler getHandler(PlexiglasInterface plexiglas) throws UnknownHostException, IOException, NickNameException, PasswordException {
		return new IRCHandler(plexiglas);
	}
	
	@Bean
	public PlexiglasInterface getIndicatorInterface() {
		return new PlexiglasInterface();
	}

}
