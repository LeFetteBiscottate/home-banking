package lefettebiscottate.homebanking.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyVisibilityStrategy;

/**
 * 
 * @author Khalili, Camusi, Mancin
 *
 */
public class AccountEntity {

	private int id;
	private String creation_date;
	private int userId;

	public AccountEntity() {

	}
	
	/**
	 * 
	 * @return oggetto AccountEntity in formato JSON
	 */
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
