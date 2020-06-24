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

import lefettebiscottate.homebanking.entity.CardEntity;
import lefettebiscottate.homebanking.entity.CardType;
import lefettebiscottate.homebanking.services.CardService;


@Path("/card")
public class CardResource {

	private CardService card = new CardService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{cardId}")
	public Response getById(@PathParam("cardId") int cardId) {
		return Response.ok(card.getById(cardId).toJson()).build();
	}

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("{card_number}")
//	public Response getByCardNumber(@PathParam("card_number") String cardNumber) {
//		return Response.ok(card.getByNumber(cardNumber).toJson()).build();
//	}

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("{card_type}")
//	public Response getByCardType(@PathParam("card_type") CardType cardType) {
//		Jsonb jsonb = JsonbBuilder.create();
//		return Response.ok(jsonb.toJson(card.getByType(cardType))).build();
//	}

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("{accountId}")
//	public Response getByAccountId(@PathParam("accountId") int accountId) {
//		Jsonb jsonb = JsonbBuilder.create();
//		return Response.ok(jsonb.toJson(card.getByAccountId(accountId))).build();
//	}

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("{accountId}/{cardType}")
//	public Response getByAccountIdAndType(@PathParam("cardType") String type, @PathParam("accountId") int accountId) {
//		return Response.ok(card.getByAccountAndType(type, accountId).toJson()).build();
//	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		Jsonb jsonb = JsonbBuilder.create();
		return Response.ok(jsonb.toJson(card.getAll())).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(CardEntity c) {
		if (card.insert(c))
			return Response.ok(c.toJson()).build();
		return Response.status(Response.Status.CONFLICT).entity("Il card gia presente ne DB").build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateBalance(CardEntity c) {
		if (card.updateBalance(c))
			return Response.ok(c.toJson()).build();
		return Response.status(Response.Status.NOT_FOUND).entity("Il card non e presente ne DB").build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{cardId}")
	public Response delete(@PathParam("cardId")int id) {
		if (card.delete(id))
			return Response.ok().build();
		return Response.status(Response.Status.NOT_FOUND).entity("Il card non e presente ne DB").build();
	}

}
