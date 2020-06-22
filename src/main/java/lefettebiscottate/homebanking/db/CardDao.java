package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lefettebiscottate.homebanking.entity.AccountEntity;
import lefettebiscottate.homebanking.entity.CardEntity;
import lefettebiscottate.homebanking.entity.CardType;
import lefettebiscottate.homebanking.entity.Circuit;

public class CardDao {
	
	private static Connection con = DBConnection.getConnection();
	private AccountDao<AccountEntity, Integer> accountDao = new AccountDao<>();
	
	public CardEntity getById(int id) {
		
		CardEntity c = null;
		
		try {
			String query = "SELECT * FROM card WHERE id = "+id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				c = new CardEntity();
				c.setId(rs.getInt(1));
				c.setCard_number(rs.getString(2));
				c.setCircuit(Circuit.valueOf(rs.getString(3)));
				c.setExpiration_date(rs.getDate(4).toLocalDate());
				c.setBalance(rs.getDouble(5));
				c.setType(CardType.valueOf(rs.getString(6)));
				c.setAccount(accountDao.getOne(rs.getInt(7)));
				c.setIban(rs.getString(8));
			}
			
			rs.close();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	
	public CardEntity getByNumber(String card_number) {
		
		CardEntity c = null;
		
		try {
			String query = "SELECT * FROM card WHERE card_number = '"+card_number+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				c = new CardEntity();
				c.setId(rs.getInt(1));
				c.setCard_number(rs.getString(2));
				c.setCircuit(Circuit.valueOf(rs.getString(3)));
				c.setExpiration_date(rs.getDate(4).toLocalDate());
				c.setBalance(rs.getDouble(5));
				c.setType(CardType.valueOf(rs.getString(6)));
				c.setAccount(accountDao.getOne(rs.getInt(7)));
				c.setIban(rs.getString(8));
			}
			
			rs.close();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	
	public List<CardEntity> getByType(CardType type) {
		
		List<CardEntity> cards = new ArrayList<CardEntity>();
		
		try {
			String query = "SELECT * FROM card WHERE type = '"+type+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				CardEntity c = new CardEntity();
				c.setId(rs.getInt(1));
				c.setCard_number(rs.getString(2));
				c.setCircuit(Circuit.valueOf(rs.getString(3)));
				c.setExpiration_date(rs.getDate(4).toLocalDate());
				c.setBalance(rs.getDouble(5));
				c.setType(CardType.valueOf(rs.getString(6)));
				c.setAccount(accountDao.getOne(rs.getInt(7)));
				c.setIban(rs.getString(8));
				
				cards.add(c);
			}
			
			rs.close();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cards;
	}
	
	public List<CardEntity> getByAccountId(int account_id) {
		
		List<CardEntity> cards = new ArrayList<CardEntity>();
		
		try {
			String query = "SELECT * FROM card WHERE account_id = "+account_id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				CardEntity c = new CardEntity();
				c.setId(rs.getInt(1));
				c.setCard_number(rs.getString(2));
				c.setCircuit(Circuit.valueOf(rs.getString(3)));
				c.setExpiration_date(rs.getDate(4).toLocalDate());
				c.setBalance(rs.getDouble(5));
				c.setType(CardType.valueOf(rs.getString(6)));
				c.setAccount(accountDao.getOne(rs.getInt(7)));
				c.setIban(rs.getString(8));
				
				cards.add(c);
			}
			
			rs.close();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cards;
	}
	
	
	public CardEntity getByAccountIdAndType(CardType type, int account_id) {
		
		CardEntity c = null;
		
		try {
			String query = "SELECT * FROM card WHERE type = '"+type+ "' and account_id = "+account_id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				c = new CardEntity();
				c.setId(rs.getInt(1));
				c.setCard_number(rs.getString(2));
				c.setCircuit(Circuit.valueOf(rs.getString(3)));
				c.setExpiration_date(rs.getDate(4).toLocalDate());
				c.setBalance(rs.getDouble(5));
				c.setType(CardType.valueOf(rs.getString(6)));
				c.setAccount(accountDao.getOne(rs.getInt(7)));
				c.setIban(rs.getString(8));
			}
			
			rs.close();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	
	public List<CardEntity> getAll() {
		
		List<CardEntity> cards = new ArrayList<CardEntity>();
		
		try {
			String query = "SELECT * FROM card";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				CardEntity c = new CardEntity();
				c.setId(rs.getInt(1));
				c.setCard_number(rs.getString(2));
				c.setCircuit(Circuit.valueOf(rs.getString(3)));
				c.setExpiration_date(rs.getDate(4).toLocalDate());
				c.setBalance(rs.getDouble(5));
				c.setType(CardType.valueOf(rs.getString(6)));
				c.setAccount(accountDao.getOne(rs.getInt(7)));
				c.setIban(rs.getString(8));
				
				cards.add(c);
			}
			
			rs.close();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cards;
	}
	
	
	public boolean insert(CardEntity c) {
		boolean result = false;
		
		try {
			
			String query = "INSERT INTO card(card_number, circuit, expiry_date, balance, type, account_id,iban"
							+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, c.getCard_number());
			stmt.setString(2, c.getCircuit().toString());
			stmt.setString(3, c.getExpiration_date().toString());
			stmt.setDouble(4, c.getBalance());
			stmt.setString(5, c.getType().toString());
			stmt.setInt(6, c.getAccount().getId());
			stmt.setString(7, c.getIban());
			
			result = stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	public boolean delete(CardEntity c) {
		boolean result = false;
		String query = "DELETE FROM card WHERE id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, c.getId());
			result = stmt.execute();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	public boolean updateBalance(CardEntity c) {
		boolean result;
		String query = "UPDATE card SET balance = ? WHERE id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setDouble(1, c.getBalance());
			stmt.setInt(2, c.getId());
			result = stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
}
