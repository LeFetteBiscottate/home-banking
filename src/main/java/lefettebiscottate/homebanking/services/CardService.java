package lefettebiscottate.homebanking.services;

import java.util.List;

import lefettebiscottate.homebanking.db.CardDao;
import lefettebiscottate.homebanking.entity.CardEntity;
import lefettebiscottate.homebanking.entity.CardType;



public class CardService {
	
	private CardDao cardDao;
	
	public CardService() {
		cardDao = new CardDao();
	}
	
	public CardEntity getById(int id) {
		return cardDao.getById(id);
	}
	
	public List<CardEntity> getByAccountId(int account_id) {
		return cardDao.getByAccountId(account_id);
	}
	
	public CardEntity getByAccountAndType(String cardType, int account_id) {
		return cardDao.getByAccountIdAndType(cardType, account_id);
	}
	
	public CardEntity getByNumber(String card_number) {
		return cardDao.getByNumber(card_number);
	}
	
	public List<CardEntity> getByType(CardType type){
		return cardDao.getByType(type);
	}
	
	public List<CardEntity> getAll(){
		return cardDao.getAll();
	}
	
	public boolean updateBalance(CardEntity c) {
		return cardDao.updateBalance(c);
	}
	
	public boolean insert(CardEntity c) {
		return cardDao.insert(c);
	}
	
	public boolean delete(int id) {
		return cardDao.delete(id);
	}
}
