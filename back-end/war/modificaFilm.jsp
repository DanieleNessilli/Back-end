<%@page import="ricercaFilm.FilmBean" import="ricercaUtenti.UtenteBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ 
   page language="java" import="ricercaFilm.FilmBean.*,java.util.*"
	session="true"  import="bookstore.ricerca"%> 
	<%@ page errorPage="login.html" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</meta>
<title>Videoteca</title>
<link media="screen" href="css/styles.css" type="text/css" rel="stylesheet">
</link>

</head>
<body>
	<div id="header">
		<p>
			<b> </b>
		</p>
		<br> </br>
		<div id="logo">
			<a href="index.jsp"><img width="261" height="130" src="images/logo.gif"></img>
			</a>
		</div>

		<div id="menu">
			<ul>
				<b>
					<li><a href="gestioneUtenti.jsp"> Menu Utenti </a></li>
					<li><a href="gestioneFilm.jsp"> Menu Film </a></li>
					<a href="logout.jsp"> Logout </a>
				</b>
				<br></br>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
		<!-- end #menu -->
	</div>
	<!-- end #header -->
	<div id="page">
		<div class="copy">
			<div class="entry">
				<h1 class="title">HOME</h1>
				<h4 align="right">
				<%
				  
                   UtenteBean utente = (UtenteBean) (session.getAttribute("sessioneUtente"));
				   
                %>
				Benvenuto  <%=" "+utente.getNome()+" "+utente.getCognome() %></h4>
				<p></p>   

													</div>
					</div>
	
							 <form method="POST" action="servletAggiungiFilm" >
								Inserisci Titolo <input name="titolo" type="text"  required>
								<p>
									inserisci Regia <input type="text" name="regia" required >
								</p>
								<p>
									inserisci Attore principale <input type="text" name="attore" required>
								</p>
								<p>
									inserisci Tipologia film <input type="text" name="tipologia" required>
								</p>
								
								<p>
								    inserisci Descrizione film <textarea name="descrizione" id="trama" maxlength="1000" wrap="hard"></textarea>
								</p>
								<p>
									inserisci URL Trailer <input type="url" name="trailer" required>
								</p>
								
								<p>
									<input type="submit" value="Aggiungi &gt;&gt;" >
									
						       </p>
						   </form> 
							</p>
						</div>
					</div>
				</div>

			</div>

			<div class="span1"></div>

		</div>

	</div>
		
		
</body>

</html>