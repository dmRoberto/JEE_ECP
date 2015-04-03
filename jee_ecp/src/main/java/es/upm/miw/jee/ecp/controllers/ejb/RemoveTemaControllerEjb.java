package es.upm.miw.jee.ecp.controllers.ejb;

import java.util.List;

import es.upm.miw.jee.ecp.controllers.RemoveTemaController;
import es.upm.miw.jee.ecp.models.daos.jpa.DaoJpaFactory;
import es.upm.miw.jee.ecp.models.entities.Tema;

public class RemoveTemaControllerEjb implements RemoveTemaController {

	public Boolean removeTema(Integer temaId, String autorizacionCode) {
		if (autorizacionCode.equalsIgnoreCase(AUTH_CODE)) {
			DaoJpaFactory.getFactory().getTemaDao().deleteById(temaId);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Tema> getTemasList() {
		return DaoJpaFactory.getFactory().getTemaDao().findAll();
	}
}
