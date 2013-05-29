package gestioneUtente;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ricercaUtenti.UtenteBean;

public class ricerca implements Serializable {
	
	private Connection connection;
	private PreparedStatement titlesQuery;

	ResultSet rs;

	public ricerca(){

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/videoteca", "root",null );

			titlesQuery = connection.prepareStatement("SELECT * FROM amministratori ORDER BY nome");

		}

		// process exceptions during database setup
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		// process problems locating data source
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public ArrayList<UtenteBean> getTitles() {
		
		ArrayList<UtenteBean> titlesList = new ArrayList<UtenteBean>();

		// obtain list of titles
		try {
			ResultSet results = titlesQuery.executeQuery();
			

			// get row data originale
			while (results.next()) {
			
				UtenteBean utenti = new UtenteBean();

				utenti.setNome(results.getString("nome"));
				utenti.setCognome(results.getString("cognome"));
				utenti.setEmail(results.getString("email"));
				utenti.setRuolo(results.getString("ruolo"));
				
				titlesList.add(utenti);
			}
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		
		return titlesList;
	}
	
	protected void finalize() {
		// attempt to close database connection
		try {
			connection.close();
		}

		// process SQLException on close operation
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

}
