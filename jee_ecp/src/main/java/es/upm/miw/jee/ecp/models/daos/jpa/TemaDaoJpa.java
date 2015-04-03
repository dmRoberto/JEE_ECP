package es.upm.miw.jee.ecp.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.upm.miw.jee.ecp.models.daos.TemaDao;
import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.models.entities.Voto;
import es.upm.miw.jee.ecp.models.utils.NivelEstudios;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

	public TemaDaoJpa() {
		super(Tema.class);
	}

	@Override
	public List<Voto> votosForTemaId(Integer temaId) {
		EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory()
				.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Voto> query = builder.createQuery(Voto.class);
		Root<Tema> root = query.from(Tema.class);
		query.select(root.get("votos"));
		Predicate predicate = builder.equal(root.get("id").as(Integer.class),
				temaId);

		query.where(predicate);
		TypedQuery<Voto> typedQuery = entityManager.createQuery(query);
		List<Voto> result = typedQuery.getResultList();
		entityManager.close();

		return result;
	}

}
