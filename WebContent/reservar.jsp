<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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

</body>
<%
Date date = Calendar.getInstance().getTime();
DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
String today = formatter.format(date);
String precio = (String)request.getAttribute("precio");
String preciomin = (String)request.getAttribute("preciomin");
String error=(String)request.getAttribute("error");
if (error != null) {
	out.print("<font color='red'>" + error + "</font>");
}
String exito=(String)request.getAttribute("exito");
if (exito != null) {
	out.print("<font color='red'>" + exito + "</font>");
}
%>
<form action="Reservar" method=post>
<input type="hidden" name="id" value="<%=request.getParameter("id")%> "/><br>
<input type="hidden" name="user" value="<%=request.getUserPrincipal().getName()%> "/><br>
<input type="hidden" name="fecIni" value="<%=request.getParameter("fechainicio")%>"/><br>
<input type="hidden" name="fecFin" value="<%=request.getParameter("fechafin")%>"/><br>
<h1>RESERVACION</h1>
<p>Nombre Completo* : <input type="text" name="fullname"/><br>
<p>Número de Identificación* : <input type="number" name="identificacion"/><br>
<p>Dirección de residencia* : <input type="text" name="residencia"/><br>
<p>Teléfono fijo : <input type="number" name="telefono"/><br>
<p>Celular* : <input type="number" name="celular"/><br>
<p>Número de la tarjeta* : <input type="number" name="numerotarjeta"/><br>
<p>Fecha expiración* : <input type="date" name="fechaexp"  value="<%=today%>" /><br>
<p>Tu nombre como aparece en la tarjeta* : <input type="text" name="nombretarjeta"/><br>
<p>Precio Total Alojamiento : <input type="number" name="precio" readonly="readonly" value="<%=precio%>"/><br>
<p>Pago mínimo* : <input type="number" name="preciominimo" value="<%=preciomin%>" min="<%=preciomin%>"/><br>
<p><input type ="submit" name = "submit" value = "Aceptar">
</form>
</html>