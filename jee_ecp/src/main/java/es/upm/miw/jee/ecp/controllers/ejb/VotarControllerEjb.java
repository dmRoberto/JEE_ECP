package es.upm.miw.jee.ecp.controllers.ejb;

import es.upm.miw.jee.ecp.controllers.VotarController;
import es.upm.miw.jee.ecp.models.daos.jpa.DaoJpaFactory;
import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.models.entities.Voto;

public class VotarControllerEjb implements VotarController {

	@Override
	public void votar(Tema tema, Voto voto) {
		tema.addVoto(voto);
		DaoJpaFactory.getFactory().getTemaDao().update(tema);

	}
}
