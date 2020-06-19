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

import lefettebiscottate.homebanking.db.UserDao;
import lefettebiscottate.homebanking.entity.UserEntity;

@Path("/user")
public class UserResource {
	
	private UserDao userDao;
	
	@GET
	@Path("userId/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("userId") int id) {
		return Response.ok(userDao.getById(id).toJson()).build();
	}
	
	
	@GET
	@Path("userEmail/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByEmail(@PathParam("email") String email) {
		return Response.ok(userDao.getByEmail(email).toJson()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		Jsonb jsonb = JsonbBuilder.create();
		return Response.ok(jsonb.toJson(userDao.getAll())).build();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(UserEntity u) {
		if(userDao.insert(u))
			return Response.ok(u.toJson()).build();
		else
			return Response.status(Response.Status.CONFLICT).entity("Utente già presente nel DB").build();
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(UserEntity u) {
		if(userDao.update(u))
			return Response.ok(u.toJson()).build();
		else
			return Response.status(Response.Status.CONFLICT).entity("Utente non presente nel DB").build();
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(UserEntity u) {
		if(userDao.insert(u))
			return Response.ok(u.toJson()).build();
		else
			return Response.status(Response.Status.CONFLICT).entity("Utente non presente nel DB").build();
	}
}
