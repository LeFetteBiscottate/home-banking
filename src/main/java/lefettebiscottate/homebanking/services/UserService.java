package lefettebiscottate.homebanking.services;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import lefettebiscottate.homebanking.db.AccountDao;
import lefettebiscottate.homebanking.db.UserDao;
import lefettebiscottate.homebanking.entity.AccountEntity;
import lefettebiscottate.homebanking.entity.AccountType;
import lefettebiscottate.homebanking.entity.UserEntity;

public class UserService {
	
	private UserDao userDao;
	
	public UserService() {
		userDao = new UserDao();
	}
	
	public UserEntity getById(int id) {
		return userDao.getById(id);
	}
	
	public UserEntity getByEmail(String email) {
		return userDao.getByEmail(email);
	}
	
	public UserEntity getByType(AccountType account_type) {
		return userDao.getByType(account_type);
	}
	
	public List<UserEntity> getAll(){
		return userDao.getAll();
	}
	
	public List<UserEntity> getUserNotRegistered(){
		return userDao.getUserNotRegistered();
	}
	
//	public boolean insert(UserEntity u) {
//		return userDao.insert(u);
//	}
	
	public boolean delete(UserEntity u) {
		return userDao.delete(u);
	}
	
	public boolean insert(UserEntity u) {
		return userDao.insert(u);
	}
	
	
	/*
	 * Vengono aggiornati phone, email e password
	 */
	public boolean update(UserEntity u) {
		return userDao.update(u);
	}
	
	
	/*
	 * con questo metodo viene accettao un singolo utente 
	 * da parte dell'amministratore
	 */
	public boolean accettaUser(UserEntity u) {
		boolean confermato = false;
		AccountDao<AccountEntity, Integer> accountDao = new AccountDao<>();
		if(userDao.confermaRegistrazione(u)) {
			u = userDao.getByEmail(u.getEmail());
			AccountEntity accountEntity = new AccountEntity();
			accountEntity.setUser(u.getId());
			accountEntity.setCreation_date(LocalDate.now().toString());
			accountDao.insert(accountEntity);
			confermato = true;
		}
		return confermato;
	}
	
	
	/*
	 * Viene presentata all'amministratore una lista 
	 * di utenti da accettare o meno.
	 * L'accettazioen viene fatta un utente per volta
	 */
	public void accettaUsers() {
		
		List<UserEntity> utenti = userDao.getUserNotRegistered();
		Iterator<UserEntity> i = utenti.iterator();
		AccountDao<AccountEntity, Integer> accountDao = new AccountDao<>();
		
		while(i.hasNext()) {
			userDao.confermaRegistrazione(i.next());
			UserEntity u = i.next();
			u = userDao.getByEmail(u.getEmail());
			AccountEntity accountEntity = new AccountEntity();
			accountEntity.setUser(u.getId());
			accountEntity.setCreation_date(LocalDate.now().toString());
			accountDao.insert(accountEntity);
		}
	}

}
