package lefettebiscottate.homebanking.api;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lefettebiscottate.homebanking.entity.BankEntity;
import lefettebiscottate.homebanking.services.BankService;


@Path("/bank")
public class BankResource {
	
	private BankService bankService = new BankService();
	
	@GET
	@Path("{bankId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("bankId") int id) {
		return Response.ok(bankService.getById(id).toJson()).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		Jsonb jsonb = JsonbBuilder.create();
		return Response.ok(jsonb.toJson(bankService.getAll())).build();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBank(BankEntity b) {
		return Response.ok(bankService.insert(b).toJson()).build();
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(BankEntity b) {
		return Response.ok(bankService.delete(b)).build();
	}
}
