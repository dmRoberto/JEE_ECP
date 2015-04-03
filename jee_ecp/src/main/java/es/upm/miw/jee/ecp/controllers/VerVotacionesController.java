package es.upm.miw.jee.ecp.controllers;

import java.util.List;

import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.models.utils.NivelEstudios;

public interface VerVotacionesController {

	public Integer getNumeroVotos(Integer temaId);

	public Double getMediaByEstudios(Integer temaId, NivelEstudios estudios);

	public List<Tema> getTemasList();

	public Tema getTema(Integer temaId);
}
