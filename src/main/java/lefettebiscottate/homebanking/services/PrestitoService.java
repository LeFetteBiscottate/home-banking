package lefettebiscottate.homebanking.services;

import java.util.List;

import lefettebiscottate.homebanking.db.CurrentAccountDao;
import lefettebiscottate.homebanking.db.PrestitoDao;
import lefettebiscottate.homebanking.entity.CurrentAccountEntity;
import lefettebiscottate.homebanking.entity.PrestitoEntity;



public class PrestitoService {
	
	private PrestitoDao prestitoDao;
	
	public PrestitoService() {
		prestitoDao = new PrestitoDao();
	}
	
	public PrestitoEntity getByIdAccount(int account_id) {
		return prestitoDao.getByIdAccount(account_id);
	}
	
	public List<PrestitoEntity> getAll(){
		return prestitoDao.getAll();
	}
	
	public boolean insert(PrestitoEntity p) {
		return prestitoDao.insert(p);
	}
	
	public boolean delete(int id) {
		return prestitoDao.delete(id);
	}
	
	public boolean updateRateMancanti(PrestitoEntity p) {
		return prestitoDao.update(p);
	}
	
	public void pagamentoRata(int account_id) {
		PrestitoEntity p = prestitoDao.getByIdAccount(account_id);
		double importoRata = p.getI_rata();
		int numero_rate_attuali = p.getNumero_rata_mancanti();
		CurrentAccountDao currentaccountDao = new CurrentAccountDao();
		CurrentAccountEntity c = currentaccountDao.getByAccountId(account_id);
		
		if(numero_rate_attuali != 0) {
			if(c.getBalance() >= importoRata) {
				c.withdraw(importoRata);
				p.setNumero_rata_mancanti(numero_rate_attuali-1);
			} else {
				System.out.println("Saldo insufficiente!");
			}
		} else {
			System.out.println("Non ci sono pi� rate da pagare!");
		}
	}
}
