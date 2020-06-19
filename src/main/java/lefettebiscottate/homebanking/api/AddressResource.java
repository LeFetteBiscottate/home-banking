package lefettebiscottate.homebanking.api;

import java.util.ArrayList;

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

import lefettebiscottate.homebanking.db.AddressDao;
import lefettebiscottate.homebanking.entity.AddressEntity;


@Path("/address")
public class AddressResource {
	
	private AddressDao<AddressEntity, Integer> addressDao;
	
	
	@GET
	@Path("{addressId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("addressId") int id) {
		return Response.ok(addressDao.getOne(id).toJson()).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		ArrayList<AddressEntity> list = (ArrayList<AddressEntity>) addressDao.getAll();
		Jsonb jsonb = JsonbBuilder.create();
		System.out.println(jsonb.toJson(list));
		return Response.ok(jsonb.toJson(addressDao.getAll())).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAddress(AddressEntity a) {
		return Response.ok(addressDao.insert(a).toJson()).build();
	}
	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(AddressEntity a) {
		return Response.ok(addressDao.delete(a.getId())).build();
	}
	
	
	

}
