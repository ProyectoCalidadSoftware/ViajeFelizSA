<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>ENCUESTA</h1>
<%String idAlojamiento = (String)request.getAttribute("alojamiento"); %>
<form action="Encuesta?alojamiento=<%=idAlojamiento %>" method=post>
<p>Ubicación: <input type="number" name="ubicacion" min="1" max="5" value="1">
<p>Habitaciones: <input type="number" name="habitaciones" min="1" max="5" value="1">
<p>Servicio: <input type="number" name="servicio" min="1" max="5" value="1">
<p>Limpieza: <input type="number" name="limpieza" min="1" max="5" value="1">
<p>Calidad-precio: <input type="number" name="calidad" min="1" max="5" value="1">
<p>Comodidad: <input type="number" name="comodidad" min="1" max="5" value="1">
<p>Comida: <input type="number" name="comida" min="1" max="5" value="1">
<p>Mascotas: <input type="number" name="mascotas" min="1" max="5" value="1">
<p><input type ="submit" name = "submit" value = "Enviar"> 
</form>
</body>
</html>