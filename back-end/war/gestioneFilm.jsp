<%@page import="ricercaUtenti.UtenteBean" %>
 <%@page import="ricercaFilm.FilmBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ 
   page language="java" import="java.util.*" session="true"
	import="ricercaFilm.ricerca"%>
<%@ page errorPage="login.html" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</meta>
<title>Videoteca</title>
<link media="screen" href="css/styles.css" type="text/css"
	rel="stylesheet">
</link>

</head>
<body>
	<div id="header">
		<p>
			<b> </b>
		</p>
		<br> </br>
		<div id="logo">
			<a href="index.jsp"><img width="261" height="130"
				src="images/logo.gif"></img> </a>
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
				<h1 class="title">Menu Film</h1>
				<h4 align="right">
					<%
						UtenteBean utente = (UtenteBean) (session.getAttribute("sessioneUtente"));
					%>
					Benvenuto
					<%=" "+utente.getNome()+" "+utente.getCognome()%></h4>
				<p></p>

				<%
					ricerca ricerca = new ricerca();
									ArrayList<FilmBean> titles=ricerca.getTitles();
									
									FilmBean film;
									
									Iterator iterator = titles.iterator();
									while ( iterator.hasNext() ) {
								         film = ( FilmBean ) iterator.next();
				%>
				</form>
				<table BORDER="1px" width="600px">
					<tr>
						<td width="180px">
							<h5>
								<%=film.getTitolo() %>
							</h5>
						</td>
						<td width="220px">
							<h5>
								<%=film.getAttore() %>
							</h5>
						</td>
						<td width="80px">
							<h5>
								<%=film.getRegia()%>
							</h5>
						</td>
						<td width="60px">
							<h5>
								<a href="servletRimuoviFilm?titolo=<%=film.getTitolo() %>"><button>Rimuovi</button></a>
							</h5>
						</td>
						<!--<td width="60px" >
						    <h5>
						    <a href="modificaFilm.jsp"><button>Modifica</button></a>
						    </h5>
						    </td> -->
					</tr>
				</table>
				<%
							}
							%>
				</td>
				</tr>
				<tr>
					<td></td>

				</tr>
				<p></p>
				<a href="aggiungiFilm.jsp"><button>Aggiungi Film</button></a>
			</div>
		</div>
		<!-- end #content -->

		<!-- end #sidebar -->
	</div>
	<!-- end #page -->
</body>
</html>