package lefettebiscottate.homebanking;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import lefettebiscottate.homebanking.db.*;
import lefettebiscottate.homebanking.entity.*;

class MainTest {

	@Test
	@Disabled
	void tast_retrieveBankInfo() {
		BankEntity be = new BankDao<BankEntity, Integer>().getOne(1);

		// assert
		int result = 1;

		// verify
		assertEquals(be.getId(), result);
	}

	@Test
	@Disabled
	void test_insertUserIntoDB() {
		String name = "John";
		String surname = "Denver";
		LocalDate birthdate = LocalDate.of(1970, 01, 01);
		String email = "johndenver@gmail.com";
		String password = "t4kemeh0me";
		String phonenumber = "1234567890";
		String fiscal_code = "DNVJHN70A01C773Y";
		Gender gender = Gender.M;
		AccountType account_type = AccountType.CLIENT;
		Boolean isRegistrato = true;
		String partita_IVA = null;

		UserEntity johnDenver = new UserEntity(name, surname, email, birthdate, password, phonenumber, fiscal_code,
				gender, account_type, partita_IVA, isRegistrato, new BankDao<BankEntity, Integer>().getOne(1));

		UserDao ud = new UserDao();

		boolean fu = ud.insert(johnDenver);

		System.out.println(fu);
	}

	@Test
	@Disabled
	void test_addressInsert() {
		String via = "Via Michelangelo Vattelappesca";
		String civico = "45/A";
		String comune = "Roma";
		String provincia = "Roma";
		String stato = "Italia";
		String regione = "Lazio";
		int cap = 00123;

		AddressEntity indirizzoDiJohn = new AddressEntity(via, civico, comune, provincia, regione, stato, cap,
				new UserDao().getById(2).getId());

		AddressDao<AddressEntity, Integer> ad = new AddressDao<>();

		ad.insert(indirizzoDiJohn);

		System.out.println("1: " + new UserDao().getById(2).getId());
		System.out.println("2: " + new UserDao().getByEmail("johndenver@gmail.com").getId());

	}

//	@Test
//	void test_getOneAddress() {
//		List<AddressEntity> aeList = new AddressDao<AddressEntity, Integer>().getAll();
//
//		System.out.println(aeList);
//	}

	@Test
	void test_userToJson() {
		
		UserDao ud = new UserDao();
		
		Jsonb jsonb = JsonbBuilder.create();
		
		System.out.println(jsonb.toJson(ud.getAll()).toString());

	}

}
