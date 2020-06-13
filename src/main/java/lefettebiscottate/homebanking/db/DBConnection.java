package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/mydb?user=root&password=root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
