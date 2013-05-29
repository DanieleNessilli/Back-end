package ricercaUtenti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RicercaUtente
 */
@WebServlet("/RicercaUtente")
public class RicercaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaUtente() {
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

		utente.setEmail(request.getParameter("email"));
		utente.setPass(request.getParameter("password"));
		
	    utente = UtenteDAO.login(utente);
	    
	   
	    
	    if(utente.getLogin()){
	    	 HttpSession session = request.getSession(true); 
	    	 session.setAttribute("sessioneUtente",utente); 
	    	 response.sendRedirect("index.jsp");
	    }else{
	    	response.sendRedirect("login.html");	
	    }
	}

}
