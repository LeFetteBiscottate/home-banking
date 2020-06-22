package lefettebiscottate.homebanking.services;

import java.util.List;

import lefettebiscottate.homebanking.db.AddressDao;
import lefettebiscottate.homebanking.entity.AddressEntity;

public class AddressService {
	
	private AddressDao<AddressEntity, Integer> addressDao;
	
	public AddressService() {
		addressDao = new AddressDao<AddressEntity, Integer>();
	}
	
	public List<AddressEntity> getAll(){
		return addressDao.getAll();
	}
	
	public AddressEntity getById(int id) {
		return addressDao.getOne(id);
	}
	
	public AddressEntity insert(AddressEntity a) {
		return addressDao.insert(a);
	}
	
	public int delete(AddressEntity a) {
		return addressDao.delete(a.getId());
	}
	
	public AddressEntity update(AddressEntity a) {
		return addressDao.update(a);
	}
}
