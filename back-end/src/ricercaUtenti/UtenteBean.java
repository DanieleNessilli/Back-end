package ricercaUtenti;


public class UtenteBean {
	
	private String nome,cognome,email, token, password,ruolo;
	private int cartaCredito,cap;
	private Boolean login;
	
	public void setRuolo(String ruolo){
		this.ruolo=ruolo;
	}
	
	public String getRuolo(){
		return ruolo;
	}
	
	public void setPass(String pass){
		this.password=pass;
	}
	
	public String getPass(){
		return password;
	}
	
	public void setToken(String token){
		this.token=token;
	}
	
	public String getToken(){
		return token;
	}
	
	public void setLogin(Boolean log){
		this.login=log;
	}
	
	public Boolean getLogin(){
		return login; 
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}

	public String getNome(){
		return nome;
	}
	
	public void setCognome(String cognome){
		this.cognome=cognome;
	}
	
	public String getCognome(){
		return cognome;
	}
	
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getEmail(){
		return email;
	}
	
	
	public void setData(int data){
		cartaCredito=data;
	}
	
	public int getData(){
		return cartaCredito;
	}
	
	public void setCap(int cap){
		cap=cap;
	}
	
	public int getCap(){
		return cap;
	}
}
