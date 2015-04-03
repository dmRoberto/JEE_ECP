package es.upm.miw.jee.ecp.models.daos;

import java.util.List;

import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.models.entities.Voto;

public interface TemaDao extends GenericDao<Tema, Integer> {
	
	public List<Voto> votosForTemaId (Integer temaId);

}
