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
	<h2>Ver votaciones</h2>
	<c:set var="verVotacionesView" scope="request" value="${verVotaciones}" />
	<div>${verVotacionesView.update()}</div>

	<c:choose>
		<c:when test="${empty verVotacionesView.temaId}">
			<form action="/votaciones/jsp/verVotaciones" method="post">
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
			<form action="/votaciones/jsp/verVotaciones" method="post">
				<input type="hidden" name="selectTema"
					value="${verVotacionesView.tema.id}" />
				<p>Numero total de votos: ${verVotacionesView.numeroVotos}</p>

				<c:forEach var="estudios"
					items="${verVotacionesView.nivelesEstudios}">
					<p>Estudios: ${estudios}</p>
					<br />
					<p>Votacion media:
						${verVotacionesView.mediasByEstudios.get(estudios)}</p>

					<br />
				</c:forEach>

			</form>
		</c:otherwise>
	</c:choose>

	<p>
		<a href="/votaciones/jsp/home">Volver a Home</a>
	</p>
</body>
</html>