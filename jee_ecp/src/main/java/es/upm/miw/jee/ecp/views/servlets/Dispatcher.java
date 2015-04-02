package es.upm.miw.jee.ecp.views.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.views.beans.AddTemaView;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/views/jsp/";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo().substring(1);

		String view;
		switch (action) {
		case "addTema":
			AddTemaView addTemaView = new AddTemaView();
			addTemaView.setTema(new Tema());
			request.setAttribute(action, addTemaView);
			view = action;
			break;
		default:
			view = "home";
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String view = "home";
		switch (action) {
		case "addTema":
			Tema tema = new Tema();
			tema.setNombre(request.getParameter("nombre"));
			tema.setPregunta(request.getParameter("pregunta"));
			AddTemaView addTemaView = new AddTemaView();
			addTemaView.setTema(tema);
			request.setAttribute(action, addTemaView);
			view = addTemaView.process();
			break;

		default:
			view = "home";
		}
		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);

	}
}