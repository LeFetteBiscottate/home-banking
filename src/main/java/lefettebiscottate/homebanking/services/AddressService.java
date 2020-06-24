package lefettebiscottate.homebanking.services;

import java.util.List;

import lefettebiscottate.homebanking.db.AddressDao;
import lefettebiscottate.homebanking.entity.AddressEntity;
import lefettebiscottate.homebanking.utils.AddressValidation;


public class AddressService {
	private AddressValidation av = new AddressValidation();

	private AddressDao addressDao = new AddressDao();;

	public AddressService() {
	}

	public List<AddressEntity> getAll() {
		return addressDao.getAll();
	}

	public AddressEntity getById(int id) {
		return addressDao.getOne(id);
	}

	public AddressEntity insert(AddressEntity a) {
		//if (av.validateFullAddress(a)) {
			addressDao.insert(a);
			return a;
		//}
		// return addressDao.insert(a);
		//return null;
	}

	public int delete(int id) {
		return addressDao.delete(id);
	}

	public AddressEntity update(AddressEntity a) {
		return addressDao.update(a);
	}
}
