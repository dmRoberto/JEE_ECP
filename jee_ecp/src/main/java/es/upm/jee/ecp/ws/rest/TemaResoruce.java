package es.upm.jee.ecp.ws.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

import es.upm.jee.ecp.ws.TemaUris;
import es.upm.miw.jee.ecp.models.daos.DaoFactory;
import es.upm.miw.jee.ecp.models.entities.Tema;

@Path(TemaUris.PATH_TEMAS)
public class TemaResoruce {

	private void debug(String msg) {
		LogManager.getLogger(this.getClass()).debug(TemaUris.PATH_TEMAS + msg);
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response create(Tema tema) {
		Response result;

		DaoFactory.getFactory().getTemaDao().create(tema);
		result = Response
				.created(URI.create(TemaUris.PATH_TEMAS + "/" + tema.getId()))
				.entity(String.valueOf(tema.getId())).build();
		this.debug(" /POST: " + tema);

		return result;
	}

	@GET
	@Path(TemaUris.PATH_SEARCH)
	@Consumes(MediaType.APPLICATION_XML)
	public String findTema(@QueryParam("id") Integer id) {
		Tema tema = DaoFactory.getFactory().getTemaDao().read(id);
		this.debug(TemaUris.PATH_SEARCH + "?&id=" + id + " /GET: " + tema);
		if (tema == null) {
			throw new NotFoundException();
		} else {
			return String.valueOf(tema.getId());
		}

	}

	@Path(TemaUris.PATH_ID)
	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	public void deleteGame(@PathParam("id") Integer id) {
		DaoFactory.getFactory().getTemaDao().deleteById(id);
		this.debug("/" + id + " /DELETE");
	}
}
