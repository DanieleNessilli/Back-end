package rimuoviFilm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ricercaFilm.FilmBean;


/**
 * Servlet implementation class rimuoviFilm
 */
@WebServlet("/RimuoviFilm")
public class RimuoviFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        FilmBean film=new FilmBean();
		
		film.setTitolo(request.getParameter("titolo"));
	    
        int ris=RimuoviFilmDAO.rimuovi(film);
		
	    if(ris==1){
			  
	    	 response.sendRedirect("gestioneFilm.jsp");
	    	 System.out.println("film eliminato");
	    }else{
	    	response.sendRedirect("gestioneFilm.jsp");	
	    	System.out.println("film non eliminato, controllare i dati");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		FilmBean film=new FilmBean();
		
		film.setTitolo(request.getParameter("titolo"));
		
		int ris=RimuoviFilmDAO.rimuovi(film);
		
	    if(ris==1){
			  
	    	 response.sendRedirect("gestioneFilm.jsp");
	    	 System.out.println("film eliminato");
	    }else{
	    	response.sendRedirect("gestioneFilm.jsp");	
	    	System.out.println("film non eliminato, controllare i dati");
		}
		
	}

}
