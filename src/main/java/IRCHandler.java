import com.sorcix.sirc.IrcConnection;

public class IRCHandler {
	
	private IrcConnection ircConnection;

	public IRCHandler() {
		ircConnection = new IrcConnection("127.0.0.1");
		
	}

}
