package es.upm.miw.jee.ecp.models.daos.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;

import es.upm.jee.ecp.models.daos.DaoFactory;
import es.upm.jee.ecp.models.daos.TemaDao;
import es.upm.jee.ecp.models.daos.VotoDao;

public class DaoJpaFactory extends DaoFactory {
	private static final String PERSISTENCE_UNIT = "votaciones";

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public DaoJpaFactory() {
		LogManager.getLogger(DaoJpaFactory.class).debug(
				"create Entity Manager Factory");
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	@Override
	public TemaDao getTemaDao() {
		return new TemaDaoJpa();
	}

	@Override
	public VotoDao getVotoDao() {
		return new VotoDaoJpa();
	}

}
