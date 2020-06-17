package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
<<<<<<< HEAD
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
=======
import java.util.List;
>>>>>>> cca97d0eea4231b2a5220ad28c347ddd91c43dd9
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lefettebiscottate.homebanking.entity.AccountType;
import lefettebiscottate.homebanking.entity.Gender;
import lefettebiscottate.homebanking.entity.UserEntity;

public class UserDao<E, K> {//implements Dao<UserEntity, Integer> {



	private ExecutorService executor = Executors.newSingleThreadExecutor();


	private static Connection con = DBConnection.getConnection();
	
	
//	@Override 
	public Future<E> getOne(Integer primaryKey) {
		
		UserEntity ue = null;
		
//		return  executor.submit(() -> {
//			try {
//				String query ="Select * from user where id = "+primaryKey;
//				
//				
//				Statement stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery(query);
//				
//				while(rs.next()) {
////					ue = new UserEntity();
//					
//					ue.setId(rs.getInt("id"));
//					ue.setName(rs.getString("name"));
//					ue.setSurname(rs.getString("surname"));
//					ue.setBirthdate(rs.getDate("birthdate").toLocalDate());
//					ue.setEmail(rs.getString("email"));
//					ue.setPassword(rs.getString("password"));
//					ue.setPhonenumber(rs.getString("phone"));
//					ue.setFiscal_code(rs.getString("codicefiscale"));
//					ue.setGender(Gender.valueOf(rs.getString("gender")));
//					ue.setAccount_type(AccountType.valueOf(rs.getString("account_type")));
//					ue.setRegistrato(rs.getBoolean("registrato"));
//					ue.setPartita_IVA(rs.getString("partitaIVA"));
//				}
//				
//				rs.close();
//				stmt.close();
//				
//			} catch (SQLException e) {
//				
//				e.printStackTrace();
//			}
//		});
		
		return null;
	}

//	@Override
	public List<UserEntity> getAll() {
		String query = "SELECT * FROM user";
		
		
//		return CompletableFuture.supplyAsync(() -> {
			List<UserEntity> utenti = new ArrayList<>();
			
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				
				while(rs.next()) {
					UserEntity ue = new UserEntity();
					
					
					ue.setId(rs.getInt("id"));
					ue.setName(rs.getString("name"));
					ue.setSurname(rs.getString("surname"));
					ue.setBirthdate(rs.getDate("birthdate").toLocalDate());
					ue.setEmail(rs.getString("email"));
					ue.setPassword(rs.getString("password"));
					ue.setPhonenumber(rs.getString("phone"));
					ue.setFiscal_code(rs.getString("codicefiscale"));
					ue.setGender(Gender.valueOf(rs.getString("gender")));
					ue.setAccount_type(AccountType.valueOf(rs.getString("account_type")));
					ue.setRegistrato(rs.getBoolean("registrato"));
					ue.setPartita_IVA(rs.getString("partitaIVA"));
					
					utenti.add(ue);
				}
			} catch(SQLException e) {
				
			}
			return utenti;
//		});
		
	}

//	@Override
	public Future<E> insert(E element) {
		//CompletableFuture<E> future = (CompletableFuture<E>) CompletableFuture.supplyAsync(() -> "hello");
		
		return null;


		return executor.submit(() -> {
			
			UserEntity ue =  (UserEntity)element;

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
				
				e.printStackTrace();
			}
			
			return null;
			
		});

	}

	//@Override
	//public Future<Integer> delete(Integer primaryKey) {
		
//		return executor.submit(() -> {
//			String query = "DELETE FROM user WHERE id = "+primarykey;
//			
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeUpdate(query);
//		});
//		
	//	return null;
	//}

	//@Override
	//public Future<UserEntity> update(UserEntity element) {

		
	//}

}
