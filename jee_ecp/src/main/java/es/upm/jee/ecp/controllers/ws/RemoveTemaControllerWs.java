package es.upm.jee.ecp.controllers.ws;

import java.util.List;

import javax.ws.rs.core.GenericType;

import es.upm.jee.ecp.ws.TemaUris;
import es.upm.miw.jee.ecp.controllers.RemoveTemaController;
import es.upm.miw.jee.ecp.models.entities.Tema;

public class RemoveTemaControllerWs implements RemoveTemaController {

	@Override
	public Boolean removeTema(Integer temaId, String autorizacionCode) {
		WsManager webServicesManager = ControllerWs.buildWebServiceManager(
				TemaUris.PATH_TEMAS, String.valueOf(temaId));
		webServicesManager.addParams("auth", autorizacionCode);
		return webServicesManager.delete();
	}

	@Override
	public List<Tema> getTemasList() {
		GenericType<List<Tema>> gerericType = new GenericType<List<Tema>>() {
		};
		return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS)
				.entities(gerericType);
	}

}
