package es.upm.miw.jee.ecp.controllers;

import es.upm.miw.jee.ecp.models.daos.TemaDao;
import es.upm.miw.jee.ecp.models.daos.jpa.DaoJpaFactory;
import es.upm.miw.jee.ecp.models.entities.Tema;

public class AddTemaController {
	
	public void addTema (Tema tema){
		TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();
		dao.create(tema);
	}

}
