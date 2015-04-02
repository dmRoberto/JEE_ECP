package es.upm.miw.jee.ecp.views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import es.upm.miw.jee.ecp.controllers.RemoveTemaController;
import es.upm.miw.jee.ecp.controllers.TemaController;
import es.upm.miw.jee.ecp.controllers.ejb.ControllerFactoryEjb;
import es.upm.miw.jee.ecp.models.entities.Tema;

public class RemoveTemaView {

	private String errorMsg;

	private List<Tema> temas;

	private int temaId = 0;

	public String getErrorMsg() {
		return errorMsg;
	}

	@PostConstruct
	public void update() {

		TemaController controller = ControllerFactoryEjb.getFactory()
				.getTemaController();
		temas = new ArrayList<Tema>();
		temas.add(new Tema("Elige", "", null));

		for (Tema tema : controller.getTemasList()) {
			temas.add(tema);
		}
	}

	public String process() {

		RemoveTemaController controller = ControllerFactoryEjb.getFactory()
				.getRemoveTemaController();
		controller.removeTema(temaId);
		return null;
	}

	public List<Tema> getThemes() {
		return temas;
	}

	public void setThemes(List<Tema> temas) {
		this.temas = temas;
	}

	public int getThemeId() {
		return temaId;
	}

	public void setThemeId(int temaId) {
		this.temaId = temaId;
	}

}
