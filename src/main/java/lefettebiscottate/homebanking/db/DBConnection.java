package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static Connection getConnection() {

		Connection con = null;
//		Statement stmt = null;
//		ResultSet rs = null;
		try {
//			return DriverManager.getConnection("jdbc:mysql://" + DatabaseCredentials.getHost()
//					+ ":" + DatabaseCredentials.getPort() + "/" + DatabaseCredentials.getDB() + "?user="
//					+ DatabaseCredentials.getUser() + "&password=" + DatabaseCredentials.getPass());
			System.out.println("------------------->>>>>Attempt to connect to db");
			 con = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7347777", "sql7347777",
					"iN11gpR7wH");
//			stmt = con.createStatement();
//			rs = stmt.executeQuery("SELECT 1");
//
//			if (rs.next())
//				System.out.println("--------------->>>>>Connessione a DB: OK");
			// return con;
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		return con;
	}
}
