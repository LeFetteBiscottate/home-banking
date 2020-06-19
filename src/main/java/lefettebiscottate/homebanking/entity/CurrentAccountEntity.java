package lefettebiscottate.homebanking.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyVisibilityStrategy;

public class CurrentAccountEntity {

	private int id;
	private String iban;
	private double balance;
	private AccountEntity account;
	
	public CurrentAccountEntity() {}
	
	public CurrentAccountEntity(String iban, double balance, AccountEntity account) {
		this.iban = iban;
		this.balance = balance;
		this.account = account;
	}
	
	
	public String toJson() {
		JsonbConfig config = new JsonbConfig().withPropertyVisibilityStrategy(new PropertyVisibilityStrategy() {

			@Override
			public boolean isVisible(Field arg0) {
				return true;
			}

			@Override
			public boolean isVisible(Method arg0) {
				return true;
			}
			
		});
		return JsonbBuilder.newBuilder().withConfig(config).build().toJson(this);
	}
	
	
	public double withdraw(double importo) {
		if(this.balance >= importo)
			this.balance -= importo;
		return this.balance;
	}
	
	
	public double deposit(double importo) {
		return this.balance += importo;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(this == o)
			return true;
		if(!(o instanceof CurrentAccountEntity))
			return false;
		CurrentAccountEntity c = (CurrentAccountEntity) o;
		return this.iban.equalsIgnoreCase(c.iban);
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31*hash + iban.hashCode();
		return hash;
	}
	
	@Override
	public String toString() {
		return "Codice Iban: "+this.iban+"\nSaldo: "+this.balance+" €\n";
	}

	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}


	public String getIban() {
		return iban;
	}


	public void setIban(String iban) {
		this.iban = iban;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public AccountEntity getAccount() {
		return account;
	}


	public void setAccount(AccountEntity account) {
		this.account = account;
	}
	
	
		
}
