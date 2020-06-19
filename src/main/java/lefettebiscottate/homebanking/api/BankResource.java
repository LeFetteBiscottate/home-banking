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

import lefettebiscottate.homebanking.db.BankDao;
import lefettebiscottate.homebanking.entity.AccountEntity;
import lefettebiscottate.homebanking.entity.BankEntity;


@Path("/bank")
public class BankResource {
	
	private BankDao<BankEntity, Integer> bankDao;
	
	@GET
	@Path("{bankId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("bankId") int id) {
		return Response.ok(bankDao.getOne(id).toJson()).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		Jsonb jsonb = JsonbBuilder.create();
		return Response.ok(jsonb.toJson(bankDao.getAll())).build();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBank(BankEntity b) {
		return Response.ok(bankDao.insert(b).toJson()).build();
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(BankEntity b) {
		return Response.ok(bankDao.delete(b.getId())).build();
	}
}
