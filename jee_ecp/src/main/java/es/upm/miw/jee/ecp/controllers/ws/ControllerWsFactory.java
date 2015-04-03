package es.upm.miw.jee.ecp.controllers.ws;

import es.upm.miw.jee.ecp.controllers.AddTemaController;
import es.upm.miw.jee.ecp.controllers.ControllerFactory;
import es.upm.miw.jee.ecp.controllers.RemoveTemaController;
import es.upm.miw.jee.ecp.controllers.VerVotacionesController;
import es.upm.miw.jee.ecp.controllers.VotarController;
import es.upm.miw.jee.ecp.models.daos.DaoFactory;

public class ControllerWsFactory extends ControllerFactory {

	private AddTemaController addTemaController;

	private RemoveTemaController removeTemaController;

	private VerVotacionesController verVotacionesController;

	private VotarController votarController;

	public static ControllerWsFactory factory = null;

	public static void setFactory(DaoFactory factory) {
		DaoFactory.factory = factory;
	}

	public static ControllerWsFactory getFactory() {
		if (factory == null) {
			factory = new ControllerWsFactory();
		}
		return factory;
	}

	@Override
	public AddTemaController getAddTemaController() {
		if (addTemaController == null) {
			addTemaController = new AddTemaControllerWs();
		}
		return addTemaController;
	}

	@Override
	public RemoveTemaController getRemoveTemaController() {
		if (removeTemaController == null) {
			removeTemaController = new RemoveTemaControllerWs();
		}
		return removeTemaController;
	}

	@Override
	public VotarController getVotarController() {
		if (votarController == null) {
			votarController = new VotarControllerWs();
		}
		return votarController;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		if (verVotacionesController == null) {
			verVotacionesController = new VerVotacionesControllerWs();
		}
		return verVotacionesController;
	}

}
