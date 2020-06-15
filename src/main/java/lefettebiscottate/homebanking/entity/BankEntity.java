package lefettebiscottate.homebanking.entity;

import java.util.ArrayList;
import java.util.List;

public class BankEntity {

	private int id;
	private String name;
	private List<String> filiali;
	private List<UserEntity> userList;
	
	public BankEntity() {
		this.filiali = new ArrayList<String>();
		this.userList = new ArrayList<UserEntity>();
	}
	
	public BankEntity(String name) {
		this.name = name;
		this.filiali = new ArrayList<String>();
		this.userList = new ArrayList<UserEntity>();
	}
	
	public boolean addFiliale(String filiale) {
		if(!this.filiali.contains(filiale)) {
			this.filiali.add(filiale);
			return true;
		}
		return false;
	}
	
	
	public boolean addUser(UserEntity user) {
		if(!this.userList.contains(user)) {
			this.userList.add(user);
			return true;
		}
		return false;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(this == o)
			return true;
		if(!(o instanceof BankEntity))
			return false;
		BankEntity b = (BankEntity) o;
		return this.name.equalsIgnoreCase(b.name);
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31*hash + name.hashCode();
		return hash;
	}
	
	@Override
	public String toString() {
		String stringa = "Banca:\n"+this.name+"\nFiliali:\n";
		for(String filiale : this.filiali) {
			stringa += filiale.toString()+"\n";
		}
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

	public List<String> getFiliali() {
		return filiali;
	}


	public void setFiliali(List<String> filiali) {
		this.filiali = filiali;
	}
	


	public List<UserEntity> getUserList() {
		return userList;
	}


	public void setUserList(List<UserEntity> userList) {
		this.userList = userList;
	}
	
	
	
}
