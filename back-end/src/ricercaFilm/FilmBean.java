// BookBean.java
// A BookBean object contains the data for one book.
package ricercaFilm;

// Java core packages
import java.io.*;

public class FilmBean implements Serializable {
   private static final long serialVersionUID = 6723471178342776147L;
   private String titolo,regia,attore,tipo,descrizione,trailer,linkfoto;
   
   public void setLinkFoto(String link){
	   
	   this.linkfoto=link;
	   
   }
   
   public String getLinkFoto(){
	   return linkfoto;
   }
   
   public void setTrailer(String trailer){
	   
	   this.trailer=trailer;
	   
   }
   
   public String getTrailer(){
	   return trailer;
   }
   public void setTitolo( String titolo )
   {
      this.titolo=titolo;
   }
   
   
   public String getTitolo()
   {
      return this.titolo;
   }
   
  
   public void setRegia( String regia )
   {
      this.regia=regia;
   }
   
   
   public String getRegia()
   {
      return this.regia;
   }
   
   
   public void setAttore( String attore )
   {
      this.attore=attore;
   }
   
   
   public String getAttore()
   {
      return this.attore;
   }
   
   
   public void setTipo( String tipo )
   {
      this.tipo=tipo;
   }
   
   
   public String getTipo()
   {
      return this.tipo;
   }
   
   public String getDescrizione(){
	   return descrizione;
   }
   
   public void setDescrizione(String descr){
	   this.descrizione=descr;
   }
   
}