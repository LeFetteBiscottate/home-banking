package lefettebiscottate.homebanking.services;

import java.util.List;

import lefettebiscottate.homebanking.db.CurrentAccountDao;
import lefettebiscottate.homebanking.entity.CurrentAccountEntity;
import lefettebiscottate.homebanking.entity.UserEntity;

public class CurrentAccountService {

	private CurrentAccountDao currentaccountDao;

	public CurrentAccountService() {
		currentaccountDao = new CurrentAccountDao();
	}

	public CurrentAccountEntity getById(int id) {
		return currentaccountDao.getById(id);
	}

	public CurrentAccountEntity getByAccountId(int account_id) {
		return currentaccountDao.getByAccountId(account_id);
	}

	public CurrentAccountEntity getByIban(String iban) {
		return currentaccountDao.getByIban(iban);
	}

	public List<CurrentAccountEntity> getAll() {
		return currentaccountDao.getAll();
	}

	public boolean insert(CurrentAccountEntity c) {
		return currentaccountDao.insert(c);
	}

	public boolean delete(int id) {
		return currentaccountDao.delete(id);
	}

	public boolean updateBalance(CurrentAccountEntity c) {
		return currentaccountDao.update(c);
	}
}
