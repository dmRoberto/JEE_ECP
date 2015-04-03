package es.upm.miw.jee.ecp.models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import es.upm.miw.jee.ecp.models.utils.NivelEstudios;

@Entity
public class Voto {

	public static final String TABLE = "voto";
	public static final String ID = "ID";

	@Id
	@GeneratedValue
	private Integer id;

	public static final String IP_USUARIO = "IPUSUARIO";
	private String ipUsuario;

	public static final String VALORACION = "VALORACION";
	private Integer valoracion;

	public static final String NIVELESTUDIOS = "NIVELESTUDIOS";
	@Enumerated(EnumType.STRING)
	private NivelEstudios nivelEstudios;

	public Voto() {
	}

	public Voto(String ipUsuario, Integer valoracion,
			NivelEstudios nivelEstudios) {
		super();
		this.ipUsuario = ipUsuario;
		this.valoracion = valoracion;
		this.nivelEstudios = nivelEstudios;
	}

	public Voto(Integer id, String ipUsuario, Integer valoracion,
			NivelEstudios nivelEstudios) {
		super();
		this.id = id;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((ipUsuario == null) ? 0 : ipUsuario.hashCode());
		result = prime * result
				+ ((nivelEstudios == null) ? 0 : nivelEstudios.hashCode());
		result = prime * result
				+ ((valoracion == null) ? 0 : valoracion.hashCode());
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
		Voto other = (Voto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ipUsuario == null) {
			if (other.ipUsuario != null)
				return false;
		} else if (!ipUsuario.equals(other.ipUsuario))
			return false;
		if (nivelEstudios != other.nivelEstudios)
			return false;
		if (valoracion == null) {
			if (other.valoracion != null)
				return false;
		} else if (!valoracion.equals(other.valoracion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Voto [id=" + id + ", ipUsuario=" + ipUsuario + ", valoracion="
				+ valoracion + ", nivelEstudios=" + nivelEstudios + "]";
	}

}
