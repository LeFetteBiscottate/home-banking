package lefettebiscottate.homebanking.services;

import java.util.List;

import lefettebiscottate.homebanking.db.AccountDao;
import lefettebiscottate.homebanking.entity.AccountEntity;

public class AccountService {
	
	private AccountDao<AccountEntity, Integer> accountDao;
	
	public AccountService() {
		accountDao = new AccountDao<>();
	}
	
	public AccountEntity getById(int id) {
		return accountDao.getOne(id);
	}
	
	public List<AccountEntity> getAll(){
		return accountDao.getAll();
	}
	
	public AccountEntity insert(AccountEntity a) {
		return accountDao.insert(a);
	}
	
	public int delete(AccountEntity a) {
		return accountDao.delete(a.getId());
	}

}
