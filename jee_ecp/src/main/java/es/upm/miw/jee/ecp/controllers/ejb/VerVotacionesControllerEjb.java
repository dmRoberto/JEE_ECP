package es.upm.miw.jee.ecp.controllers.ejb;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.jee.ecp.controllers.VerVotacionesController;
import es.upm.miw.jee.ecp.models.daos.jpa.DaoJpaFactory;
import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.models.entities.Voto;
import es.upm.miw.jee.ecp.models.utils.NivelEstudios;

public class VerVotacionesControllerEjb implements VerVotacionesController {

	@Override
	public Integer getNumeroVotos(Integer temaId) {
		Tema tema = DaoJpaFactory.getFactory().getTemaDao().read(temaId);

		return tema.getVotos().size();
	}

	@Override
	public Double getMediaByEstudios(Integer temaId, NivelEstudios estudios) {
		Integer numeroVotos = 0;
		Integer sumaValoraciones = 0;

		List<Voto> votos = DaoJpaFactory.getFactory().getTemaDao()
				.votosForTemaId(temaId);

		for (Voto voto : votos) {
			if (voto.getNivelEstudios().name()
					.equalsIgnoreCase(estudios.name())) {
				numeroVotos++;
				sumaValoraciones = sumaValoraciones + voto.getValoracion();
			}
		}
		LogManager.getLogger(VerVotacionesControllerEjb.class).debug(
				"Process: sumaValoraciones " + sumaValoraciones);
		LogManager.getLogger(VerVotacionesControllerEjb.class).debug(
				"Process: numeroVotos " + numeroVotos);
		if (numeroVotos == 0) {
			return 0.0;
		}
		return new Double(sumaValoraciones / numeroVotos);
	}

	@Override
	public List<Tema> getTemasList() {
		return DaoJpaFactory.getFactory().getTemaDao().findAll();
	}

	@Override
	public Tema getTema(Integer temaId) {
		return DaoJpaFactory.getFactory().getTemaDao().read(temaId);
	}

}
