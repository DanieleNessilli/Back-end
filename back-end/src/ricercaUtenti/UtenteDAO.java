package ricercaUtenti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sun.security.action.GetLongAction;

public class UtenteDAO {

	static Connection connection; 
	static ResultSet rs = null; 
	private static String pass;

	public static UtenteBean login(UtenteBean bean){
		Statement stmt = null; 
		pass=bean.getPass();
		bean.setLogin(false);


		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/videoteca", "daniele",
					"daniele");

			stmt = connection.createStatement();

			rs = stmt
					.executeQuery("SELECT * FROM amministratori WHERE email ='"
							+ bean.getEmail() + "'");

			while (rs.next()) {

				bean = new UtenteBean();
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setEmail(rs.getString("email"));
				bean.setPass(rs.getString("password"));
				bean.setRuolo(rs.getString("ruolo"));

				if (bean.getPass().equals(pass)) {

					
					if (bean.getRuolo().equals("admin")) {
						bean.setToken("token");
						bean.setLogin(true);
					}else bean.setLogin(false);
					
				} else {
					bean.setLogin(false);

				}
			}

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

		return bean;
	}

}
