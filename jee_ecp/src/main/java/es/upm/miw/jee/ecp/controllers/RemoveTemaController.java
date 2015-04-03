package es.upm.miw.jee.ecp.controllers;

public interface RemoveTemaController {
	
	public static String AUTH_CODE = "666";

	public Boolean removeTema(Integer temaId, String autorizacionCode);

}
