package es.upm.miw.jee.ecp.models.daos.jpa;

import es.upm.jee.ecp.models.daos.TemaDao;
import es.upm.miw.jee.ecp.models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

	public TemaDaoJpa() {
		super(Tema.class);
	}

}
