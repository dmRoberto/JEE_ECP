package es.upm.miw.jee.ecp.views.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.views.beans.AddTemaView;
import es.upm.miw.jee.ecp.views.beans.RemoveTemaView;
import es.upm.miw.jee.ecp.views.beans.VerVotacionesView;
import es.upm.miw.jee.ecp.views.beans.VotarView;

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
		case "removeTema":
			LogManager.getLogger(Dispatcher.class).debug(
					"GET remove tema " + request.toString());
			RemoveTemaView removeTemaView = new RemoveTemaView();
			request.setAttribute(action, removeTemaView);
			view = action;
			break;

		case "votar":
			LogManager.getLogger(Dispatcher.class).debug(
					"GET votar " + request.toString());
			VotarView votarView = new VotarView();
			request.setAttribute(action, votarView);
			view = action;
			break;
		case "verVotaciones":
			LogManager.getLogger(Dispatcher.class).debug(
					"GET verVotaciones " + request.toString());
			VerVotacionesView verVotacionesView = new VerVotacionesView();
			request.setAttribute(action, verVotacionesView);
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
		case "removeTema":
			LogManager.getLogger(Dispatcher.class).debug(
					"POST remove tema " + request.toString());
			RemoveTemaView removeTemaView = new RemoveTemaView();
			removeTemaView.setAutorizacionCode(request
					.getParameter("autorizacionCode"));
			LogManager.getLogger(Dispatcher.class).debug(
					"POST remove tema " + request.getParameter("select"));
			if (request.getParameter("select") != "") {
				removeTemaView.setTemaId(Integer.valueOf(request
						.getParameter("select")));
			}
			request.setAttribute(action, removeTemaView);
			view = removeTemaView.process();
			break;
		case "votar":
			LogManager.getLogger(Dispatcher.class).debug(
					"POST votar tema " + request.toString());
			VotarView votarView = new VotarView();
			votarView.setIp(request.getRemoteAddr());

			if (request.getParameter("selectTema") != "") {
				votarView.setTemaId(String.valueOf(request
						.getParameter("selectTema")));
				votarView.setTema(votarView.getTemaId());
			}

			if (request.getParameter("valoracion") != null) {
				votarView.setValoracion(Integer.valueOf(request
						.getParameter("valoracion")));
			}

			if (request.getParameter("selectEstudios") != null) {
				votarView.setNivelEstudios(request
						.getParameter("selectEstudios"));
			}

			request.setAttribute(action, votarView);
			view = votarView.process();
			break;
		case "verVotaciones":
			LogManager.getLogger(Dispatcher.class).debug(
					"POST VerVotacionesView tema " + request.toString());
			VerVotacionesView verVotacionesView = new VerVotacionesView();

			if (request.getParameter("selectTema") != "") {
				verVotacionesView.setTemaId(String.valueOf(request
						.getParameter("selectTema")));
				verVotacionesView.setTema(verVotacionesView.getTemaId());
			}

			request.setAttribute(action, verVotacionesView);
			view = verVotacionesView.process();
			break;

		default:
			view = "home";
		}
		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);

	}
}