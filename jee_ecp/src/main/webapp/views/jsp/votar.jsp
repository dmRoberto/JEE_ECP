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
	<h2>Votar</h2>
	<c:set var="votarView" scope="request" value="${votar}" />
	<div>${votarView.update()}</div>

	<c:choose>
		<c:when test="${empty votarView.temaId}">
			<form action="/votaciones/jsp/votar" method="post">
				<p>
					Listado temas: <select name="selectTema" id="selectTema">
						<c:forEach var="tema" items="${votarView.temas}">
							<option value="${tema.id}">${tema.nombre}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<input type="submit" value="Seleccionar" />
				</p>
			</form>

		</c:when>
		<c:otherwise>
			<form action="/votaciones/jsp/votar" method="post">
				<input type="hidden" name="selectTema" value="${votarView.tema.id}" />
				<p>${votarView.tema.pregunta}</p>
				<p>
					Valoracion: <input type="range" id="valoracion" name="valoracion"
						value="0" min="0" max="10">
				</p>
				<p>
					Niveles Estudios: <select name="selectEstudios" id="selectEstudios">
						<c:forEach var="nivelesEstudios"
							items="${votarView.nivelesEstudios}">
							<option value="${nivelesEstudios}">${nivelesEstudios}</option>
						</c:forEach>

					</select>
				</p>
				<p>
					<input type="submit" value="Votar" /> ${rmTemaView.errorMsg}
				</p>
			</form>
		</c:otherwise>
	</c:choose>



	<p>
		<a href="/votaciones/jsp/home">Volver a Home</a>
	</p>
</body>
</html>