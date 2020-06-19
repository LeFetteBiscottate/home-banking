package lefettebiscottate.homebanking.entity;

import java.util.ArrayList;
import java.util.List;

public class BankEntity {

	private int id;
	private String name;
	private String filiale_description;

	public BankEntity() {
	}

	public BankEntity(String name, String filiale_description) {
		this.name = name;
		this.filiale_description = filiale_description;
	}


	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (this == o)
			return true;
		if (!(o instanceof BankEntity))
			return false;
		BankEntity b = (BankEntity) o;
		return this.name.equalsIgnoreCase(b.name);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + name.hashCode();
		return hash;
	}

	@Override
	public String toString() {
		String stringa = "Banca:\n" + this.name+"\n"+this.filiale_description;
		return stringa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFiliale_description() {
		return filiale_description;
	}

	public void setFiliale_description(String filiale_description) {
		this.filiale_description = filiale_description;
	}
	
	

}
