package lefettebiscottate.homebanking.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyVisibilityStrategy;

public class CardEntity {

	private int id;
	private String iban;
	private String card_number;
	private Circuit circuit;
	private double balance;
	private LocalDate expiration_date;
	private AccountEntity account;
	
	
	public CardEntity() {}
	
	public CardEntity(String iban, String card_number, Circuit circuit, double balance,
			LocalDate expiration_date, AccountEntity account) {
		this.iban = iban;
		this.card_number = card_number;
		this.circuit = circuit;
		this.balance = balance;
		this.expiration_date = expiration_date;
		this.account = account;
	}
	
	public String toJson() {
		JsonbConfig config = new JsonbConfig().withPropertyVisibilityStrategy(new PropertyVisibilityStrategy() {

			@Override
			public boolean isVisible(Field arg0) {
				return false;
			}

			@Override
			public boolean isVisible(Method arg0) {
				return false;
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
		if(!(o instanceof CardEntity))
			return false;
		CardEntity c = (CardEntity) o;
		return this.card_number.equals(c.card_number);
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31*hash + card_number.hashCode();
		return hash;
	}
	
	@Override
	public String toString() {
		return "Numero Carta: "+this.card_number+"\nSaldo"+this.balance+"€\nCircuito: "+this.circuit
				+"\nScadenza: "+this.expiration_date+"\n";
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
	
	
	public String getCard_number() {
		return card_number;
	}
	
	
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	
	
	public Circuit getCircuit() {
		return circuit;
	}
	
	
	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}
	
	
	public double getBalance() {
		return balance;
	}
	
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public LocalDate getExpiration_date() {
		return expiration_date;
	}
	
	
	public void setExpiration_date(LocalDate expiration_date) {
		this.expiration_date = expiration_date;
	}
	
	
	public AccountEntity getAccount() {
		return account;
	}
	
	
	public void setAccount(AccountEntity account) {
		this.account = account;
	}
	
	
	
	
}
