package lefettebiscottate.homebanking.entity;

import java.time.LocalDate;

public class AccountEntity {

	private int id;
	private LocalDate creation_date;
	private UserEntity user;

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
		return "Account:\n" + this.user.toString() + "\nID: " + this.id + "\nCreation date: " + this.creation_date
				+ "\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(LocalDate creation_date) {
		this.creation_date = creation_date;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
