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
		Vista de <b>A�adir tema</b>
	</h2>
	<c:set var="addTemaView" scope="request" value="${tema}" />
	<div>${pView.update()}</div>
	<form action="/Web/jsp/addTema" method="post">
		<p>
			Nombre: <input name="nombre" type="text"
				value="${addTemaView.tema.nombre}" />${pView.errorMsg}</p>
		<p>
			Pregunta: <input name="pregunta" type="text"
				value="${addTemaView.tema.pregunta}" />${pView.errorMsg}</p>
		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>
	<p>
		<a href="/Web/jsp/home">Volver a Home</a>
	</p>
</body>
</html>