package es.upm.miw.jee.ecp.controllers.ejb;

import es.upm.miw.jee.ecp.controllers.RemoveTemaController;
import es.upm.miw.jee.ecp.models.daos.jpa.DaoJpaFactory;

public class RemoveTemaControllerEjb extends TemaControllerEjb implements
		RemoveTemaController {

	public void removeTema(Integer temaId) {
		DaoJpaFactory.getFactory().getTemaDao().deleteById(temaId);
	}
}
