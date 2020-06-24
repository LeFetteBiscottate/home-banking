package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() {
		Connection con = null;

		try {
//			return DriverManager.getConnection("jdbc:mysql://" + DatabaseCredentials.getHost()
//					+ ":" + DatabaseCredentials.getPort() + "/" + DatabaseCredentials.getDB() + "?user="
//					+ DatabaseCredentials.getUser() + "&password=" + DatabaseCredentials.getPass());
		 con = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7347777","sql7347777","iN11gpR7wH");
		 //return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
