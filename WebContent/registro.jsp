<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>REGISTRO</h1>
<%
	String error=(String)request.getAttribute("error");
	if (error != null) {
		out.print("<font color='red'>" + error + "</font>");
	}
%>
 <form action="RegistroUsuarios" method=post>
 <p>Nombre Completo : <input type="text" name="fullname"/><br>
 <p>Usuario : <input type="text" name="username"/><br>
 <p>Contraseña : <input type="password" name="password"/><br>
 <p><input type ="submit" name = "submit" value = "Registrar">
</form>
</body>
</html>