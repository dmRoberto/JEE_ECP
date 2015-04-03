package es.upm.miw.jee.ecp.views.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.jee.ecp.controllers.RemoveTemaController;
import es.upm.miw.jee.ecp.controllers.ejb.ControllerFactoryEjb;
import es.upm.miw.jee.ecp.models.entities.Tema;

public class RemoveTemaView {

	private String errorMsg;

	private List<Tema> temas;

	private String autorizacionCode = "";

	private Integer temaId = null;

	public RemoveTemaView() {
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void update() {
		LogManager.getLogger(RemoveTemaView.class).debug("Updating view... ");
		RemoveTemaController controller = ControllerFactoryEjb.getFactory()
				.getRemoveTemaController();
		temas = new ArrayList<Tema>();
		temas.add(new Tema("Elige", "", null));

		for (Tema tema : controller.getTemasList()) {
			temas.add(tema);
		}

		LogManager.getLogger(RemoveTemaView.class).debug(
				"END Updating view... ");
	}

	public String process() {

		RemoveTemaController controller = ControllerFactoryEjb.getFactory()
				.getRemoveTemaController();
		if (temaId == null) {
			this.errorMsg = "No se selecciono ningun tema.";
			return "removeTema";
		}
		if (!controller.removeTema(temaId, autorizacionCode)) {
			this.errorMsg = "Codigo de autorizacion erroneo. No se realizo la operacion.";
			return "removeTema";
		}

		return "home";
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public int getTemaId() {
		return temaId;
	}

	public void setTemaId(int temaId) {
		this.temaId = temaId;
	}

	public String getAutorizacionCode() {
		return autorizacionCode;
	}

	public void setAutorizacionCode(String autorizacionCode) {
		this.autorizacionCode = autorizacionCode;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
