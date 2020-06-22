package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lefettebiscottate.homebanking.entity.AccountEntity;
import lefettebiscottate.homebanking.entity.CurrentAccountEntity;

public class CurrentAccountDao {
	
	private static Connection con = DBConnection.getConnection();
	
	private AccountDao<AccountEntity, Integer> accountDao;
	
	public CurrentAccountEntity getById(int id) {
		
		CurrentAccountEntity c = null;
		
		try {
			
			String query = "SELECT * FROM currentaccount WHERE id = "+ id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				c = new CurrentAccountEntity();
				c.setId(rs.getInt(1));
				c.setIban(rs.getString(2));
				c.setBalance(rs.getDouble(3));
				c.setAccount(accountDao.getOne(rs.getInt(4)));
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return c;
	}
	
	
	public CurrentAccountEntity getByIban(String iban) {
		
		CurrentAccountEntity c = null;
		
		try {
			
			String query = "SELECT * FROM currentaccount WHERE iban = '"+ iban+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				c = new CurrentAccountEntity();
				c.setId(rs.getInt(1));
				c.setIban(rs.getString(2));
				c.setBalance(rs.getDouble(3));
				c.setAccount(accountDao.getOne(rs.getInt(4)));
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	
	public CurrentAccountEntity getByAccountId(int account_id) {
		
		CurrentAccountEntity c = null;
		
		try {
			
			String query = "SELECT * FROM currentaccount WHERE account_id = "+ account_id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				c = new CurrentAccountEntity();
				c.setId(rs.getInt(1));
				c.setIban(rs.getString(2));
				c.setBalance(rs.getDouble(3));
				c.setAccount(accountDao.getOne(rs.getInt(4)));
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	
	public List<CurrentAccountEntity> getAll(){
		
		List<CurrentAccountEntity> conti = new ArrayList<CurrentAccountEntity>();
		
		try {
			String query = "SELECT * FROM currentaccount";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				CurrentAccountEntity c = new CurrentAccountEntity();
				c.setId(rs.getInt(1));
				c.setIban(rs.getString(2));
				c.setBalance(rs.getDouble(3));
				c.setAccount(accountDao.getOne(rs.getInt(4)));
				
				conti.add(c);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conti;
	}
	
	public List<AccountEntity> getAllAccount(){
		List<AccountEntity> accounts = new ArrayList<AccountEntity>();
		String query = "SELECT c.account_id FROM currentaccount AS c";
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				AccountEntity a;
				a = accountDao.getOne(rs.getInt(4));
				
				accounts.add(a);
			}
			
			rs.close();
			stmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	
	public boolean insert(CurrentAccountEntity c) {
		
		String query ="INSERT INTO currentaccount(iban, balance, account_id) VALUES(?, ?, ?)";
		boolean result = false;
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, c.getIban());
			stmt.setDouble(2, c.getBalance());
			stmt.setInt(3, c.getAccount().getId());
			result = true;
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	public boolean delete(CurrentAccountEntity c) {
		
		String query = "DELETE FROM currentaccount WHERE id = ?";
		
		boolean result = false;
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, c.getId());
			result = true;
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}
	
	public boolean update(CurrentAccountEntity c) {
		
		boolean result = false;
		String query ="UPADTE currentaccount SET balance = ? WHERE id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setDouble(1, c.getBalance());
			stmt.setInt(2, c.getId());
			result = true;
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

}
