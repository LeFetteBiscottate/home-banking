package lefettebiscottate.homebanking.entity;

import java.time.LocalDate;

public class TransactionEntity {
	
	private int id;
	private LocalDate transaction_date;
	private String source;
	private String destination;
	private String description;
	private AccountEntity account;
	private Double importo;
	private TransactionType type;
	
}
