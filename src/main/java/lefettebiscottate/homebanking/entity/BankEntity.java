package lefettebiscottate.homebanking.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyVisibilityStrategy;


/**
 * 
 * @author Khalili, Camusi, Mancin
 *
 */
public class BankEntity {

	private int id;
	private String name;
	private String description;

	public BankEntity() {
	}

	public BankEntity(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	/**
	 * 
	 * @return oggetto BankEntity in formato JSON
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
		String stringa = "Banca:\n" + this.name+"\n"+this.description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String filiale_description) {
		this.description = filiale_description;
	}
	
	

}
