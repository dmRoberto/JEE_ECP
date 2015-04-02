package es.upm.miw.jee.ecp.controllers;

public abstract class ControllerFactory {

	public abstract AddTemaController getAddTemaController();
	
	public abstract RemoveTemaController getRemoveTemaController();
}
