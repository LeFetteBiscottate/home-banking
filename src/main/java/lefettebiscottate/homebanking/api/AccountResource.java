package lefettebiscottate.homebanking.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lefettebiscottate.homebanking.db.AccountDao;
import lefettebiscottate.homebanking.entity.AccountEntity;

public class AccountResource {
	
	private AccountDao accountDao;
	
	@GET
	@Path("{accountId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(int id) {
		return Response.ok(accountDao.getOne(id)).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return Response.ok(accountDao.getAll()).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAccount(AccountEntity a) {
		return Response.ok(accountDao.insert(a)).build();
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAccount(AccountEntity a) {
		return Response.ok(accountDao.delete(a)).build();
	}

}
