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
%>
<form action="BuscarAlojamiento" method=post>

<p>Fecha de inicio: <input name="fechaInicio" type="date" min="<%=today%>">
<p>Fecha de finalización: <input name="fechaFin" type="date" min="<%=today%>">
<p>Alojamiento: <select name="alojamiento"><option value="idcasa">Casa</option><option value="idcabaña">Cabaña</option></select>
<p>Número de habitaciones: <input type="number" name="habitaciones"/>
<p>Ciudad: <select name="ciudad"><option value="idciudad1">ciudad 1</option><option value="idciudad2">ciudad 2</option></select>
<p><input type ="submit" name = "submit" value = "Buscar"> 
</form>
</body>
</html>