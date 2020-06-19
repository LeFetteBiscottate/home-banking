package lefettebiscottate.homebanking.api;

import java.util.ArrayList;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lefettebiscottate.homebanking.db.AccountDao;
import lefettebiscottate.homebanking.entity.AccountEntity;

public class AccountResource {
	
	private AccountDao<AccountEntity, Integer> accountDao;
	
	@GET
	@Path("{accountId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(int id) {
		return Response.ok(accountDao.getOne(id).toJson()).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		ArrayList<AccountEntity> list = (ArrayList<AccountEntity>) accountDao.getAll();
		Jsonb jsonb = JsonbBuilder.create();
		System.out.println(jsonb.toJson(list));
		return Response.ok(jsonb.toJson(accountDao.getAll())).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAccount(AccountEntity a) {
		return Response.ok(accountDao.insert(a).toJson()).build();
	}

}
