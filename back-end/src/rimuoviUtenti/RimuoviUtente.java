package rimuoviUtenti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ricercaUtenti.UtenteBean;

/**
 * Servlet implementation class RimuoviUtente
 */
@WebServlet("/RimuoviUtente")
public class RimuoviUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UtenteBean utente=new UtenteBean();
		utente.setEmail(request.getParameter("email"));
		System.out.println(request.getParameter("email"));
		
		int ris=RimuoviUtenteDAO.rimuovi(utente);
		System.out.println(ris);
		if(ris==1){
	    	 response.sendRedirect("gestioneUtenti.jsp");
	
	    }else{
	    	response.sendRedirect("gestioneUtenti.jsp");	
	    	System.out.println("utente non eliminato, controllare i dati");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UtenteBean utente=new UtenteBean();
		
		//utente.setNome(request.getParameter("nome"));
		//utente.setCognome(request.getParameter("cognome"));
		utente.setEmail(request.getParameter("email"));
		//utente.setPass(request.getParameter("password"));
		
		System.out.println(utente.getEmail());
		
		int ris=RimuoviUtenteDAO.rimuovi(utente);
		
		if(ris==1){
	    	 response.sendRedirect("gestioneUtenti.jsp");
	
	    }else{
	    	response.sendRedirect("gestioneUtenti.jsp");	
	    	System.out.println("utente non eliminato, controllare i dati");
		}
		
	}

}
