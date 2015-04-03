package es.upm.miw.jee.ecp.controllers.ejb;

import es.upm.miw.jee.ecp.controllers.AddTemaController;
import es.upm.miw.jee.ecp.controllers.ControllerFactory;
import es.upm.miw.jee.ecp.controllers.RemoveTemaController;
import es.upm.miw.jee.ecp.controllers.VerVotacionesController;
import es.upm.miw.jee.ecp.controllers.VotarController;
import es.upm.miw.jee.ecp.models.daos.DaoFactory;

public class ControllerFactoryEjb extends ControllerFactory {

	public static ControllerFactoryEjb factory = null;

	public static void setFactory(DaoFactory factory) {
		DaoFactory.factory = factory;
	}

	public static ControllerFactoryEjb getFactory() {
		if (factory == null) {
			factory = new ControllerFactoryEjb();
		}
		return factory;
	}

	@Override
	public AddTemaController getAddTemaController() {
		return new AddTemaControllerEjb();
	}

	@Override
	public RemoveTemaController getRemoveTemaController() {
		return new RemoveTemaControllerEjb();
	}

	@Override
	public VotarController getVotarController() {
		return new VotarControllerEjb();
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		return new VerVotacionesControllerEjb();
	}

}
