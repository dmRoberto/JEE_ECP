package es.upm.jee.ecp.ws.rest;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

import es.upm.jee.ecp.ws.TemaUris;
import es.upm.miw.jee.ecp.models.daos.DaoFactory;
import es.upm.miw.jee.ecp.models.entities.Tema;

@Path(TemaUris.PATH_TEMAS)
public class TemaResource {

	private static final String AUTH_CODE = "666";

	private void debug(String msg) {
		LogManager.getLogger(this.getClass()).debug(TemaUris.PATH_TEMAS + msg);
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response createTema(Tema tema) {
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
	@Produces(MediaType.APPLICATION_XML)
	public Tema findTema(@QueryParam("id") Integer id) {
		Tema tema = DaoFactory.getFactory().getTemaDao().read(id);
		this.debug(TemaUris.PATH_SEARCH + "?&id=" + id + " /GET: " + tema);
		if (tema == null) {
			throw new NotFoundException();
		} else {
			return tema;
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Tema> findAll() {
		this.debug(TemaUris.PATH_TEMAS + " /GETall ");
		return DaoFactory.getFactory().getTemaDao().findAll();
	}

	@Path(TemaUris.PATH_ID)
	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	public void deleteTema(@PathParam("id") Integer id,
			@QueryParam("auth") String autorizacion) {
		this.debug(TemaUris.PATH_TEMAS + " /GETall ");
		this.debug(TemaUris.PATH_TEMAS + " /GETall ID: "+id);
		this.debug(TemaUris.PATH_TEMAS + " /GETall Auth: "+autorizacion);
		if (autorizacion.equals(AUTH_CODE)) {
			DaoFactory.getFactory().getTemaDao().deleteById(id);
			this.debug("/" + id + " /DELETE");
		} else {
			throw new NotAuthorizedException(Response.ok());
		}
	}
}
