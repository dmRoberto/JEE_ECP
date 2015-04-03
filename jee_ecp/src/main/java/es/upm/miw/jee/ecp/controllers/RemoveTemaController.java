package es.upm.miw.jee.ecp.controllers;

import java.util.List;

import es.upm.miw.jee.ecp.models.entities.Tema;

public interface RemoveTemaController {
	
	public static String AUTH_CODE = "666";

	public Boolean removeTema(Integer temaId, String autorizacionCode);

	public List<Tema> getTemasList();

}
