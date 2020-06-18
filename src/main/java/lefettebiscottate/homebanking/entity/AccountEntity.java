package lefettebiscottate.homebanking.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccountEntity {

	private int id;
	private String creation_date;
	private int userId;

	public AccountEntity() {

	}
	

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (this == o)
			return true;
		if (!(o instanceof AccountEntity))
			return false;
		AccountEntity a = (AccountEntity) o;
		return this.id == a.id;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = hash * 31 + id;
		return hash;
	}

	@Override
	public String toString() {
		return "Account:\n" + this.userId + "\nID: " + this.id + "\nCreation date: " + this.creation_date
				+ "\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

	public int getUser() {
		return userId;
	}

	public void setUser(int userId) {
		this.userId = userId;
	}

}
