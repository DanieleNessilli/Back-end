package rimuoviUtenti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import ricercaUtenti.UtenteBean;

public class RimuoviUtenteDAO {
	
	static Connection connection; 
	
	public static int rimuovi(UtenteBean bean){
		Statement stmt = null;
		int rs=0;
		
		try {

			 Class.forName("com.mysql.jdbc.Driver");
			 connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/videoteca", "root",null );

			 stmt = connection.createStatement();
			 
	
			 rs = stmt.executeUpdate("DELETE FROM amministratori WHERE email='"+bean.getEmail()+"'");
		     
			 
		 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 } catch (ClassNotFoundException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 } 
		
		return rs;
		
	}

}
