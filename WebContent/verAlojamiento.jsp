<%@page import="dto.AlojamientoDTO"%>
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
String id = request.getParameter("id");
String fechaInicio = request.getParameter("fechainicio");
String fechaFin = request.getParameter("fechafin");
String precio = (String)request.getAttribute("precio");
%>
<p>Nombre: <h4>${alojamiento.getNombre()}</h4>
<p>Tipo de Alojamiento: <h4>${alojamiento.getTipo() == true ? "Casa" : "Caba�a"}</h4>
<p>Cantidad de personas: <h4>${alojamiento.getCantidadPersonas()}</h4>
<p>N�mero de habitaciones: <h4>${alojamiento.getCantidadHabitaciones()}</h4>
<p>N�mero de ba�os: <h4>${alojamiento.getCantidadBanos()}</h4>
<p>Calefacci�n: <h4>${alojamiento.isCalefaccion() == true ? "Si" : "No"}</h4>
<p>Aire acondicionado: <h4>${alojamiento.isAireAcondicionado() == true ? "Si" : "No"}</h4>
<p>Mascotas: <h4>${alojamiento.isMascotas() == true ? "Si" : "No"}</h4>
<p>Direcci�n: <h4>${alojamiento.getDireccion()}</h4>
<p>Ciudad: <h4>${alojamiento.getCiudad()}</h4>
<p>Barrio: <h4>${alojamiento.getBarrio()}</h4>
<p>Descripci�n: <textarea rows="4" cols="50" readonly="readonly">${alojamiento.getDescripcion()}</textarea>
<p>Precio: <h4>${alojamiento.getPrecio()}</h4>
<p><a href="Reservar?id=<%=id %>&fechainicio=<%=fechaInicio%>&fechafin=<%=fechaFin%>&precio=<%=precio%>">Reservar</a>
</body>
</html>