package es.upm.miw.jee.ecp.controllers.ejb;

import java.util.List;

import es.upm.miw.jee.ecp.controllers.VerVotacionesController;
import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.models.entities.Voto;
import es.upm.miw.jee.ecp.models.utils.NivelEstudios;

public class VerVotacionesControllerEjb implements VerVotacionesController {

	@Override
	public Integer getNumeroVotos(Integer temaId) {
		Tema tema = ControllerFactoryEjb.getFactory().getTemaController()
				.getTema(temaId);

		return tema.getVotos().size();
	}

	@Override
	public Double getMediaByEstudios(Integer temaId, NivelEstudios estudios) {
		Integer numeroVotos = 0;
		Integer sumaValoraciones = 0;
		List<Voto> votos = ControllerFactoryEjb.getFactory()
				.getTemaController().getTemaVotos(temaId);

		for (Voto voto : votos) {
			if (voto.getNivelEstudios().name()
					.equalsIgnoreCase(estudios.name())) {
				numeroVotos++;
				sumaValoraciones = sumaValoraciones + voto.getValoracion();
			}
		}
		return new Double(sumaValoraciones / numeroVotos);
	}

}
