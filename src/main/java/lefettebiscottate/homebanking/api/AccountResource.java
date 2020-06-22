package lefettebiscottate.homebanking.api;

import java.util.ArrayList;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lefettebiscottate.homebanking.entity.AccountEntity;
import lefettebiscottate.homebanking.services.AccountService;

@Path("/account")
public class AccountResource {
	
	private AccountService accountService = new AccountService();
	
	@GET
	@Path("{accountId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(int id) {
		return Response.ok(accountService.getById(id).toJson()).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		ArrayList<AccountEntity> list = (ArrayList<AccountEntity>) accountService.getAll();
		Jsonb jsonb = JsonbBuilder.create();
		System.out.println(jsonb.toJson(list));
		return Response.ok(jsonb.toJson(accountService.getAll())).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAccount(AccountEntity a) {
		return Response.ok(accountService.insert(a).toJson()).build();
	}
	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAccount(AccountEntity a) {
		return Response.ok(accountService.delete(a)).build();
	}

}
