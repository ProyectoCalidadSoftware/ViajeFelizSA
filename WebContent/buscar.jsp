<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Date date = Calendar.getInstance().getTime();
DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
String today = formatter.format(date);

String notfound = (String)request.getAttribute("notfound");
if (notfound != null) {
	out.print("<font color='red'>" + notfound + "</font>");
}

String error=(String)request.getAttribute("error");
if (error != null) {
	out.print("<font color='red'>" + error + "</font>");
}

%>
<form action="BuscarAlojamiento" method=post>
<p>Fecha de inicio: <input name="fechaInicio" type="date" id="calendar" min="<%=today%>" placeholder="YYYY-MM-DD" value="<%=today %>">
<p>Fecha de finalización: <input name="fechaFin" type="date" min="<%=today%>" placeholder="YYYY-MM-DD" value="<%=today %>">
<p>Alojamiento: <select name="alojamiento"><option value="casa">Casa</option><option value="cabaña">Cabaña</option></select>
<p>Número de habitaciones: <input type="number" name="habitaciones" value="1"/>
<p>Ciudad: <input name="ciudad" type="text" id="ciudad">
<p><input type ="submit" name = "submit" value = "Buscar"> 
</form>
</body>
</html>