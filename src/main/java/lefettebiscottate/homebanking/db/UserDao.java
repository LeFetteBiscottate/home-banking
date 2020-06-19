package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lefettebiscottate.homebanking.entity.AccountType;
import lefettebiscottate.homebanking.entity.BankEntity;
import lefettebiscottate.homebanking.entity.Gender;
import lefettebiscottate.homebanking.entity.UserEntity;

public class UserDao {//implements Dao<UserEntity, Integer> {

	private static Connection con = DBConnection.getConnection();
	private ExecutorService executor = Executors.newSingleThreadExecutor();


	public UserEntity getById(int id) {
		
		UserEntity u = new UserEntity();
		
		try {
			String query = "SELECT * FROM user WHERE id = "+id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				u.setName(rs.getString(1));
				u.setSurname(rs.getString(2));
				u.setBirthdate(rs.getDate(3).toLocalDate());
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setPhonenumber(rs.getString(6));
				u.setFiscal_code(rs.getString(7));
				u.setGender(Gender.valueOf(rs.getString(8)));
				u.setAccount_type(AccountType.valueOf(rs.getString(9)));
				u.setRegistrato(rs.getBoolean(10));
				u.setPartita_IVA(rs.getString(11));
				u.setBank((BankEntity) new BankDao().getOne(rs.getInt(12)));
			}
			
			rs.close();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	
	
	public UserEntity getByEmail(String email) {
		
		UserEntity u = new UserEntity();
		
		try {
			String query = "SELECT * FROM user WHERE email = '"+email+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				u.setName(rs.getString(1));
				u.setSurname(rs.getString(2));
				u.setBirthdate(rs.getDate(3).toLocalDate());
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setPhonenumber(rs.getString(6));
				u.setFiscal_code(rs.getString(7));
				u.setGender(Gender.valueOf(rs.getString(8)));
				u.setAccount_type(AccountType.valueOf(rs.getString(9)));
				u.setRegistrato(rs.getBoolean(10));
				u.setPartita_IVA(rs.getString(11));
				u.setBank((BankEntity) new BankDao().getOne(rs.getInt(12)));
			}
			
			rs.close();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	
	
	public List<UserEntity> getAll(){
		
		List<UserEntity> utenti = new ArrayList<UserEntity>();
		
		try {
			String query = "SELECT * FROM user";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				UserEntity u = new UserEntity();
				u.setName(rs.getString(1));
				u.setSurname(rs.getString(2));
				u.setBirthdate(rs.getDate(3).toLocalDate());
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setPhonenumber(rs.getString(6));
				u.setFiscal_code(rs.getString(7));
				u.setGender(Gender.valueOf(rs.getString(8)));
				u.setAccount_type(AccountType.valueOf(rs.getString(9)));
				u.setRegistrato(rs.getBoolean(10));
				u.setPartita_IVA(rs.getString(11));
				u.setBank((BankEntity) new BankDao().getOne(rs.getInt(12)));
				
				utenti.add(u);
			}
			
			rs.close();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return utenti;
	}
	
	
	
	public boolean insert(UserEntity u) {
		boolean result = false;
		
		try {
			
			String sql = "INSERT INTO user (name, surname, birthdate, email, password, phone, codicefiscale, gender,"
					+ " account_type, registrato, partitaIVA, bank_id)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getSurname());
			pstmt.setString(3, u.getBirthdate().toString());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getPassword());
			pstmt.setString(6, u.getPhonenumber());
			pstmt.setString(7, u.getFiscal_code());
			pstmt.setString(8, u.getGender().toString());
			pstmt.setString(9, u.getAccount_type().toString());
			pstmt.setBoolean(10, u.isRegistrato());
			pstmt.setString(11, u.getPartita_IVA());
			pstmt.setInt(12, u.getBank().getId());
				

			result = pstmt.execute();
		} catch(SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	
	
	
	public boolean delete(UserEntity u) {
		boolean result = false;
		String query = "DELETE FROM user WHERE id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, u.getId());
			result = true;
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	
	
	public boolean update(UserEntity u) {
		boolean result;
		String query = "UPDATE user SET email = ?, password = ?, phone = ? WHERE id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, u.getEmail());
			stmt.setString(2, u.getPassword());
			stmt.setString(3, u.getPhonenumber());
			stmt.setInt(4, u.getId());
			result = true;
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override 
//	public Future<E> getOne(Integer primaryKey) {
//		
//		UserEntity ue = null;
//		
////		return  executor.submit(() -> {
////			try {
////				String query ="Select * from user where id = "+primaryKey;
////				
////				
////				Statement stmt = con.createStatement();
////				ResultSet rs = stmt.executeQuery(query);
////				
////				while(rs.next()) {
//////					ue = new UserEntity();
////					
////					ue.setId(rs.getInt("id"));
////					ue.setName(rs.getString("name"));
////					ue.setSurname(rs.getString("surname"));
////					ue.setBirthdate(rs.getDate("birthdate").toLocalDate());
////					ue.setEmail(rs.getString("email"));
////					ue.setPassword(rs.getString("password"));
////					ue.setPhonenumber(rs.getString("phone"));
////					ue.setFiscal_code(rs.getString("codicefiscale"));
////					ue.setGender(Gender.valueOf(rs.getString("gender")));
////					ue.setAccount_type(AccountType.valueOf(rs.getString("account_type")));
////					ue.setRegistrato(rs.getBoolean("registrato"));
////					ue.setPartita_IVA(rs.getString("partitaIVA"));
////				}
////				
////				rs.close();
////				stmt.close();
////				
////			} catch (SQLException e) {
////				
////				e.printStackTrace();
////			}
////		});
//		
//		return null;
//	}

//	@Override
//	public List<UserEntity> getAll() {
//		String query = "SELECT * FROM user";
//		
//		
////		return CompletableFuture.supplyAsync(() -> {
//			List<UserEntity> utenti = new ArrayList<>();
//			
//			try {
//				Statement stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery(query);
//				
//				
//				while(rs.next()) {
//					UserEntity ue = new UserEntity();
//					
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
//					
//					utenti.add(ue);
//				}
//			} catch(SQLException e) {
//				
//			}
//			return utenti;
////		});
//		
//	}

//	@Override
//	public Future<E> insert(E element) {
//		//CompletableFuture<E> future = (CompletableFuture<E>) CompletableFuture.supplyAsync(() -> "hello");
//		
//		return null;
//
//
//		return executor.submit(() -> {
//			
//			UserEntity ue =  (UserEntity)element;
//
//			String sql = "INSERT INTO user (name, surname, birthdate, email, password, phone, codicefiscale, gender, account_type, registrato, partitaIVA)"
//					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//			try {
//				PreparedStatement pstmt = con.prepareStatement(sql);
//
//				pstmt.setString(1, ue.getName());
//				pstmt.setString(2, ue.getSurname());
//				pstmt.setString(3, ue.getBirthdate().toString());
//				pstmt.setString(4, ue.getEmail());
//				pstmt.setString(5, ue.getPassword());
//				pstmt.setString(6, ue.getPhonenumber());
//				pstmt.setString(7, ue.getFiscal_code());
//				pstmt.setString(8, ue.getGender().toString());
//				pstmt.setString(9, ue.getAccount_type().toString());
//				pstmt.setBoolean(10, ue.isRegistrato());
//				pstmt.setString(11, ue.getPartita_IVA());
//				
//
//				Boolean resp = pstmt.execute();
//
//				if (resp)
//					System.out.println("Insert OK");
//				else System.out.println("Errore nell'insert");
//
//			} catch (SQLException e) {
//				
//				e.printStackTrace();
//			}
//			
//			return null;
//			
//		});
//
//	}

		
//		return null;
//	}
//
////	@Override
//	public List<UserEntity> getAll() {
//		String query = "SELECT * FROM user";
//		
//		
////		return CompletableFuture.supplyAsync(() -> {
//			List<UserEntity> utenti = new ArrayList<>();
//			
//			try {
//				Statement stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery(query);
//				
//				
//				while(rs.next()) {
//					UserEntity ue = new UserEntity();
//					
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
//					
//					utenti.add(ue);
//				}
//			} catch(SQLException e) {
//				
//			}
//			return utenti;
//		});
		
//	}

//	@Override
//	public Future<E> insert(E element) {
		//CompletableFuture<E> future = (CompletableFuture<E>) CompletableFuture.supplyAsync(() -> "hello");
		
		//return null;


//		return executor.submit(() -> {
//			
//			UserEntity ue =  (UserEntity)element;
//
//			String sql = "INSERT INTO user (name, surname, birthdate, email, password, phone, codicefiscale, gender, account_type, registrato, partitaIVA)"
//					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//			try {
//				PreparedStatement pstmt = con.prepareStatement(sql);
//
//				pstmt.setString(1, ue.getName());
//				pstmt.setString(2, ue.getSurname());
//				pstmt.setString(3, ue.getBirthdate().toString());
//				pstmt.setString(4, ue.getEmail());
//				pstmt.setString(5, ue.getPassword());
//				pstmt.setString(6, ue.getPhonenumber());
//				pstmt.setString(7, ue.getFiscal_code());
//				pstmt.setString(8, ue.getGender().toString());
//				pstmt.setString(9, ue.getAccount_type().toString());
//				pstmt.setBoolean(10, ue.isRegistrato());
//				pstmt.setString(11, ue.getPartita_IVA());
//				
//
//				Boolean resp = pstmt.execute();
//
//				if (resp)
//					System.out.println("Insert OK");
//				else System.out.println("Errore nell'insert");
//
//			} catch (SQLException e) {
//				
//				e.printStackTrace();
//			}
//			
//			return null;
//			
//		});
//
//	}

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

