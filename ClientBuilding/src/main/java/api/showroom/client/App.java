package api.showroom.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("app")
public class App {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getDemo() {
		
		Client client=ClientBuilder.newClient();
		Response response= client.target("http://localhost:9000/restApp/showroom/brands/7").request().get();
		return response.toString();
	}
	

}
