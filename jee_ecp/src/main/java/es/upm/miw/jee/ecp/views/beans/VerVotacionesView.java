package es.upm.miw.jee.ecp.views.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.jee.ecp.controllers.TemaController;
import es.upm.miw.jee.ecp.controllers.VerVotacionesController;
import es.upm.miw.jee.ecp.controllers.ejb.ControllerFactoryEjb;
import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.models.utils.NivelEstudios;

public class VerVotacionesView {
	private String errorMsg;

	private List<Tema> temas;

	private List<String> nivelesEstudios;

	private Map<String, Double> mediasByEstudios;

	private Integer numeroVotos;

	private String temaId = "";

	private Tema tema;

	public VerVotacionesView() {
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void update() {
		LogManager.getLogger(RemoveTemaView.class).debug("Updating view... ");
		TemaController controllerTema = ControllerFactoryEjb.getFactory()
				.getTemaController();
		temas = new ArrayList<Tema>();
		temas.add(new Tema("Elige", "", null));

		for (Tema tema : controllerTema.getTemasList()) {
			temas.add(tema);
		}

		nivelesEstudios = NivelEstudios.names();

		LogManager.getLogger(RemoveTemaView.class).debug(
				"END Updating view... ");
	}

	public String process() {

		VerVotacionesController controller = ControllerFactoryEjb.getFactory()
				.getVerVotacionesController();
		LogManager.getLogger(RemoveTemaView.class).debug(
				"Process: tema "+ temaId);
		numeroVotos = controller.getNumeroVotos(Integer.valueOf(temaId));

		LogManager.getLogger(RemoveTemaView.class).debug(
				"Process: mediasByEstudios "+ mediasByEstudios);
		
		nivelesEstudios = NivelEstudios.names();
		for (String estudios : nivelesEstudios) {
			mediasByEstudios.put(estudios, controller.getMediaByEstudios(
					Integer.valueOf(temaId), NivelEstudios.valueOf(estudios)));
		}
		
		LogManager.getLogger(RemoveTemaView.class).debug(
				"Process: mediasByEstudios "+ mediasByEstudios);


		return "verVotaciones";
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public List<String> getNivelesEstudios() {
		return nivelesEstudios;
	}

	public void setNivelesEstudios(List<String> nivelesEstudios) {
		this.nivelesEstudios = nivelesEstudios;
	}

	public void setTemaId(String temaId) {
		this.temaId = temaId;
	}

	public String getTemaId() {
		return temaId;
	}

	public Tema getTema() {
		return tema;
	}

	public Map<String, Double> getMediasByEstudios() {
		return mediasByEstudios;
	}

	public void setMediasByEstudios(Map<String, Double> mediasByEstudios) {
		this.mediasByEstudios = mediasByEstudios;
	}

	public Integer getNumeroVotos() {
		return numeroVotos;
	}

	public void setNumeroVotos(Integer numeroVotos) {
		this.numeroVotos = numeroVotos;
	}

	public void setTema(String temaId) {
		LogManager.getLogger(RemoveTemaView.class).debug("Tema ID: " + temaId);
		TemaController controllerTema = ControllerFactoryEjb.getFactory()
				.getTemaController();
		tema = controllerTema.getTema(Integer.valueOf(temaId));
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	private void cleanView() {
		temas = null;
		nivelesEstudios = null;
		temaId = "";
		tema = null;
	}
}
