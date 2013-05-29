package modificaUtente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import ricercaUtenti.UtenteBean;

public class ModificaUtenteDAO {
	
	static Connection connection; 
    
	 
	 public static int modifica(UtenteBean bean){
		 Statement stmt = null; 
		 int rs=0;
		 
		 try {

			 Class.forName("com.mysql.jdbc.Driver");
			 connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/videoteca", "daniele","daniele");

			 stmt = connection.createStatement();
			 rs = stmt.executeUpdate("UPDATE amministratori SET nome='"+bean.getNome()+"', cognome='"+bean.getCognome()+"', email='"+bean.getEmail()+"', password='"+bean.getPass()+"', ruolo='"+bean.getRuolo()+"' WHERE email='"+bean.getEmail()+"'" );
			
		 
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
		 
		 return rs;

	 }

}
