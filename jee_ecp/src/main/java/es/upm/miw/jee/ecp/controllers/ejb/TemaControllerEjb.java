package es.upm.miw.jee.ecp.controllers.ejb;

import java.util.List;

import es.upm.miw.jee.ecp.controllers.TemaController;
import es.upm.miw.jee.ecp.models.daos.jpa.DaoJpaFactory;
import es.upm.miw.jee.ecp.models.entities.Tema;

public class TemaControllerEjb implements TemaController {

	@Override
	public List<Tema> getTemasList() {
		return DaoJpaFactory.getFactory().getTemaDao().findAll();
	}

}
