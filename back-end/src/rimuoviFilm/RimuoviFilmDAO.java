package rimuoviFilm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import ricercaFilm.FilmBean;



public class RimuoviFilmDAO {
	static Connection connection; 
	
	public static int rimuovi(FilmBean bean){
		Statement stmt = null;
		int rs=0;
		
		try {

			 Class.forName("com.mysql.jdbc.Driver");
			 connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/videoteca", "daniele","daniele");

			 stmt = connection.createStatement();
			 
			 rs = stmt.executeUpdate("DELETE FROM elencofilm WHERE titolo='"+bean.getTitolo()+"'");
		     
			 
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
