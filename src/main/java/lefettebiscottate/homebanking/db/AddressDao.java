package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import lefettebiscottate.homebanking.entity.AddressEntity;
import lefettebiscottate.homebanking.entity.BankEntity;

public class AddressDao<E, K> {// implements Dao<E,K> {
	private static Connection con = DBConnection.getConnection();

	// @Override
	public E getOne(K primaryKey) {
		Statement stmt = null;
		ResultSet rs = null;
		E address = null;
		try {
			String query = "SELECT * FORM address WHERE id =" + primaryKey;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				// int id = rs.getInt("id"); the is no "id" in constructor
				String via = rs.getString("via");
				String civico = rs.getString("civico");
				String comune = rs.getString("comune");
				String provincia = rs.getString("provincia");
				String regione = rs.getString("regione");
				String stato = rs.getString("stato");
				int cap = rs.getInt("cap");
				int userId = rs.getInt("usr_id");
				address = (E) new AddressEntity(via, civico, comune, provincia, regione, stato, cap, userId);
			}
			return address;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// @Override
	public List<E> getAll() {
		List<E> addresses = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM address";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String via = rs.getString("via");
				String civico = rs.getString("civico");
				String comune = rs.getString("comune");
				String provincia = rs.getString("provincia");
				String regione = rs.getString("regione");
				String stato = rs.getString("stato");
				int cap = rs.getInt("cap");
				int userId = rs.getInt("usr_id");
				addresses.add((E) new AddressEntity(via, civico, comune, provincia, regione, stato, cap, userId));
			}
			return addresses;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// @Override
	public E insert(E element) {
		AddressEntity addr = (AddressEntity) element;
		PreparedStatement stmt = null;
		try {

			String query = "INSERT * INTO address (via,civico,comune,provincia,regione,stato,cap,user_id) VALUES(?,?,?,?,?,?,?,?)"; // Will
																																	// be
																																	// modified
			stmt = con.prepareStatement(query);
			stmt.setString(1, addr.getVia());
			stmt.setString(2, addr.getCivico());
			stmt.setString(3, addr.getComune());
			stmt.setString(4, addr.getProvincia());
			stmt.setString(4, addr.getRegione());
			stmt.setString(4, addr.getStato());
			stmt.setInt(4, addr.getCap());
			stmt.setInt(4, addr.getUser());
			boolean added = stmt.execute();
			if (added) {
				System.out.println("The Address successfully added to database.");
				return (E) addr;
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
			String query = "DELETE FROM address WHERE id = " + primaryKey;
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
