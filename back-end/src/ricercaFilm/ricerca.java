package ricercaFilm;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ricerca implements Serializable {
	
	private Connection connection;
	private PreparedStatement titlesQuery;

	ResultSet rs;

	public ricerca(){

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/videoteca", "root",null);

			titlesQuery = connection.prepareStatement("SELECT * FROM elencoFilm ORDER BY titolo ASC");

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
	
	public ArrayList<FilmBean> getTitles() {
		
		ArrayList<FilmBean> titlesList = new ArrayList<FilmBean>();

		// obtain list of titles
		try {
			ResultSet results = titlesQuery.executeQuery();
			
			int i=0;

			// get row data originale
			while (results.next()) {
				i++;
				FilmBean book = new FilmBean();

				book.setTitolo(results.getString("titolo"));
				book.setRegia(results.getString("regia"));
				book.setAttore(results.getString("attore"));
				book.setTipo(results.getString("tipologia"));
				book.setDescrizione(results.getString("descrizione"));
				book.setTrailer(results.getString("trailer"));
				
				titlesList.add(book);
			}
			if(i==0) {
				FilmBean book = new FilmBean();
				book.setTitolo("non c'è");
				book.setRegia("");
				book.setAttore("");
				book.setTipo("");
			    titlesList.add(book);
			    return titlesList;
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
