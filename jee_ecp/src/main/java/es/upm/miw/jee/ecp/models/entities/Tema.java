package es.upm.miw.jee.ecp.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tema {

	@Id
	@GeneratedValue
	private Integer id;

	private String pregunta;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Voto> votos;

	public Tema() {
		super();
	}

	public Tema(String pregunta, List<Voto> votos) {
		super();
		this.pregunta = pregunta;
		this.votos = votos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	@Override
	public String toString() {
		return "Tema [id=" + id + ", pregunta=" + pregunta + ", votos=" + votos
				+ "]";
	}

}
