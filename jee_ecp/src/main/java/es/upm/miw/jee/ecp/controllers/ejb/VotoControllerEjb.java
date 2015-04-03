package es.upm.miw.jee.ecp.controllers.ejb;

import java.util.List;

import es.upm.miw.jee.ecp.controllers.VotoController;
import es.upm.miw.jee.ecp.models.daos.jpa.DaoJpaFactory;
import es.upm.miw.jee.ecp.models.entities.Voto;

public class VotoControllerEjb implements VotoController {

	@Override
	public List<Voto> getVotosList() {
		return DaoJpaFactory.getFactory().getVotoDao().findAll();
	}

}
