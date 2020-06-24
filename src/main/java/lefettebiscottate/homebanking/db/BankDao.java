package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lefettebiscottate.homebanking.entity.BankEntity;


//import java.util.concurrent.Future;

public class BankDao<E, K> { // implements Dao<E , K >{
	private static Connection con = DBConnection.getConnection();

	// @Override
	public E getOne(K primaryKey)  {
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
				String description_filiale = rs.getString("description");
				bank = new BankEntity(name, description_filiale);
				bank.setId(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
		}
		return (E) bank;
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
				String description = rs.getString("description");
				E bank = (E) new BankEntity(name, description); // problem is in constructor(Will be resolved)
				banks.add(bank);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
//			if(con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
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
			String query = "INSERT INTO bank (name, description) VALUES(?,?)"; // Will be modified
			stmt = con.prepareStatement(query);
			stmt.setString(1, bank.getName());
			stmt.setString(2, bank.getDescription());
			boolean added = stmt.execute();
			if (added) {
				System.out.println("The bank successfully added to database.");
				return (E) bank;
			} else {
				System.out.println("Inserting Bank Failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
//			if(con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
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
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
//			if(con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
		}
		return 0;
	}

}
