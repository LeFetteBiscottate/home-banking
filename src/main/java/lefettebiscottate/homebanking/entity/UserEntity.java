package lefettebiscottate.homebanking.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyVisibilityStrategy;


/**
 * 
 * @author Khalili, Camusi, Mancin
 *
 */
public class UserEntity {

	private int id;
	private String name;
	private String surname;
	private String email;
	private LocalDate birthdate;
	private String password;
	private String phonenumber;
	private String fiscal_code;
	private Gender gender;
	private AccountType account_type;
	private String partita_IVA;
	private boolean isRegistrato;
	private int bank;

	// Costruttori
	public UserEntity() {

	}

	/**
	 * @param name
	 * @param surname
	 * @param email
	 * @param birthdate
	 * @param password
	 * @param phonenumber
	 * @param fiscal_code
	 * @param gender
	 * @param account_type
	 * @param partita_IVA
	 * @param isRegistrato
	 * @param address
	 */
	public UserEntity(String name, String surname, String email, LocalDate birthdate, String password,
			String phonenumber, String fiscal_code, Gender gender, AccountType account_type, String partita_IVA,
			boolean isRegistrato, int bank) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.birthdate = birthdate;
		this.password = password;
		this.phonenumber = phonenumber;
		this.fiscal_code = fiscal_code;
		this.gender = gender;
		this.account_type = account_type;
		this.partita_IVA = partita_IVA;
		this.isRegistrato = isRegistrato;
		this.bank = bank;
	}
	
	
	
	/**
	 * 
	 * @return oggetto UserEntity in formato JSON
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
		return JsonbBuilder.newBuilder().withConfig(config).build().toJson(this); // JsonbBuilder.class.newInstance().withConfig(config).to
	}

	// Getter
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public String getPassword() {
		return password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getFiscal_code() {
		return fiscal_code;
	}

	public Gender getGender() {
		return gender;
	}

	public AccountType getAccount_type() {
		return account_type;
	}

	public String getPartita_IVA() {
		return partita_IVA;
	}

	public boolean isRegistrato() {
		return isRegistrato;
	}

	// Setter
	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setFiscal_code(String fiscal_code) {
		this.fiscal_code = fiscal_code;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setAccount_type(AccountType account_type) {
		this.account_type = account_type;
	}

	public void setPartita_IVA(String partita_IVA) {
		this.partita_IVA = partita_IVA;
	}

	public void setRegistrato(boolean isRegistrato) {
		this.isRegistrato = isRegistrato;
	}

	@Override
	public String toString() {
		return "UserEntity [name=" + name + ", surname=" + surname + ", email=" + email + ", birthdate=" + birthdate
				+ ", password=" + password + ", phonenumber=" + phonenumber + ", fiscal_code=" + fiscal_code
				+ ", gender=" + gender + ", account_type=" + account_type + ", partita_IVA=" + partita_IVA + "Bank = "
				+ this.bank + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if (fiscal_code != null)
			result = prime * result + fiscal_code.hashCode();
		else
			result = prime * result + partita_IVA.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof UserEntity))
			return false;
		UserEntity other = (UserEntity) obj;

		if (fiscal_code == null) {
			// ### Controllo su partita_IVA ###
			if (partita_IVA == null) {
				if (other.partita_IVA != null)
					return false;
			} else if (!partita_IVA.equals(other.partita_IVA))
				return false;
		}

		else {
			// ### Controllo su fiscal_code ###
//			if (fiscal_code == null)
			if (other.fiscal_code != null)
				return false;
			else if (!fiscal_code.equals(other.fiscal_code))
				return false;
		}

		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBank() {
		return bank;
	}

	public void setBank(int bank) {
		this.bank = bank;
	}

}
