package es.upm.miw.jee.ecp.controllers.ejb;

import java.util.List;

import es.upm.miw.jee.ecp.controllers.VerVotacionesController;
import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.models.entities.Voto;
import es.upm.miw.jee.ecp.models.utils.NivelEstudios;

public class VerVotacionesControllerEjb implements VerVotacionesController {

	@Override
	public Integer getNumeroVotos(Integer temaId, NivelEstudios estudios) {
		Integer result = 0;
		Tema tema = ControllerFactoryEjb.getFactory().getTemaController()
				.getTema(temaId);
		List<Voto> votos = tema.getVotos();
		for (Voto voto : votos) {
			if (voto.getNivelEstudios().name()
					.equalsIgnoreCase(estudios.name())) {
				result++;
			}
		}
		return result;
	}

	@Override
	public Double getMediaByEstudios(Integer temaId, NivelEstudios estudios) {
		Integer numeroVotos = 0;
		Integer sumaValoraciones = 0;
		Tema tema = ControllerFactoryEjb.getFactory().getTemaController()
				.getTema(temaId);
		List<Voto> votos = tema.getVotos();
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
