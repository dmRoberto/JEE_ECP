package es.upm.miw.jee.ecp.views.beans;

import es.upm.miw.jee.ecp.controllers.AddTemaController;
import es.upm.miw.jee.ecp.controllers.ejb.ControllerFactoryEjb;
import es.upm.miw.jee.ecp.models.entities.Tema;

public class AddTemaView {

	private String errorMsg;

	private Tema tema;

	public AddTemaView() {
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public String process() {
		AddTemaController controller = ControllerFactoryEjb.getFactory()
				.getAddTemaController();
		
		controller.addTema(tema);
		return "home";
	}

}
