package es.upm.miw.jee.ecp.controllers;

import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.models.entities.Voto;

public interface VotarController {

	public void votar(Tema tema, Voto voto);

}