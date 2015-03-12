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
	private NivelEstudios phoneType;

	public Voto() {
		super();
	}

	public Voto(String ipUsuario, Integer valoracion, NivelEstudios phoneType) {
		super();
		this.ipUsuario = ipUsuario;
		this.valoracion = valoracion;
		this.phoneType = phoneType;
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

	public NivelEstudios getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(NivelEstudios phoneType) {
		this.phoneType = phoneType;
	}

	@Override
	public String toString() {
		return "Voto [id=" + id + ", ipUsuario=" + ipUsuario + ", valoracion="
				+ valoracion + ", phoneType=" + phoneType + "]";
	}

}
