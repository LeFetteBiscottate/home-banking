package lefettebiscottate.homebanking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class Main {

//	public static void main(String[] args) {
//		Statement stmt = null;
//		ResultSet rs = null;
//
//		try {
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?user=root&password=root");
//			stmt = connection.createStatement();
//			rs = stmt.executeQuery("SELECT 1");
//
//			if (rs.next())
//				System.out.println("Connessione a DB: OK");
//		}
//
//		catch (SQLException ex) {
//			System.out.println("SQLException: " + ex.getMessage());
//			System.out.println("SQLState: " + ex.getSQLState());
//			System.out.println("VendorError: " + ex.getErrorCode());
//		}
//
//		finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException sqlEx) {
//				} // ignore
//				rs = null;
//			}
//
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException sqlEx) {
//				} // ignore
//				stmt = null;
//			}
//		}
//	}
	
//	public static void main(String[] args) {
//
//        Server server = new Server(8080);
//
//        ServletContextHandler ctx = 
//                new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
//                
//        ctx.setContextPath("/");
//        server.setHandler(ctx);
//
//        ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/homeBanking/*");
//        serHol.setInitOrder(1);
//        serHol.setInitParameter("jersey.config.server.provider.packages", 
//                "lefettebiscottate.homebanking");
//
//        try {
//            server.start();
//            server.join();
//        } catch (Exception ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//
//            server.destroy();
//        }
//    }
//	public static void main(String[] args) throws Exception {
//        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context.setContextPath("/");
// 
//        Server jettyServer = new Server(8080);
//        jettyServer.setHandler(context);
// 
//        ServletHolder jerseyServlet = context.addServlet(
//             org.glassfish.jersey.servlet.ServletContainer.class, "/*");
//        jerseyServlet.setInitOrder(0);
// 
//        // Tells the Jersey Servlet which REST service/class to load.
//        jerseyServlet.setInitParameter(
//           "jersey.config.server.provider.classnames",
//           Main.class.getCanonicalName());
//        try {
//            jettyServer.start();
//            jettyServer.join();
//        } finally {
//            jettyServer.destroy();
//        }
//    }
}
