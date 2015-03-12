package es.upm.miw.jee.ecp.models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import es.upm.miw.jee.ecp.models.utils.NivelEstudios;

@Entity
public class Voto {

	@Id
	@GeneratedValue
	private Integer id;

	private String ipUsuario;

	private Integer valoracion;

	@Enumerated(EnumType.STRING)
	private NivelEstudios nivelEstudios;

	public Voto() {
		super();
	}

	public Voto(String ipUsuario, Integer valoracion,
			NivelEstudios nivelEstudios) {
		super();
		this.ipUsuario = ipUsuario;
		this.valoracion = valoracion;
		this.nivelEstudios = nivelEstudios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIpUsuario() {
		return ipUsuario;
	}

	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	public NivelEstudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	@Override
	public String toString() {
		return "Voto [id=" + id + ", ipUsuario=" + ipUsuario + ", valoracion="
				+ valoracion + ", nivelEstudios=" + nivelEstudios + "]";
	}

}
