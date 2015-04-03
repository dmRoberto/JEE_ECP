package es.upm.miw.jee.ecp.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Tema {

	@Id
	@GeneratedValue
	private Integer id;

	private String nombre;

	private String pregunta;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Voto> votos;

	public Tema() {
	}

	public Tema(String nombre, String pregunta, List<Voto> votos) {
		super();
		this.nombre = nombre;
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

	public void addVoto(Voto voto) {
		votos.add(voto);
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((pregunta == null) ? 0 : pregunta.hashCode());
		result = prime * result + ((votos == null) ? 0 : votos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tema other = (Tema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pregunta == null) {
			if (other.pregunta != null)
				return false;
		} else if (!pregunta.equals(other.pregunta))
			return false;
		if (votos == null) {
			if (other.votos != null)
				return false;
		} else if (!votos.equals(other.votos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tema [id=" + id + ", nombre=" + nombre + ", pregunta="
				+ pregunta + ", votos=" + votos + "]";
	}

}
