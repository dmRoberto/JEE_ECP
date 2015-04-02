<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>
		Eliminar tema</b>
	</h2>
	<c:set var="removeTemaView" scope="request" value="${tema}" />
	<div>${removeTemaView.update()}</div>
	<form action="/votaciones/jsp/removeTema" method="post">
		<p>Listado temas</p>

		<select name="select" id="select" >
			<c:forEach var="tema" items="${removeTemaView.temas}">
				<option value="${tema.id}">${tema.nombre}</option>
			</c:forEach>
		</select>

		<p>
			<input type="submit" value="Eliminar" />
		</p>
	</form>

	<p>
		<a href="/votaciones/jsp/home">Volver a Home</a>
	</p>
</body>
</html>