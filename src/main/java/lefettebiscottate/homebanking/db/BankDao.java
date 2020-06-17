package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lefettebiscottate.homebanking.entity.BankEntity;
//import java.util.concurrent.Future;

public class BankDao<E, K> { // implements Dao<E , K >{
	private static Connection con = DBConnection.getConnection();

	// @Override
	public E getOne(K primaryKey) {
		Statement stmt = null;
		ResultSet rs = null;
		BankEntity bank = null;
		try {
			String query = "SELECT * FROM bank WHERE id = " + primaryKey;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String filiale = rs.getString("filiale");
				int userId = rs.getInt("user_id");
				bank = new BankEntity(id, name, filiale, userId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bank;
	}

	// @Override
	public List<E> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		List<E> banks = null;
		try {
			banks = new ArrayList<>();
			// in order to fetch list of filiali from db we have to do a join with Filiali
			// Table
			String query = "SELECT * FROM bank"; // Will be modified
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String filiale = rs.getString("filiale");
				int userId = rs.getInt("user_id");
				E bank = (E) new BankEntity(name, filiale, userId); // problem is in constructor(Will be resolved)
				banks.add(bank);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return banks;
	}

	// @Override
	public E insert(E element) {
		BankEntity bank = (BankEntity) element;
		PreparedStatement stmt = null;
		// ResultSet rs = null;
		// List<E> banks = null;
		try {
			// in order to fetch list of users and filiali the should a foreign key in user
			// and filiale table to bank table
			String query = "INSERT * INTO bank (name,filiali,user_id) VALUES(?,?,?)"; // Will be modified
			stmt = con.prepareStatement(query);
			stmt.setInt(1, bank.getId());
			stmt.setString(2, bank.getName());
			stmt.setString(3, bank.getFiliali()); // to be modified
			stmt.setString(4, bank.getUserList()); // To be modified
			boolean added = stmt.execute();
			if (added) {
				System.out.println("The bank successfully added to database.");
				return (E) bank;
			} else {
				System.out.println("Inserting Bank Failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// @Override
	public Integer delete(K primaryKey) {
		Statement stmt = null;
		try {
			String query = "DELETE FROM bank WHERE id = " + primaryKey;
			stmt = con.createStatement();
			int deleted = stmt.executeUpdate(query);
			return deleted;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// @Override
	public E update(E element) {
		// TODO Auto-generated method stub
		return null;
	}

}
