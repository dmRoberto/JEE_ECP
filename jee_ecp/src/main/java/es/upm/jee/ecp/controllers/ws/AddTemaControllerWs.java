package es.upm.jee.ecp.controllers.ws;

import es.upm.jee.ecp.ws.TemaUris;
import es.upm.miw.jee.ecp.controllers.AddTemaController;
import es.upm.miw.jee.ecp.models.entities.Tema;

public class AddTemaControllerWs implements AddTemaController {

	@Override
	public void addTema(Tema tema) {
		ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).create(tema);
	}

}
