package aggiungiFilm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import ricercaFilm.FilmBean;



public class AggiungiFilmDAO {
	static Connection connection; 
	
	 public static int aggiungi(FilmBean bean){
		 Statement stmt = null;
		 int rs=0;
		
		 try {

			 Class.forName("com.mysql.jdbc.Driver");
			 connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/videoteca", "daniele","daniele" );

			 stmt = connection.createStatement();
			 
			 rs = stmt.executeUpdate("INSERT INTO elencofilm (titolo,regia,attore,tipologia,descrizione,trailer,linkfoto) VALUES ('"+bean.getTitolo()+"','"+bean.getRegia()+"','"+bean.getAttore()+"','"+bean.getTipo()+"','"+bean.getDescrizione()+"','"+bean.getTrailer()+"','images/"+bean.getLinkFoto()+"')");
		 
		 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 System.out.println(" 1 ecc");
			 e.printStackTrace();
		 } catch (ClassNotFoundException e) {
			 // TODO Auto-generated catch block
			 System.out.println("2 ecc");
			 e.printStackTrace();
		 } catch(Throwable theException) { 
			 System.out.println("3 ecc"); 
		 }	
		 
		 System.out.println("rs: "+rs);
		 return rs;
	 
	 }	 

}
