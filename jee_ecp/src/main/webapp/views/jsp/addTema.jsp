<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aplicacion Votaciones - JSP</title>
</head>
<body>
	<h2>Añadir tema</h2>
	<c:set var="addView" scope="request" value="${addTemaView}" />
	<form action="/votaciones/jsp/addTema" method="post">
		<p>
			Nombre: <input name="nombre" type="text"
				value="${addView.tema.nombre}" />${addView.errorMsg}</p>
		<p>
			Pregunta: <input name="pregunta" type="text"
				value="${addView.tema.pregunta}" />${addView.errorMsg}</p>
		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>
	<p>
		<a href="/votaciones/jsp/home">Volver a Home</a>
	</p>
</body>
</html>