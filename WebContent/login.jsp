<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Log In</h1>
 <form action="j_security_check" method=post>
 <p>Usuario : <input type="text" name="j_username"/><br>
 <p>Contraseña : <input type="password" name = "j_password"/><br>
 <p><input type ="submit" name = "submit" value = "Ingresar">
</form>
<a href="../registro.jsp">Registrar</a>
</body>
</html>