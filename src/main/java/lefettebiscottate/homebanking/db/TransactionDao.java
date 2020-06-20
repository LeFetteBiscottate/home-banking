package lefettebiscottate.homebanking.db;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lefettebiscottate.homebanking.entity.AccountEntity;
import lefettebiscottate.homebanking.entity.TransactionEntity;

public class TransactionDao {
	
	private static Connection con = DBConnection.getConnection();
	private AccountDao<AccountEntity, Integer> accountDao = new AccountDao<>();
	
	public TransactionEntity getById(int id) {
		
		TransactionEntity t = null;
		
		try {
			String query = "SELECT * FROM transaction WHERE id = "+id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				t = new TransactionEntity();
				t.setId(rs.getInt(1));
				t.setTransaction_date(rs.getDate(2).toLocalDate());
				t.setSource(rs.getString(3));
				t.setDestination(rs.getString(4));
				t.setDescription(rs.getString(5));
				t.setAccount(accountDao.getOne(rs.getInt(6)));
				t.setImporto(rs.getDouble(7));
			}
			
			rs.close();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	
	public List<TransactionEntity> getAll(){
		List<TransactionEntity> transazioni = new ArrayList<TransactionEntity>();
		
		try {
			String query = "SELECT * FROM transaction";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				TransactionEntity t = new TransactionEntity();
				
				t.setId(rs.getInt(1));
				t.setTransaction_date(rs.getDate(2).toLocalDate());
				t.setSource(rs.getString(3));
				t.setDestination(rs.getString(4));
				t.setDescription(rs.getString(5));
				t.setAccount(accountDao.getOne(rs.getInt(6)));
				t.setImporto(rs.getDouble(7));
				
				transazioni.add(t);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return transazioni;
	}
	
	
	
	public List<TransactionEntity> getByPeriod(String start, String end){
		List<TransactionEntity> transazioni = new ArrayList<TransactionEntity>();
		
		try {
			String query = "SELECT * FROM transaction WHERE date between date '"+start+"' and '"+
							end+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				TransactionEntity t = new TransactionEntity();
				
				t.setId(rs.getInt(1));
				t.setTransaction_date(rs.getDate(2).toLocalDate());
				t.setSource(rs.getString(3));
				t.setDestination(rs.getString(4));
				t.setDescription(rs.getString(5));
				t.setAccount(accountDao.getOne(rs.getInt(6)));
				t.setImporto(rs.getDouble(7));
				
				transazioni.add(t);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return transazioni;
	}
	
	
	
	public List<TransactionEntity> getAllByAccountId(int account_id){
		List<TransactionEntity> transazioni = new ArrayList<TransactionEntity>();
		
		try {
			String query = "SELECT * FROM transaction WHERE account_id = "+account_id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				TransactionEntity t = new TransactionEntity();
				
				t.setId(rs.getInt(1));
				t.setTransaction_date(rs.getDate(2).toLocalDate());
				t.setSource(rs.getString(3));
				t.setDestination(rs.getString(4));
				t.setDescription(rs.getString(5));
				t.setAccount(accountDao.getOne(rs.getInt(6)));
				t.setImporto(rs.getDouble(7));
				
				transazioni.add(t);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return transazioni;
	}
	
	
	public List<TransactionEntity> getByPeriodAndAccountId(String start, String end, int account_id){
		List<TransactionEntity> transazioni = new ArrayList<TransactionEntity>();
		
		try {
			String query = "SELECT * FROM transaction WHERE date between date '"+start+"' and '"+
							end+"' and account_id = "+account_id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				TransactionEntity t = new TransactionEntity();
				
				t.setId(rs.getInt(1));
				t.setTransaction_date(rs.getDate(2).toLocalDate());
				t.setSource(rs.getString(3));
				t.setDestination(rs.getString(4));
				t.setDescription(rs.getString(5));
				t.setAccount(accountDao.getOne(rs.getInt(6)));
				t.setImporto(rs.getDouble(7));
				
				transazioni.add(t);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return transazioni;
	}
	
	
	public boolean insert(TransactionEntity t) {
		boolean result = false;
		String query = "INSERT INTO transaction VALUES(date, source, destination, description,"
				+ "account_id, importo) VALUES (?, ?, ?, ?, ?, ?)";
				
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, t.getTransaction_date().toString());
			stmt.setString(2, t.getSource());
			stmt.setString(3, t.getDestination());
			stmt.setString(4, t.getDestination());
			stmt.setInt(5, t.getAccount().getId());
			stmt.setDouble(6, t.getImporto());
			result = true;
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public boolean update(TransactionEntity t) {
		boolean result = false;
		String query = "UPDATE transaction SET destination = ?, description = ?, importo = ? WHERE id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, t.getDestination());
			stmt.setString(2, t.getDescription());
			stmt.setDouble(3, t.getImporto());
			stmt.setInt(4, t.getId());
			result = true;
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public boolean delete(TransactionEntity t) {
		boolean result = false;
		String query = "DELETE FROM transaction WHERE id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, t.getId());
			result = true;
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
