package lefettebiscottate.homebanking;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?user=root&password=root");
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT 1");
			
			if (rs.next())
				System.out.println("Connessione a DB: OK");
		}
		
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) { } // ignore
				rs = null;
			}
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) { } // ignore
				stmt = null;
			}
		}
	}
}
