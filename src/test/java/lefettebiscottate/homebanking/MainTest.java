package lefettebiscottate.homebanking;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

import lefettebiscottate.homebanking.db.UserDao;
import lefettebiscottate.homebanking.entity.AccountType;
import lefettebiscottate.homebanking.entity.AddressEntity;
import lefettebiscottate.homebanking.entity.Gender;
import lefettebiscottate.homebanking.entity.UserEntity;

class MainTest {

	@Test
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
		
		String via = "Via Michelangelo Vattelappesca";
		String civico = "45/A";
		String comune = "Roma";
		String provincia = "Roma";
		String stato = "Italia";
		int cap = 00123;
		
		AddressEntity indirizzoDiJohn = new AddressEntity(via, civico, comune, provincia, stato, cap);
		UserEntity johnDenver = new UserEntity(name, surname, email, birthdate, password, phonenumber, fiscal_code, gender, account_type, partita_IVA, isRegistrato, indirizzoDiJohn);
		
		UserDao<UserEntity, Integer> ud = new UserDao<>();
		
		Future<UserEntity> fu = ud.insert(johnDenver);
		
		try {
			fu.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
