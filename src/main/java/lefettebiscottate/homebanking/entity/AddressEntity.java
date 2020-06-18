package lefettebiscottate.homebanking.entity;

public class AddressEntity {

	private int id;
	private String via;
	private String civico;
	private String comune;
	private String provincia;
	private String regione;
	private String stato;
	private int cap;
	private int userId;

	public AddressEntity() {

	}

	public AddressEntity(String via, String civico, String comune, String provincia, String regione, String stato,
			int cap, int userId) {
		this.via = via;
		this.civico = civico;
		this.comune = comune;
		this.provincia = provincia;
		this.regione = regione;
		this.stato = stato;
		this.cap = cap;
		this.userId = userId;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (this == o)
			return true;
		if (!(o instanceof AddressEntity))
			return false;
		AddressEntity a = (AddressEntity) o;
		return this.id == a.id;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + id;
		return hash;
	}

	@Override
	public String toString() {
		return "Address:\n" + this.via + " " + this.civico + ", " + this.comune + " " + this.cap + "\nProvincia: "
				+ this.provincia + "\n" + this.stato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public int getUser() {
		return userId;
	}

	public void setUser(int userId) {
		this.userId = userId;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

}
