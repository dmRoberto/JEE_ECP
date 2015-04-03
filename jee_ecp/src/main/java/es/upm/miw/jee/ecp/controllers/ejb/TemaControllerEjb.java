package es.upm.miw.jee.ecp.controllers.ejb;

import java.util.List;

import es.upm.miw.jee.ecp.controllers.TemaController;
import es.upm.miw.jee.ecp.models.daos.jpa.DaoJpaFactory;
import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.models.entities.Voto;

public class TemaControllerEjb implements TemaController {

	@Override
	public List<Tema> getTemasList() {
		return DaoJpaFactory.getFactory().getTemaDao().findAll();
	}

	@Override
	public Tema getTema(Integer id) {
		return DaoJpaFactory.getFactory().getTemaDao().read(id);
	}

	@Override
	public List<Voto> getTemaVotos(Integer id) {
		return DaoJpaFactory.getFactory().getTemaDao().votosForTemaId(id);
	}

}
