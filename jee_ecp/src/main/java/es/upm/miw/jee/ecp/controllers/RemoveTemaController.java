package es.upm.miw.jee.ecp.controllers;

import es.upm.miw.jee.ecp.models.daos.jpa.DaoJpaFactory;

public class RemoveTemaController {

	public void removeTema(Integer temaId) {
		DaoJpaFactory.getFactory().getTemaDao().deleteById(temaId);
	}
}
