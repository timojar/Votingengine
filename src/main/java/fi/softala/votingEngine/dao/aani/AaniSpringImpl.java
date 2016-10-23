package fi.softala.votingEngine.dao.aani;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.softala.votingEngine.bean.Aani;


@Repository
public class AaniSpringImpl implements DaoAani {
	
	

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
public void talletaAani(Aani aani)	{
	
	
	final String sql = "insert into aani(innoId, opiskelijaId) values(?,?)";

	// anonyymi sis‰luokka tarvitsee vakioina v‰litett‰v‰t arvot,
	// jotta roskien keruu onnistuu t‰m‰n metodin suorituksen p‰‰ttyess‰.
	
	final int innoId=aani.getInnoId();
	final int opiskelijaId=aani.getOpiskelijaId();

	// jdbc pist‰‰ generoidun id:n t‰nne talteen
	KeyHolder idHolder = new GeneratedKeyHolder();

	// suoritetaan p‰ivitys itse m‰‰ritellyll‰ PreparedStatementCreatorilla
	// ja KeyHolderilla
	jdbcTemplate.update(new PreparedStatementCreator() {
		public PreparedStatement createPreparedStatement(
				Connection connection) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(sql,
					new String[] { "id" });
			ps.setInt(1, innoId);
			ps.setInt(2, opiskelijaId);
			
			return ps;
		}
	}, idHolder);
	
	
	
	
	
	
}
	
	


public void muutaoikeuksia(int opiskelijaId){
	
	final String sql = "update  opiskelija set valtuusId=?  where id=?";

	final int valtuusId=3;
	
	
	
	Object[] parametrit = new Object[] { valtuusId, opiskelijaId };

	jdbcTemplate.update(sql, parametrit);

	
	
}




public List<Aani> listaaTulokset() {

	String sql = "select nimi, aihe, count(innoId) as lkm FROM aani  join innovaatio on innovaatio.id= aani.innoId group by nimi order by lkm desc";
	
	RowMapper<Aani> mapper = new AaniRowMapper();
	List<Aani> aanet = jdbcTemplate.query(sql, mapper);

	return aanet;
}





	

}
