package es.upm.miw.jee.ecp.controllers.ejb;

import es.upm.miw.jee.ecp.controllers.RemoveTemaController;
import es.upm.miw.jee.ecp.models.daos.jpa.DaoJpaFactory;

public class RemoveTemaControllerEjb implements RemoveTemaController {

	public Boolean removeTema(Integer temaId, String autorizacionCode) {
		if (autorizacionCode.equalsIgnoreCase(AUTH_CODE)){
			DaoJpaFactory.getFactory().getTemaDao().deleteById(temaId);
			return true;
		}else{
			return false;
		}
	}
}
