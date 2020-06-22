package lefettebiscottate.homebanking.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestResource {

	@GET
	@Path("/ok")
	public Response getOkResponse() {
		String message = "This is a text response";
		
		return Response
				.status(Response.Status.OK)
				.entity(message)
				.build();
	}
	
}
