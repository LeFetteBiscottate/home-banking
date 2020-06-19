package lefettebiscottate.homebanking.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyVisibilityStrategy;

public class TransactionEntity {
	
	private int id;
	private LocalDate transaction_date;
	private String source;
	private String destination;
	private String description;
	private AccountEntity account;
	private Double importo;
	private TransactionType type;
	
	public TransactionEntity() {}
	
	public TransactionEntity(LocalDate transaction_date, String source, String destination,
			String description, AccountEntity account, Double importo, TransactionType type) {
		this.transaction_date = transaction_date;
		this.source = source;
		this.description = description;
		this.destination = destination;
		this.account = account;
		this.importo = importo;
		this.type = type;
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
	
	
	@Override
	public String toString() {
		return "Transazione: "+this.type+"\nImporto: "+this.importo+"\nDescrizione: "+
				this.description+"\nDestinatario: "+this.destination;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(this == o)
			return true;
		if(!(o instanceof TransactionEntity))
			return false;
		TransactionEntity t = (TransactionEntity) o;
		return this.id == t.id;
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31*hash + id;
		return hash;
	}
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public LocalDate getTransaction_date() {
		return transaction_date;
	}
	
	
	public void setTransaction_date(LocalDate transaction_date) {
		this.transaction_date = transaction_date;
	}
	
	
	public String getSource() {
		return source;
	}
	
	
	public void setSource(String source) {
		this.source = source;
	}
	
	
	public String getDestination() {
		return destination;
	}
	
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public AccountEntity getAccount() {
		return account;
	}
	
	
	public void setAccount(AccountEntity account) {
		this.account = account;
	}
	
	
	public Double getImporto() {
		return importo;
	}
	
	
	public void setImporto(Double importo) {
		this.importo = importo;
	}
	
	
	public TransactionType getType() {
		return type;
	}
	
	
	public void setType(TransactionType type) {
		this.type = type;
	}
	
}
