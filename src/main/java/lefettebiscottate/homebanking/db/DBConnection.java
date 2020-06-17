package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() {

		try {
			return DriverManager.getConnection("jdbc:mysql://" + DatabaseCredentials.getHost()
					+ ":" + DatabaseCredentials.getPort() + "/" + DatabaseCredentials.getDB() + "?user="
					+ DatabaseCredentials.getUser() + "&password=" + DatabaseCredentials.getPass());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
