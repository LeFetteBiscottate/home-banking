package lefettebiscottate.homebanking.services;

import java.util.List;

import lefettebiscottate.homebanking.db.CardDao;
import lefettebiscottate.homebanking.db.CurrentAccountDao;
import lefettebiscottate.homebanking.db.TransactionDao;
import lefettebiscottate.homebanking.entity.CardEntity;
import lefettebiscottate.homebanking.entity.CurrentAccountEntity;
import lefettebiscottate.homebanking.entity.TransactionEntity;
import lefettebiscottate.homebanking.entity.TransactionType;

public class TransactionService {
	
	private TransactionDao transactionDao;
	private CurrentAccountDao currentaccountDao;
	private CardDao cardDao;
	
	public TransactionService() {
		transactionDao = new TransactionDao();
		currentaccountDao = new CurrentAccountDao();
		cardDao = new CardDao();
	}
	
	public List<TransactionEntity> getAll() {
		return transactionDao.getAll();
	}
	
	public List<TransactionEntity> getAllByAccountId(int account_id){
		return transactionDao.getAllByAccountId(account_id);
	}
	
	public List<TransactionEntity> getAllByPeriod(String start, String end){
		return transactionDao.getByPeriod(start, end);
	}
	
	public List<TransactionEntity> getAllByPeriodAndAccount(String start, String end, int account_id){
		return transactionDao.getByPeriodAndAccountId(start, end, account_id);
	}
	
	public boolean insert(TransactionEntity t) {
		return transactionDao.insert(t);
	}
	
	public boolean update(TransactionEntity t) {
		return transactionDao.update(t);
	}
	
	public boolean delete(TransactionEntity t) {
		return transactionDao.delete(t);
	}
	
	public boolean eseguiOpOrigine(TransactionEntity t) {
		
		boolean eseguita = false;
		
		/*
		 * Si controlla il tipo della transazione ed in base a questo si agisce
		 * in uno specifico modo
		 */
		if(t.getType().equals(TransactionType.BONIFICO_BANCARIO)) {
			CurrentAccountEntity cSource = currentaccountDao.getByIban(t.getSource());
			CurrentAccountEntity cDestination = currentaccountDao.getByIban(t.getDestination());
			if(cSource.getBalance() >= t.getImporto()) {
				if(cDestination != null) {
					cSource.withdraw(t.getImporto());
					currentaccountDao.update(cSource);
					cDestination.deposit(t.getImporto());
					currentaccountDao.update(cDestination);
					eseguita = true;
				} else {
					cSource.withdraw(t.getImporto());
					currentaccountDao.update(cSource);
					eseguita = true;
				}
			} else {
				System.out.println("Saldo insufficiente!");
				eseguita = false;
			}
		}
		
		
		if(t.getType().equals(TransactionType.RICARICA)) {
			CurrentAccountEntity cSource = currentaccountDao.getByIban(t.getSource());
			CardEntity card = cardDao.getByNumber(t.getDestination());
			if(cSource.getBalance() >= t.getImporto()) {
				if(card != null) {
					cSource.withdraw(t.getImporto());
					currentaccountDao.update(cSource);
					card.deposit(t.getImporto());
					cardDao.updateBalance(card);
					eseguita = true;
				} else {
					cSource.withdraw(t.getImporto());
					currentaccountDao.update(cSource);
					eseguita = true;
				}
			} else {
				System.out.println("Saldo insufficiente!");
				eseguita = false;
			}
		}
		
		
		if(t.getType().equals(TransactionType.BOLLETTINO)) {
			CurrentAccountEntity currentAccount = currentaccountDao.getByIban(t.getSource());
			CardEntity card = cardDao.getByNumber(t.getSource());
			if(currentAccount != null && currentAccount.getBalance() >= t.getImporto()) {
				currentAccount.withdraw(t.getImporto());
				currentaccountDao.update(currentAccount);
				eseguita = true;
			} else {
				if(card != null && card.getBalance() >= t.getImporto()) {
					card.withdraw(t.getImporto());
					cardDao.updateBalance(card);
					eseguita = true;
				} else {
					System.out.println("Operazione non avvenuta.");
					eseguita = false;
				}
			}
		}
		
		
		if(t.getType().equals(TransactionType.ALTRO)) {
			CurrentAccountEntity currentAccount = currentaccountDao.getByIban(t.getSource());
			CardEntity card = cardDao.getByNumber(t.getSource());
			if(currentAccount != null && currentAccount.getBalance() >= t.getImporto()) {
				currentAccount.withdraw(t.getImporto());
				currentaccountDao.update(currentAccount);
				eseguita = true;
			} else {
				if(card != null && card.getBalance() >= t.getImporto()) {
					card.withdraw(t.getImporto());
					cardDao.updateBalance(card);
					eseguita = true;
				} else {
					System.out.println("Operazione non avvenuta.");
					eseguita = false;
				}
			}
		}
		
		return eseguita;
	}

}
