package es.upm.miw.jee.ecp.controllers;

import es.upm.miw.jee.ecp.models.utils.NivelEstudios;

public interface VerVotacionesController {

	public Integer getNumeroVotos(Integer temaId, NivelEstudios estudios);

	public Double getMediaByEstudios(Integer temaId, NivelEstudios estudios);
}
