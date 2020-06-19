package lefettebiscottate.homebanking.api;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lefettebiscottate.homebanking.db.TransactionDao;
import lefettebiscottate.homebanking.entity.TransactionEntity;

@Path("/transaction")
public class TransactionResource {
	
	private TransactionDao transactionDao;
	
	@GET
	@Path("{transactionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("transactionId") int id) {
		return Response.ok(transactionDao.getById(id)).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		Jsonb jsonb = JsonbBuilder.create();
		return Response.ok(jsonb.toJson(transactionDao.getAll())).build();
	}
	
	
	@GET
	@Path("{start}/{end}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByPeriod(@PathParam("start") String start, @PathParam("end") String end) {
		Jsonb jsonb = JsonbBuilder.create();
		return Response.ok(jsonb.toJson(transactionDao.getByPeriod(start, end))).build();
	}
	
	
	@GET
	@Path("{accountId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllByAccountId(@PathParam("accountId") int account_id) {
		Jsonb jsonb = JsonbBuilder.create();
		return Response.ok(jsonb.toJson(transactionDao.getAllByAccountId(account_id))).build();
	}
	
	
	@GET
	@Path("{accountId}/{start}/{end}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByPeriodAndAccountId(@PathParam("accountId") int account_id, @PathParam("start") String start,
											@PathParam("end") String end) {
		Jsonb jsonb = JsonbBuilder.create();
		return Response.ok(jsonb.toJson(transactionDao.getByPeriodAndAccountId(start, end, account_id))).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(TransactionEntity t) {
		if(transactionDao.insert(t))
			return Response.ok(t.toJson()).build();
		else
			return Response.status(Response.Status.CONFLICT).entity("Transazione già presente nel DB").build();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(TransactionEntity t) {
		if(transactionDao.update(t))
			return Response.ok(t.toJson()).build();
		else
			return Response.status(Response.Status.CONFLICT).entity("Transazione non presente nel DB").build();
	}
	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(TransactionEntity t) {
		if(transactionDao.delete(t))
			return Response.ok(t.toJson()).build();
		else
			return Response.status(Response.Status.CONFLICT).entity("Transazione già presente nel DB").build();
	}
	
	
}
