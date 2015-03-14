package es.upm.miw.jee.ecp.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.upm.miw.jee.ecp.models.daos.VotoDao;
import es.upm.miw.jee.ecp.models.entities.Voto;
import es.upm.miw.jee.ecp.models.utils.NivelEstudios;

public class VotoDaoJdbc extends GenericDaoJdbc<Voto, Integer> implements
		VotoDao {
	private Logger log = LogManager.getLogger(VotoDaoJdbc.class);

	private Voto create(ResultSet resultSet) {
		try {
			if (resultSet != null && resultSet.next()) {
				return new Voto(resultSet.getInt(Voto.ID),
						resultSet.getString(Voto.IP_USUARIO),
						resultSet.getInt(Voto.VALORACION),
						NivelEstudios.valueOf(resultSet
								.getString(Voto.NIVELESTUDIOS)));
			}
		} catch (SQLException e) {
			log.error("read: " + e.getMessage());
		}
		return null;
	}

	private static final String SQL_CREATE_TABLE = "CREATE TABLE %s "
			+ "(%s INT NOT NULL AUTO_INCREMENT, %s VARCHAR(255), "
			+ "%s INT, %s VARCHAR(255), PRIMARY KEY (%s))";

	public static String sqlToCreateTable() {
		return String.format(SQL_CREATE_TABLE, Voto.TABLE, Voto.ID,
				Voto.IP_USUARIO, Voto.VALORACION, Voto.NIVELESTUDIOS, Voto.ID);
	}

	private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s,%s) VALUES (%d,'%s',%d,'%s')";

	@Override
	public void create(Voto entity) {
		this.updateSql(String.format(SQL_INSERT, Voto.TABLE, Voto.ID,
				Voto.IP_USUARIO, Voto.VALORACION, Voto.NIVELESTUDIOS,
				entity.getId(), entity.getIpUsuario(), entity.getValoracion(),
				entity.getNivelEstudios()));
	}

	@Override
	public Voto read(Integer id) {
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ID,
				Voto.TABLE, id));
		return this.create(resultSet);
	}

	private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s=%d, %s='%s' WHERE ID=%d";

	@Override
	public void update(Voto entity) {
		this.updateSql(String.format(SQL_UPDATE, Voto.TABLE, Voto.IP_USUARIO,
				entity.getIpUsuario(), Voto.VALORACION, entity.getValoracion(),
				Voto.NIVELESTUDIOS, entity.getNivelEstudios(), entity.getId()));
	}

	@Override
	public void deleteById(Integer id) {
		this.updateSql(String.format(SQL_DELETE_ID, Voto.TABLE, id));
	}

	@Override
	public List<Voto> findAll() {
		List<Voto> list = new ArrayList<Voto>();
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL,
				Voto.TABLE));
		Voto voto = this.create(resultSet);
		while (voto != null) {
			list.add(voto);
			voto = this.create(resultSet);
		}
		return list;
	}

}
