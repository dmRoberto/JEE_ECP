package es.upm.miw.jee.ecp.models.daos.jpa;

import es.upm.jee.ecp.models.daos.VotoDao;
import es.upm.miw.jee.ecp.models.entities.Voto;

public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao {

	public VotoDaoJpa() {
		super(Voto.class);
	}

}
