package lefettebiscottate.homebanking.entity;

import java.time.LocalDate;

public class CardEntity {

	private int id;
	private String iban;
	private String card_number;
	private Circuit circuit;
	private double balance;
	private LocalDate expiration_date;
	private AccountEntity account;
	
}
