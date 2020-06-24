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

import lefettebiscottate.homebanking.entity.AccountType;
import lefettebiscottate.homebanking.entity.UserEntity;
import lefettebiscottate.homebanking.services.UserService;

@Path("/user")
public class UserResource {
	
	private UserService userService = new UserService();
	
	@GET
	@Path("userId/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("userId") int id) {
		return Response.ok(userService.getById(id).toJson()).build();
	}
	
	
	@GET
	@Path("userEmail/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByEmail(@PathParam("email") String email) {
		return Response.ok(userService.getByEmail(email).toJson()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByEmail(@PathParam("id") int id) {
		return Response.ok(userService.getById(id).toJson()).build();
	}
	
//	@GET
//	@Path("userType/{account_type}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getByType(@PathParam("account_type") AccountType account_type) {
//		return Response.ok(userService.getByType(account_type).toJson()).build();
//	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getAll() {
//		Jsonb jsonb = JsonbBuilder.create();
//		return Response.ok(jsonb.toJson(userDao.getAll())).build();
//	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		Jsonb jsonb = JsonbBuilder.create();
		return Response.ok(jsonb.toJson(userService.getAll())).build();
	}
	
//	@GET
//	@Path("/notRegistered")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getUsersNotRegistered() {
//		Jsonb jsonb = JsonbBuilder.create();
//		return Response.ok(jsonb.toJson(userService.getUserNotRegistered())).build();
//	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(UserEntity u) {
		return Response.ok(userService.insert(u)).build();
//		if(userService.insert(u))
//			return Response.ok(u.toJson()).build();
//		else
//			return Response.status(Response.Status.CONFLICT).build(); //.entity("Utente già presente nel DB")
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(UserEntity u) {
		if(userService.update(u))
			return Response.ok(u.toJson()).build();
		else
			return Response.status(Response.Status.CONFLICT).entity("Utente non presente nel DB").build();
	}
	
	
//	@PUT
//	@Path("confirmation/{userId}")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response confermaUser(UserEntity u) {
//		if(userService.accettaUser(u))
//			return Response.ok(u.toJson()).build();
//		else
//			return Response.status(Response.Status.CONFLICT).build();
//	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response delete(@PathParam("id")int id) {
		if(userService.delete(id))
			return Response.ok().build();
		else
			return Response.status(Response.Status.CONFLICT).entity("Utente non presente nel DB").build();
	}
}
