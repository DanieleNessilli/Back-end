package aggiungiUtenti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ricercaUtenti.UtenteBean;

/**
 * Servlet implementation class AggiungiUtenti
 */
@WebServlet("/AggiungiUtenti")
public class AggiungiUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiUtenti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UtenteBean utente=new UtenteBean();
		
		utente.setNome(request.getParameter("nome"));
		utente.setCognome(request.getParameter("cognome"));
		utente.setEmail(request.getParameter("email"));
		utente.setPass(request.getParameter("password"));
		utente.setRuolo(request.getParameter("ruolo"));
		
		int ris=AggiungiUtenteDAO.aggiungi(utente);
		
		if(ris==1){
	    	 response.sendRedirect("gestioneUtenti.jsp");
	    	 System.out.println("utente aggiunto");
	    }else{
	    	response.sendRedirect("gestioneUtenti.jsp");
	    	System.out.println("utente non aggiunto");
		}

	}

}
