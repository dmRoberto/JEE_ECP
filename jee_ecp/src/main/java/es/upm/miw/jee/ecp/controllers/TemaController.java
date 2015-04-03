package es.upm.miw.jee.ecp.controllers;

import java.util.List;

import es.upm.miw.jee.ecp.models.entities.Tema;

public interface TemaController {
	
	public List<Tema> getTemasList();
	
	public Tema getTema(Integer id);

}
