<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Inicio Estudiante</h1>
 <%
 out.println("<h2>"+request.getUserPrincipal().getName()+
"</h2>"); 
 %>
 <a href="../salir.jsp">Salir</a>
 <a href="../postular.jsp">Postular alojamiento</a>
</body>
</html>