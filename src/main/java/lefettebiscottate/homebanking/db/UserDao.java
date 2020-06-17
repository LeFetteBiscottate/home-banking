package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lefettebiscottate.homebanking.entity.UserEntity;

public class UserDao<E, K> implements Dao<E, K> {



	private ExecutorService executor = Executors.newSingleThreadExecutor();


	private static Connection con = DBConnection.getConnection();

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
		//CompletableFuture<E> future = (CompletableFuture<E>) CompletableFuture.supplyAsync(() -> "hello");
		
		return null;


		return executor.submit(() -> {
			
			UserEntity ue = (UserEntity) element;

			String sql = "INSERT INTO user (name, surname, birthdate, email, password, phone, codicefiscale, gender, account_type, registrato, partitaIVA)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			try {
				PreparedStatement pstmt = con.prepareStatement(sql);

				pstmt.setString(1, ue.getName());
				pstmt.setString(2, ue.getSurname());
				pstmt.setString(3, ue.getBirthdate().toString());
				pstmt.setString(4, ue.getEmail());
				pstmt.setString(5, ue.getPassword());
				pstmt.setString(6, ue.getPhonenumber());
				pstmt.setString(7, ue.getFiscal_code());
				pstmt.setString(8, ue.getGender().toString());
				pstmt.setString(9, ue.getAccount_type().toString());
				pstmt.setBoolean(10, ue.isRegistrato());
				pstmt.setString(11, ue.getPartita_IVA());
				

				Boolean resp = pstmt.execute();

				if (resp)
					System.out.println("Insert OK");
				else System.out.println("Errore nell'insert");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
			
		});

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
