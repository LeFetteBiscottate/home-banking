package lefettebiscottate.homebanking.db;

import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import lefettebiscottate.homebanking.entity.PrestitoEntity;
import lefettebiscottate.homebanking.entity.TransactionEntity;

public class TransactionDao {
	
	private static Connection con = DBConnection.getConnection();
	
	public TransactionEntity getById(int id) {
		
		TransactionEntity t = new TransactionEntity();
		
		try {
			String query = "SELECT * FROM transaction WHERE id = "+id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				t.setId(rs.getInt(1));
				t.setTransaction_date(rs.getDate(2).toLocalDate());
				t.setSource(rs.getString(3));
				t.setDestination(rs.getString(4));
				t.setDescription(rs.getString(5));
				t.setAccount(account);
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
				t.setAccount(account);
				t.setImporto(rs.getDouble(7));
				
				transazioni.add(t);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return transazioni;
	}
	
	
	
	public List<TransactionEntity> getByPeriod(LocalDate start, LocalDate end){
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
				t.setAccount(account);
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
				t.setAccount(account);
				t.setImporto(rs.getDouble(7));
				
				transazioni.add(t);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return transazioni;
	}
	
	
	public List<TransactionEntity> getByPeriodAndAccountId(LocalDate start, LocalDate end, int account_id){
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
				t.setAccount(account);
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
				+ "account_id, importo) VALUES ("
				+t.getTransaction_date()+", '"+t.getSource()+"', '"+t.getDestination()+"', '"+t.getDescription()
				+"', "+t.getAccount().getId()+", "+t.getImporto()+")";
				
		try {
			Statement stmt = con.createStatement();
			int rs = stmt.executeUpdate(query);
			result = true;
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public boolean update(TransactionEntity t) {
		boolean result = false;
		String query = "UPDATE transaction SET destination = '"+t.getDestination()+"', description = '"+
						t.getDescription()+"', importo = "+t.getImporto()+
						" WHERE id = "+t.getId();
		
		try {
			Statement stmt = con.createStatement();
			int rs = stmt.executeUpdate(query);
			result = true;
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public boolean delete(TransactionEntity t) {
		boolean result = false;
		String query = "DELETE FROM transaction WHERE id = "+t.getId();
		
		try {
			Statement stmt = con.createStatement();
			int rs = stmt.executeUpdate(query);
			result = true;
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
