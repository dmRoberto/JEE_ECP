package es.upm.miw.jee.ecp.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.miw.jee.ecp.models.daos.TemaDao;
import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.models.entities.Voto;
import es.upm.miw.jee.ecp.models.utils.NivelEstudios;

public class TemaDaoJpaTest {
	private TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();

	private Tema tema;

	@Before
	public void before() {
		List<Voto> votos = new ArrayList<Voto>();
		votos.add(new Voto("1.1.1.1", 10, NivelEstudios.SECUNDARIOS));
		tema = new Tema("Pregunta 1", votos);
		dao.create(tema);
	}

	@After
	public void after() {
		dao.deleteById(tema.getId());
	}

	@Test
	public void readVotoTest() {
		assertEquals(tema, dao.read(tema.getId()));
		dao.deleteById(tema.getId());
	}

	@Test
	public void updateVotoTest() {
		tema.setPregunta("Pregunta Update");
		tema.getVotos().add(new Voto("2.2.2.2", 10, NivelEstudios.SECUNDARIOS));
		dao.update(tema);
		assertEquals("Pregunta Update", dao.read(this.tema.getId())
				.getPregunta());
		assertEquals(2, dao.read(this.tema.getId()).getVotos().size());
		dao.deleteById(tema.getId());
	}

	@Test
	public void deleteByIdVotoTest() {
		dao.deleteById(tema.getId());
		assertNull(dao.read(tema.getId()));
	}

	@Test
	public void findAllVotoTest() {
		assertEquals(1, dao.findAll().size());
	}
}
