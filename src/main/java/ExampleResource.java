import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class ExampleResource {
	
	
	@GET
	public String testMethod() {
		return "It works!";
	}

}
