package lefettebiscottate.homebanking.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lefettebiscottate.homebanking.entity.CurrentAccountEntity;
import lefettebiscottate.homebanking.entity.PrestitoEntity;
import lefettebiscottate.homebanking.entity.TipoPrestito;

public class PrestitoDao {
	
	private static Connection con = DBConnection.getConnection();
	
	public PrestitoEntity getByIdAccount(int account_id) {
		PrestitoEntity p = new PrestitoEntity();
		
		try {
			
			String query = "SELECT * FROM prestito WHERE account_id = "+ account_id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				p.setId(rs.getInt(1));
				p.setImporto(rs.getDouble(2));
				p.setInterest(rs.getDouble(3));
				p.setAccount(account);
				p.setN_rata(rs.getInt(5));
				p.setI_rata(rs.getDouble(6));
				p.setDurata(rs.getString(7));
				p.setNumero_rata_mancanti(rs.getInt(8));
				p.setType(TipoPrestito.valueOf(rs.getString(9)));
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return p;
	}
	
	
	public List<PrestitoEntity> getAll() {
		 List<PrestitoEntity> prestiti = new ArrayList<PrestitoEntity>();
		 
		 try {
			 String query = "SELECT * FROM prestito";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 
			 while(rs.next()) {
				 PrestitoEntity p = new PrestitoEntity();
				 p.setId(rs.getInt(1));
				 p.setImporto(rs.getDouble(2));
				 p.setInterest(rs.getDouble(3));
			     p.setAccount(account);
				 p.setN_rata(rs.getInt(5));
				 p.setI_rata(rs.getDouble(6));
				 p.setDurata(rs.getString(7));
				 p.setNumero_rata_mancanti(rs.getInt(8));
				 p.setType(TipoPrestito.valueOf(rs.getString(9)));
					
				 prestiti.add(p);
			 }
			 
			 rs.close();
			 stmt.close();
					
			 } catch(SQLException e) {
				 e.printStackTrace();
			 }
			 return prestiti;
	 }
	
	
	
	public boolean insert(PrestitoEntity p) {
		boolean result = false;
		String query = "INSERT INTO prestito VALUES(import, interest, account_id, numero_rata,"
				+ "importo_rata, durata, numero_rata_mancanti, prestito_type) VALUES ("
				+p.getImporto()+", "+p.getInterest()+", "+p.getAccount().getId()+", "+p.getN_rata()
				+", "+p.getI_rata()+", '"+p.getDurata()+"', "+p.getNumero_rata_mancanti()+", '"
				+p.getType()+"')";
				
		try {
			Statement stmt = con.createStatement();
			int rs = stmt.executeUpdate(query);
			result = true;
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	public boolean update(PrestitoEntity p) {
		boolean result = false;
		String query = "UPDATE prestito SET numero_rata_mancanti = "+p.getNumero_rata_mancanti()+
						"WHERE id = "+p.getId();
		
		try {
			Statement stmt = con.createStatement();
			int rs = stmt.executeUpdate(query);
			result = true;
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean delete(PrestitoEntity p) {
		boolean result = false;
		String query = "DELETE FROM prestito WHERE id = "+p.getId();
		
		try {
			Statement stmt = con.createStatement();
			int rs = stmt.executeUpdate(query);
			result = true;
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

