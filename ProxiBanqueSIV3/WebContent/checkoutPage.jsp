<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deconnexion</title>
</head>
<body>
	<h3>${user} voulez-vous vous d�connecter ?</h3>
	<br>
	<form action="ServletLogout" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>