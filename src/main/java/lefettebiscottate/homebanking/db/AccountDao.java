package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import lefettebiscottate.homebanking.entity.AccountEntity;

public class AccountDao<E, K> {// implements Dao<E,K> {
	private static Connection con = DBConnection.getConnection();

	// @Override
	public E getOne(K primaryKey) {
		AccountEntity account = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			account = new AccountEntity();
			String query = "SELECT * FROM account WHER id =" + primaryKey;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				account.setUser(rs.getInt("user_id"));
				account.setCreation_date(rs.getDate("date_of_creation").toLocalDate());
				account.setId(rs.getInt("id"));
			}
			return (E) account;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// @Override
	public List<E> getAll() {
		List<E> accounts = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM account";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				AccountEntity acc = new AccountEntity();
				acc.setId(rs.getInt("id"));
				acc.setCreation_date(rs.getDate("date_of_creation").toLocalDate());
				acc.setUser(rs.getInt("user_id"));
				accounts.add((E) acc);
			}

			return accounts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// @Override
	public E insert(E element) {
		AccountEntity acc = (AccountEntity) element;
		PreparedStatement stmt = null;
		try {

			String query = "INSERT * INTO account (date_of_creation , user_id)VALUES(?,?)"; // Will
																																	// be
																																	// modified
			stmt = con.prepareStatement(query);
			stmt.setDate(1, acc.getCreation_date().toString());
			stmt.setInt(2, acc.getUser());
			
			boolean added = stmt.execute();
			if (added) {
				System.out.println("The Address successfully added to database.");
				return (E) acc;
			} else {
				System.out.println("Inserting Address Failed!");
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
			String query = "DELETE FROM account WHERE id = " + primaryKey;
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
