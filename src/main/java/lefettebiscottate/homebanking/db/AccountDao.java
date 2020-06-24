package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import lefettebiscottate.homebanking.entity.AccountEntity;

/**
 * 
 * @author Khalili, Camusi, Mancin
 *
 * @param <E>
 * @param <K>
 */
public class AccountDao<E, K> {
	private static Connection con = DBConnection.getConnection();

	// @Override
	/**
	 * 
	 * @param primaryKey
	 * @return AccountEntity avente PrimaryKey uguale al parametro passato
	 */
	public E getOne(K primaryKey) {
		AccountEntity account = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			account = new AccountEntity();
			String query = "SELECT * FROM account WHERE id =" + primaryKey;
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				account.setUser(rs.getInt("user_id"));
				account.setCreation_date(rs.getString("date_of_creation"));
				account.setId(rs.getInt("id"));
			}
			return (E) account;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	// @Override
	/**
	 * 
	 * @return Lista di tutti gli AccountEntity
	 */
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
				acc.setCreation_date(rs.getString("date_of_creation"));
				acc.setUser(rs.getInt("user_id"));
				accounts.add((E) acc);
			}

			return accounts;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	// @Override
	/**
	 * 
	 * @param element
	 * @return nuovo AccountEntity inserito
	 */
	public E insert(E element) {
		AccountEntity acc = (AccountEntity) element;
		PreparedStatement stmt = null;
		try {

			String query = "INSERT * INTO account(date_of_creation , user_id) VALUES(?,?)";// will be modified
			stmt = con.prepareStatement(query);
			stmt.setString(1, (acc.getCreation_date()));// (arg0, arg1, arg2);(1,(acc.getCreation_date()));//
														// LocalDate() should be converted to Date()
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
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	// @Override
	/**
	 * 
	 * @param primaryKey
	 * @return Integer
	 */
	public Integer delete(K primaryKey) {
		Statement stmt = null;
		try {
			String query = "DELETE FROM account WHERE id = " + primaryKey;
			stmt = con.createStatement();
			int deleted = stmt.executeUpdate(query);
			return deleted;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
}