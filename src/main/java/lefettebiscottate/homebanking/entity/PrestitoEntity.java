package lefettebiscottate.homebanking.entity;

public class PrestitoEntity {

	private int id;
	private Double importo;
	private Double interest;
	private AccountEntity account;
	private int n_rata; // numero rata
	private Double i_rata; // importo rata
	private String durata;
	private int numero_rata_mancanti;
	private TipoPrestito type;
	
}
