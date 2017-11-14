<%@page import="dto.AlojamientoDTO"%>
<%@page import="java.util.ArrayList"%>
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
ArrayList<AlojamientoDTO> aList = (ArrayList<AlojamientoDTO>)request.getAttribute("alojamientos");
String fechaInicio = (String)request.getAttribute("fechaini");
String fechaFin = (String)request.getAttribute("fechafin");
%>
<table style="width:100%">
<tr>
 <th>Nombre Alojamiento</th>
 <th>Ver</th> 
</tr>
<%
for (int i = 0; i < aList.size(); i++) {	
%>
	  <tr>
	  <td> <%= aList.get(i).getNombre() %> </td>
	  <td><a href="BuscarAlojamiento?id=<%=aList.get(i).getId()%>&fechainicio=<%=fechaInicio %>&fechafin=<%=fechaFin %>"> <%=aList.get(i).getNombre() %> </a></td>
	  </tr>
<%
}
%>
</table>
</body>
</html>