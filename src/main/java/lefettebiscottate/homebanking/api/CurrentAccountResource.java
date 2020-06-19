package lefettebiscottate.homebanking.api;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;

import java.util.ArrayList;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lefettebiscottate.homebanking.db.CurrentAccountDao;
import lefettebiscottate.homebanking.entity.CurrentAccountEntity;

@Path("/currentaccount")
public class CurrentAccountResource {
	
	private CurrentAccountDao currentAccountDao;
	
	@GET
	@Path("id/{currentaccountId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("currentaccountId") int id) {
		return Response.ok(currentAccountDao.getById(id).toJson()).build();
	}
	
	@GET
	@Path("iban/{iban}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByIban(@PathParam("iban") String iban) {
		return Response.ok(currentAccountDao.getByIban(iban).toJson()).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		ArrayList<CurrentAccountEntity> list = (ArrayList<CurrentAccountEntity>) currentAccountDao.getAll();
		Jsonb jsonb = JsonbBuilder.create();
		System.out.println(jsonb.toJson(list));
		return Response.ok(jsonb.toJson(currentAccountDao.getAll())).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCurrentAccount(CurrentAccountEntity c) {
		return Response.ok(currentAccountDao.insert(c)).build();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCurrentAccount(CurrentAccountEntity c) {
		return Response.ok(currentAccountDao.update(c)).build();
	}
	
	@DELETE
	/*Ha senso mettere le seguenti due etichette per i metodi di
	 * update, put e delete???
	 */
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCurrentAccount(CurrentAccountEntity c) {
		return Response.ok(currentAccountDao.delete(c)).build();
	}

}
