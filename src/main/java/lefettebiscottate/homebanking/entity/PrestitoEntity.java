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
	//Abbiamo assunto a priori di avere delle rate mensili????
	
	
	public PrestitoEntity() {}
	
	public PrestitoEntity(Double importo, Double interest, AccountEntity account, int n_rata,
			Double i_rata, String durata, int numero_rata_mancanti, TipoPrestito type) {
		this.importo = importo;
		this.interest = interest;
		this.account = account;
		this.n_rata = n_rata;
		this.i_rata = i_rata;
		this.durata = durata;
		this.numero_rata_mancanti = numero_rata_mancanti;
		this.type = type;
	}
	
	
	@Override
	public String toString() {
		return this.type+"\nImporto: "+this.importo+"\nInteresse: "+this.interest+
				"\nNumero totale rate: "+this.n_rata+"\nImporto rata: "+this.i_rata+
				"\nNumero rate mancanti: "+this.numero_rata_mancanti;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(this == o)
			return true;
		if(!(o instanceof PrestitoEntity))
			return false;
		PrestitoEntity p = (PrestitoEntity) o;
		return this.id == p.id;
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
	
	
	public Double getImporto() {
		return importo;
	}
	
	
	public void setImporto(Double importo) {
		this.importo = importo;
	}
	
	
	public Double getInterest() {
		return interest;
	}
	
	
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	
	
	public AccountEntity getAccount() {
		return account;
	}
	
	
	public void setAccount(AccountEntity account) {
		this.account = account;
	}
	
	
	public int getN_rata() {
		return n_rata;
	}
	
	
	public void setN_rata(int n_rata) {
		this.n_rata = n_rata;
	}
	
	
	public Double getI_rata() {
		return i_rata;
	}
	
	
	public void setI_rata(Double i_rata) {
		this.i_rata = i_rata;
	}
	
	
	public String getDurata() {
		return durata;
	}
	
	
	public void setDurata(String durata) {
		this.durata = durata;
	}
	
	
	public int getNumero_rata_mancanti() {
		return numero_rata_mancanti;
	}
	
	
	public void setNumero_rata_mancanti(int numero_rata_mancanti) {
		this.numero_rata_mancanti = numero_rata_mancanti;
	}
	
	
	public TipoPrestito getType() {
		return type;
	}
	
	
	public void setType(TipoPrestito type) {
		this.type = type;
	}
	
}
