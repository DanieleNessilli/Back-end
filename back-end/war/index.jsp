<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" import="ricercaUtenti.UtenteBean" %>
<%@ page errorPage="login.html" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
				<table>
					<tbody>
						<tr>
							<td>
							
							</td>
						</tr>
						<tr>
							<td></td>
						</tr>
					</tbody>
				</table>
				<p></p>
			</div>
		</div>
		<!-- end #content -->

		<!-- end #sidebar -->
	</div>
	<!-- end #page -->
</body>
</html>