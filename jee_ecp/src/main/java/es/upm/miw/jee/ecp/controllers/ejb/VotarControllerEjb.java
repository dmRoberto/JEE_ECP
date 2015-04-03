package es.upm.miw.jee.ecp.controllers.ejb;

import java.util.List;

import es.upm.miw.jee.ecp.controllers.VotarController;
import es.upm.miw.jee.ecp.models.daos.TemaDao;
import es.upm.miw.jee.ecp.models.daos.jpa.DaoJpaFactory;
import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.models.entities.Voto;

public class VotarControllerEjb implements VotarController {

	@Override
	public void votar(Integer temaId, Voto voto) {
		TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();
		Tema tema = dao.read(temaId);
		tema.addVoto(voto);
		dao.update(tema);
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
