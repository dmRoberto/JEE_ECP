package es.upm.miw.jee.ecp.views.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.jee.ecp.controllers.VotarController;
import es.upm.miw.jee.ecp.controllers.ejb.ControllerFactoryEjb;
import es.upm.miw.jee.ecp.models.entities.Tema;
import es.upm.miw.jee.ecp.models.entities.Voto;
import es.upm.miw.jee.ecp.models.utils.NivelEstudios;

public class VotarView {

	private String errorMsg;

	private List<Tema> temas;

	private List<String> nivelesEstudios;

	private String ip = "";

	private Integer valoracion;

	private String nivelEstudios = "";

	private String temaId = "";

	private Tema tema;

	public VotarView() {
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void update() {
		LogManager.getLogger(RemoveTemaView.class).debug("Updating view... ");
		VotarController controller = ControllerFactoryEjb.getFactory()
				.getVotarController();
		temas = new ArrayList<Tema>();
		temas.add(new Tema("Elige", "", null));

		for (Tema tema : controller.getTemasList()) {
			temas.add(tema);
		}

		nivelesEstudios = NivelEstudios.names();

		LogManager.getLogger(RemoveTemaView.class).debug(
				"END Updating view... ");
	}

	public String process() {

		VotarController controller = ControllerFactoryEjb.getFactory()
				.getVotarController();
		LogManager.getLogger(RemoveTemaView.class).debug(
				"es -- " + nivelEstudios);
		if (nivelEstudios != "") {
			controller.votar(Integer.valueOf(temaId), new Voto(ip, valoracion,
					NivelEstudios.valueOf(nivelEstudios)));
			this.cleanView();
		}

		return "votar";
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	public String getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(String nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
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

	public void setTema(String temaId) {
		LogManager.getLogger(RemoveTemaView.class).debug("Tema ID: " + temaId);
		VotarController controller = ControllerFactoryEjb.getFactory()
				.getVotarController();
		tema = controller.getTema(Integer.valueOf(temaId));
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	private void cleanView() {
		temas = null;
		nivelesEstudios = null;
		ip = "";
		valoracion = null;
		nivelEstudios = "";
		temaId = "";
		tema = null;
	}
}
