 <%@page import="ricercaUtenti.UtenteBean"%>
 <%@ page errorPage="login.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ 
   page language="java" import="ricercaUtenti.UtenteBean.*, java.util.*"
	session="true" import="gestioneUtente.ricerca"%>    
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
	
							    <form method="POST" action="servletModificaUtente" >
								Inserisci nome <input name="nome" type="text"  required>
								<p>
									inserisci cognome <input type="text" name="cognome" required >
								</p>
								<p>
									inserisci email <input type="email" name="email" required>
								</p>
								<p>
									inserisci password <input type="password" name="password" required>
								</p>
								<p>
									inserisci ruolo <input type="text" name="ruolo" required>
								</p>
								<p>
									<input type="submit" value="Modifica &gt;&gt;" >
									
						       </p>
						   </form> 
							<p></p>
			</div>
	
		<!-- end #content -->

		<!-- end #sidebar -->
	</div>
	<!-- end #page -->
</body>
</html>