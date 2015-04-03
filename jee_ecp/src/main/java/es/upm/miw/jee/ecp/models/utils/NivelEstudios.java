package es.upm.miw.jee.ecp.models.utils;

import java.util.ArrayList;
import java.util.List;

public enum NivelEstudios {
	SIN_ESTUDIOS, PRIMARIOS, SECUNDARIOS, SUPERIORES;

	public static List<String> names() {

		List<String> list = new ArrayList<String>();
		for (NivelEstudios s : values()) {
			list.add(s.name());
		}

		return list;
	}
}
