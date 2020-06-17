package lefettebiscottate.homebanking.db;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class DatabaseCredentials {
	private static final String HOST;
	private static final String PORT;
	private static final String DB;
	private static final String USER;
	private static final String PASS;
	

	static {
		String dbProperties = "db.properties";
		File fileProperties = new File("src/main/resources/" + dbProperties);

		Reader reader = null;
		Properties prop = new Properties();

		try {
			reader = new FileReader(fileProperties);
			prop.load(reader);
		}

		catch (IOException e) {
			// BLABLABLA
			e.printStackTrace();
		}
		
		HOST = prop.getProperty("host");
		PORT = prop.getProperty("port");
		DB = prop.getProperty("db");
		USER = prop.getProperty("user");
		PASS = prop.getProperty("pass");
	}


	public static String getHost() {
		return HOST;
	}


	public static String getPort() {
		return PORT;
	}

	public static String getDB() {
		return DB;
	}

	public static String getUser() {
		return USER;
	}


	public static String getPass() {
		return PASS;
	}
	
	

}
