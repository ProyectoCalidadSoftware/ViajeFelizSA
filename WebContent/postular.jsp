<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>POSTULAR</h1>
<%
	String error=(String)request.getAttribute("error");
	if (error != null) {
		out.print("<font color='red'>" + error + "</font>");
	}
%>
 <form action="Publicar" method=post>
 <p>Nombre: <input type="text" name="nombre"/><br>
 <p>Tipo de Alojamiento:<br>
 <input type="radio" name="alojamiento" value="casa" checked="checked"> Casa<br>
 <input type="radio" name="alojamiento" value="cabaña"> Cabaña<br>
 <p>Cantidad de personas:<br>
 <input type="radio" name="personas" value="personal" checked="checked"> Personal<br>
 <input type="radio" name="personas" value="doble"> Doble<br>
 <input type="radio" name="personas" value="familiar"> Familiar<br>
 <input type="radio" name="personas" value="multiple"> Multiple<br>
 <p>Número de habitaciones: <input type="number" name="habitaciones" min="1" value="1"/><br>
 <p>Número de baños: <input type="number" name="baños" min="1" value="1"/><br>
 <p>Calefacción:<input type="checkbox" name="calefaccion"/><br>
 <p>Aire acondicionado:<input type="checkbox" name="aire"/><br>
 <p>Mascotas:<input type="checkbox" name="mascotas"/><br>
 <p>Dirección: <input type="text" name="direccion"/><br>
 <p>Ciudad: <input type="text" name="ciudad"/><br>
 <p>Barrio: <input type="text" name="barrio"/><br>
 <p>Descripción: <textarea rows="4" cols="50" maxlength="400" name="descripcion"></textarea>
 <p>Precio: <input type="number" min="100.00"  step="100" name="precio" value="100"/>
 <p><input type ="submit" name = "submit" value = "Postular"> 
</form>
</body>
</html>