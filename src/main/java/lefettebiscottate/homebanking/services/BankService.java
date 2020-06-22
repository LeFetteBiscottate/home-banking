package lefettebiscottate.homebanking.services;

import java.util.List;

import lefettebiscottate.homebanking.db.BankDao;
import lefettebiscottate.homebanking.entity.BankEntity;

public class BankService {
	
	private BankDao<BankEntity, Integer> bankDao;
	
	public BankService() {
		bankDao = new BankDao<>();
	}
	
	public BankEntity getById(int id) {
		return bankDao.getOne(id);
	}
	
	public List<BankEntity> getAll(){
		return bankDao.getAll();
	}
	
	public BankEntity insert(BankEntity b) {
		return bankDao.insert(b);
	}
	
	public int delete(BankEntity b) {
		return bankDao.delete(b.getId());
	}
}
