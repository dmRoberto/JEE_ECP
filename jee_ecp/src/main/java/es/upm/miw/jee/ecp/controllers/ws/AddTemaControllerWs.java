package es.upm.miw.jee.ecp.controllers.ws;

import es.upm.miw.jee.ecp.controllers.AddTemaController;
import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.ws.TemaUris;

public class AddTemaControllerWs implements AddTemaController {

	@Override
	public void addTema(Tema tema) {
		ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).create(tema);
	}

}
