package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.util.List;
import java.util.concurrent.Future;

public class UserDao<E, K> implements Dao<E, K> {
	
	private static Connection con= DBConnection.getConnection();
	
	@Override
	public Future<E> getOne(K primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<List<E>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<E> insert(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<Integer> delete(K primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<E> update(E element) {
		// TODO Auto-generated method stub
		return null;
	}

}
