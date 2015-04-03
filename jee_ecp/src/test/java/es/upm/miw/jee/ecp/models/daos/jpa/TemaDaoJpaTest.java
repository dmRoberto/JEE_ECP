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
		tema = new Tema("Nombre Tema1", "Pregunta 1", votos);
		dao.create(tema);
	}

	@After
	public void after() {
		dao.deleteById(tema.getId());
	}

	@Test
	public void readTemaTest() {
		assertEquals(tema, dao.read(tema.getId()));
		dao.deleteById(tema.getId());
	}

	@Test
	public void getVotosTemaTest() {
		List<Voto> votos = dao.votosForTemaId(tema.getId());
		assertEquals("1.1.1.1", votos.get(0).getIpUsuario());
	}

	@Test
	public void updateTemaTest() {
		tema.setPregunta("Pregunta Update");
		tema.getVotos().add(new Voto("2.2.2.2", 10, NivelEstudios.SECUNDARIOS));
		tema.setNombre("Nuevo nombre");
		dao.update(tema);

		Tema updatedTema = dao.read(this.tema.getId());
		assertEquals("Pregunta Update", updatedTema.getPregunta());
		assertEquals(2, updatedTema.getVotos().size());
		assertEquals("Nuevo nombre", updatedTema.getNombre());
		dao.deleteById(tema.getId());
	}

	@Test
	public void deleteByIdTemaTest() {
		dao.deleteById(tema.getId());
		assertNull(dao.read(tema.getId()));
	}

	@Test
	public void findAllTemaTest() {
		assertEquals(1, dao.findAll().size());
	}
}
