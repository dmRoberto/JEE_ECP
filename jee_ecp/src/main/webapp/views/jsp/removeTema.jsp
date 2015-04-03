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
	<h2>Eliminar tema</h2>
	<c:set var="rmTemaView" scope="request" value="${removeTema}" />
	<div>${rmTemaView.update()}</div>

	<form action="/votaciones/jsp/removeTema" method="post">
		<p>
			Listado temas: <select name="select" id="select">
				<c:forEach var="tema" items="${rmTemaView.temas}">
					<option value="${tema.id}">${tema.nombre}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			Codigo autorizacion: <input name="autorizacionCode" type="text"
				value="${rmTemaView.autorizacionCode}" />
		</p>
		<p>
			<input type="submit" value="Eliminar" />  ${rmTemaView.errorMsg}
		</p>
	</form>

	<p>
		<a href="/votaciones/jsp/home">Volver a Home</a>
	</p>
</body>
</html>