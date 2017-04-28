package fi.softala.votingEngine.dao.opiskelija;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;








import java.util.List;

import javax.inject.Inject;











import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;




import org.springframework.stereotype.Repository;








import fi.softala.votingEngine.bean.Opiskelija;
import fi.softala.votingEngine.dao.EiLoydyPoikkeus;
import fi.softala.votingEngine.util.Kryptaaja;
@Repository
public class OpiskelijaSpringImpl implements OpiskelijaDao{
	
	
	
	
	
	
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	
	public List<Opiskelija> haeInnovaationOpiskelijat(int ryhmaId){
		
		
		String sql = "select * from opiskelija where ryhmaId = ?";
		Object[] parametrit = new Object[] { ryhmaId };
		RowMapper<Opiskelija> mapper = new OpiskelijaRowMapper();
		List<Opiskelija> opiskelijat = jdbcTemplate.query(sql, parametrit, mapper);	
		
		return opiskelijat;
	}
	
	
	
	
	public String talletaOpiskelija(Opiskelija o){
		
		
		
		
		
		
		final String sql = "insert into opiskelija(etunimi, sukunimi, opiskelijanumero, email, ryhmaId, valtuusId, enabled, opiskelijanumeroKryptattuna) values(?,?,?,?,?,?,?,?)";

		// anonyymi sis‰luokka tarvitsee vakioina v‰litett‰v‰t arvot,
		// jotta roskien keruu onnistuu t‰m‰n metodin suorituksen p‰‰ttyess‰.
		Kryptaaja kryptaaja=new Kryptaaja();
		final String etunimi = o.getEtunimi();
		final String sukunimi = o.getSukunimi();
		final String opiskelijanumero=o.getOpiskelijanumero();
		final String email=o.getEmail();
		final int ryhmaId=o.getRyhmaId();
		final int valtuusId=o.getValtuusId();
		final String kryptaus=kryptaaja.opiskelijanumeroKryptattuna(opiskelijanumero);

		// jdbc pist‰‰ generoidun id:n t‰nne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan p‰ivitys itse m‰‰ritellyll‰ PreparedStatementCreatorilla
		// ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setString(1, etunimi);
				ps.setString(2, sukunimi);
				ps.setString(3, opiskelijanumero);
				ps.setString(4, email);
				ps.setInt(5, ryhmaId);
				ps.setInt(6, valtuusId);
				ps.setInt(7, 1);
				ps.setString(8, kryptaus);
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pit‰isi olla viittaus samaiseen olioon
		o.setId(idHolder.getKey().intValue());	
		
		
		
	return kryptaus;
		
	}
	
	
	
	
	
	
	public Opiskelija haeOpiskelija(String email)  {
		
		
		
		

			String sql = "select * from opiskelija where email = ?";
			Object[] parametrit = new Object[] { email };
			RowMapper<Opiskelija> mapper = new OpiskelijaRowMapper();

			Opiskelija o = jdbcTemplate.queryForObject(sql, parametrit, mapper);
			return o;

	
		
		
		
		
		
		
	}
	
	
	
	public Opiskelija tarkistaOpiskelija(String opiskelijanumero)  {
		
		
		
		

		String sql = "select * from opiskelija where opiskelijanumero = ?";
		Object[] parametrit = new Object[] { opiskelijanumero };
		RowMapper<Opiskelija> mapper = new OpiskelijaRowMapper();

		Opiskelija o = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		return o;


	
	
	
	
	
	
}

	
	
	public Opiskelija etsiOpiskelija(int id){
		
		
		
		 
		 String sql = "select * from opiskelija where id = ? ";
			Object[] parametrit = new Object[] { id,  };
			RowMapper<Opiskelija> mapper = new OpiskelijaRowMapper();

			Opiskelija o;
			try {
				o = jdbcTemplate.queryForObject(sql, parametrit, mapper);
			} catch (IncorrectResultSizeDataAccessException e) {
				throw new EiLoydyPoikkeus(e);
			}
		
		
		
		
	return o;
		
	}
	
	
		
	
	
	public  Opiskelija arvoVoittaja() {
		
		
		
		

		String sql = "SELECT * FROM opiskelija where valtuusId=3 ORDER BY RAND() LIMIT 1";
		
		RowMapper<Opiskelija> mapper = new OpiskelijaRowMapper();

		Opiskelija o = jdbcTemplate.queryForObject(sql, mapper);
		return o;


	
	
	
	
	
	
}

	
	
	
	

}
