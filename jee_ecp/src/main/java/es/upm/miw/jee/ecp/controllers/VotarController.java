package es.upm.miw.jee.ecp.controllers;

import java.util.List;

import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.models.entities.Voto;

public interface VotarController {

	public void votar(Integer tema, Voto voto);

	public List<Tema> getTemasList();

	public Tema getTema(Integer temaId);

}
