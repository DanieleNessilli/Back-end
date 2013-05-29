package aggiungiFilm;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

import ricercaFilm.FilmBean;

import com.oreilly.servlet.MultipartRequest;


/**
 * Servlet implementation class AggiungiFilm
 */
@WebServlet("/AggiungiFilm")
public class AggiungiFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
	   private String filePath;
	   private int maxFileSize = 1500 * 1024;
	   private int maxMemSize = 1500 * 1024;
	   private File file ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiFilm() {
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
		
		
		MultipartRequest m=new MultipartRequest(request, "D:\\Programmi\\EasyPHP\\www\\Front-end\\images"); 
		String titolo=m.getParameter("titolo");  
        String regia=m.getParameter("regia");  
        String attore=m.getParameter("attore");
        String tipo=m.getParameter("tipologia");
        String descrizione=m.getParameter("descrizione");
        String trailer=m.getParameter("trailer");
        String pic=m.getFilesystemName("file");
		
		FilmBean film=new FilmBean();

		film.setTitolo(titolo);
		film.setRegia(regia);
		film.setTipo(tipo);
		film.setAttore(attore);
		film.setDescrizione(descrizione);
		film.setTrailer(trailer);
		film.setLinkFoto(pic);
		
		
		
		
		
		// Check that we have a file upload request
	      isMultipart = ServletFileUpload.isMultipartContent(request);
	      response.setContentType("text/html");
	      java.io.PrintWriter out = response.getWriter( );
	      if( !isMultipart ){
	         out.println("<html>");
	         out.println("<head>");
	         out.println("<title>Servlet upload</title>");  
	         out.println("</head>");
	         out.println("<body>");
	         out.println("<p>No file uploaded</p>"); 
	         out.println("</body>");
	         out.println("</html>");
	         return;
	      }
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);
	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File("c:\\temp"));

	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      // maximum file size to be uploaded.
	      upload.setSizeMax( maxFileSize );

	      try{ 
	      // Parse the request to get file items.
	      List fileItems = upload.parseRequest(request);
		
	      // Process the uploaded file items
	      Iterator i = fileItems.iterator();
	      

	      
	      
	      while ( i.hasNext () ) 
	      {
	    	  
	         FileItem fi = (FileItem) i.next();
	         
	         if ( !fi.isFormField () )	
	         {
	            // Get the uploaded file parameters
	            String fieldName = fi.getFieldName();
	            String fileName = fi.getName();          //nome foto
	            System.out.println("foto:"+fileName);
	            String contentType = fi.getContentType();
	            boolean isInMemory = fi.isInMemory();
	            long sizeInBytes = fi.getSize();
	            System.out.println(fieldName);
	            System.out.println(fileName);
	            // Write the file
	            if( fileName.lastIndexOf("\\") >= 0 ){
	               file = new File( filePath + 
	               fileName.substring( fileName.lastIndexOf("\\"))) ;
	            }else{
	               file = new File( filePath + 
	               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
	            }
	            fi.write( file ) ;
	            
	         }
	      }
	     
	   }catch(Exception ex) {
	       System.out.println(ex);
	   }
		

		int ris=AggiungiFilmDAO.aggiungi(film);

		if(ris==1){
	    	 response.sendRedirect("gestioneFilm.jsp");
	    	 System.out.println("film aggiunto");
	    }else{
	    	response.sendRedirect("gestioneFilm.jsp");
	    	System.out.println("film non aggiunto");
		}

	}

}
