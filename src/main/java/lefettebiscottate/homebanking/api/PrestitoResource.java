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

import lefettebiscottate.homebanking.db.PrestitoDao;
import lefettebiscottate.homebanking.entity.PrestitoEntity;

@Path("/prestito")
public class PrestitoResource {
	
	private PrestitoDao prestitoDao = new PrestitoDao();
	
	@GET
	@Path("accountId/{accountId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByAccountId(@PathParam("accountId") int account_id) {
		return Response.ok(prestitoDao.getByIdAccount(account_id).toJson()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		Jsonb jsonb = JsonbBuilder.create();
		
		return Response.ok(jsonb.toJson(prestitoDao.getAll())).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(PrestitoEntity p) {
		if(prestitoDao.insert(p))
			return Response.ok(p.toJson()).build();
		else
			return Response.status(Response.Status.CONFLICT).entity("Prestito già presente nel DB").build();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(PrestitoEntity p) {
		if(prestitoDao.update(p))
			return Response.ok(p.toJson()).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Il prestito non è presente nel DB").build();
	}
	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(PrestitoEntity p) {
		if(prestitoDao.delete(p))
			return Response.ok(p.toJson()).build();
		else 
			return Response.status(Response.Status.NOT_FOUND).entity("Il prestito non è presente nel DB").build();
	}
}
