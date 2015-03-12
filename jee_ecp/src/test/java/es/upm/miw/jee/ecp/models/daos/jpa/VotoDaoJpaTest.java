package es.upm.miw.jee.ecp.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.miw.jee.ecp.models.daos.VotoDao;
import es.upm.miw.jee.ecp.models.entities.Voto;
import es.upm.miw.jee.ecp.models.utils.NivelEstudios;

public class VotoDaoJpaTest {

	private VotoDao dao = DaoJpaFactory.getFactory().getVotoDao();;

	private Voto voto;

	@Before
	public void before() {
		voto = new Voto("0.0.0.0", 10, NivelEstudios.SECUNDARIOS);
		dao.create(voto);
	}

	@After
	public void after() {
		dao.deleteById(voto.getId());
	}

	@Test
	public void readVotoTest() {
		assertEquals(voto, dao.read(voto.getId()));
	}

	@Test
	public void updateVotoTest() {
		voto.setValoracion(1);
		voto.setNivelEstudios(NivelEstudios.SIN_ESTUDIOS);
		voto.setIpUsuario("0.0.0.1");
		dao.update(voto);
		assertEquals(new Integer(1), dao.read(this.voto.getId())
				.getValoracion());
		assertEquals(NivelEstudios.SIN_ESTUDIOS, dao.read(this.voto.getId())
				.getNivelEstudios());
		assertEquals("0.0.0.1", dao.read(this.voto.getId()).getIpUsuario());
	}

	@Test
	public void deleteByIdVotoTest() {
		dao.deleteById(voto.getId());
		assertNull(dao.read(voto.getId()));
	}

	@Test
	public void findAllVotoTest() {
		assertEquals(1, dao.findAll().size());
	}

}
