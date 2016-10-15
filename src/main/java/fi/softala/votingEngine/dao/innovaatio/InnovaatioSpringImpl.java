package fi.softala.votingEngine.dao.innovaatio;

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









import fi.softala.votingEngine.bean.Innovaatio;
import fi.softala.votingEngine.bean.Opiskelija;
import fi.softala.votingEngine.bean.Ryhma;
import fi.softala.votingEngine.dao.EiLoydyPoikkeus;
import fi.softala.votingEngine.dao.opiskelija.OpiskelijaRowMapper;
import fi.softala.votingEngine.util.Kryptaaja;

@Repository
public class InnovaatioSpringImpl implements InnovaatioDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Innovaatio> haeKaikki(int ryhmaId) {

		String sql = "select id, nimi ,  aihe from innovaatio where ryhmaId !=?";
		Object[] parametrit = new Object[] { ryhmaId };
		RowMapper<Innovaatio> mapper = new InnovaatioRowMapper();
		List<Innovaatio> innovaatiot = jdbcTemplate.query(sql, parametrit, mapper);

		return innovaatiot;
	}
	
	
	
	
	
	public int talletaInnovaatio(Innovaatio i){
		int id=0;
		
		
		
		
		
		final String sql = "insert into innovaatio(nimi, aihe, ryhmaId) values(?,?,?)";

		// anonyymi sis‰luokka tarvitsee vakioina v‰litett‰v‰t arvot,
		// jotta roskien keruu onnistuu t‰m‰n metodin suorituksen p‰‰ttyess‰.
		final String nimi = i.getNimi();
		final String aihe = i.getAihe();
		final int ryhmaId=i.getRyhmaId();

		// jdbc pist‰‰ generoidun id:n t‰nne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan p‰ivitys itse m‰‰ritellyll‰ PreparedStatementCreatorilla
		// ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setString(1, nimi);
				ps.setString(2, aihe);
				ps.setInt(3, ryhmaId);
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pit‰isi olla viittaus samaiseen olioon
		i.setId(idHolder.getKey().intValue());	
		id=i.getId();
		
		
		
		return id;
	}
	
	
	
	public Innovaatio etsiInnovaatio(int ryhmaId){
		
		
		
		
		
		
		
		String sql = "select nimi, aihe, id from innovaatio where ryhmaId = ?";
		Object[] parametrit = new Object[] { ryhmaId };
		RowMapper<Innovaatio> mapper = new InnovaatioRowMapper();

		Innovaatio i;
		try {
			i = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new EiLoydyPoikkeus(e);
		}
		
		
		
		return i;
		
		
	}
	
	

	public String talletaOpiskelija(Opiskelija o){
		
		
		Kryptaaja kryptaaja=new Kryptaaja();
		
		
		
		final String sql = "insert into opiskelija(etunimi, sukunimi, opiskelijanumero, email, ryhmaId, valtuusId, enabled, opiskelijanumeroKryptattuna) values(?,?,?,?,?,?,?,?)";

		// anonyymi sis‰luokka tarvitsee vakioina v‰litett‰v‰t arvot,
		// jotta roskien keruu onnistuu t‰m‰n metodin suorituksen p‰‰ttyess‰.
		final String etunimi = o.getEtunimi();
		final String sukunimi = o.getSukunimi();
		final String opiskelijanumero=o.getOpiskelijanumero();
		final String email=o.getEmail();
		final int ryhmaId=o.getRyhmaId();
		final int valtuusId=2;
		final int enabled=1;
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
				ps.setInt(7, enabled);
				ps.setString(8, kryptaus);
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pit‰isi olla viittaus samaiseen olioon
		o.setId(idHolder.getKey().intValue());	
		
		
		 
		return kryptaus;
		
	}
	
	
	
	
		
		
		 
		
		
		public Opiskelija etsiOpiskelija(int id){
			
			
			
			 
			 String sql = "select etunimi, sukunimi, opiskelijanumero, email, ryhmaId, id from opiskelija where id = ? ";
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
		
		
		
		
	public Opiskelija haeOpiskelija(String email)	
	{
			
			
			
			 
			 String sql = "select * from opiskelija where  email=?";
				Object[] parametrit = new Object[] { email };
				RowMapper<Opiskelija> mapper = new OpiskelijaRowMapper();

				Opiskelija o;
				try {
					o = jdbcTemplate.queryForObject(sql, parametrit, mapper);
				} catch (IncorrectResultSizeDataAccessException e) {
					throw new EiLoydyPoikkeus(e);
				}
			
			
			
			
		return o;
			
		}


	
	public int talletaRyhma(Ryhma ryhma){
		
		
		
		
		
		
		final String sql = "insert into ryhma(nimi, tyyppi) values(?,?)";

		// anonyymi sis‰luokka tarvitsee vakioina v‰litett‰v‰t arvot,
		// jotta roskien keruu onnistuu t‰m‰n metodin suorituksen p‰‰ttyess‰.
		final String nimi = ryhma.getNimi();
		final String tyyppi = ryhma.getTyyppi();
		

		// jdbc pist‰‰ generoidun id:n t‰nne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan p‰ivitys itse m‰‰ritellyll‰ PreparedStatementCreatorilla
		// ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setString(1, nimi);
				ps.setString(2, tyyppi);
				
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pit‰isi olla viittaus samaiseen olioon
		ryhma.setId(idHolder.getKey().intValue());	
		
		int ryhmaId=ryhma.getId();
		
		
		
		
		
		return ryhmaId;
	}
	
	
	
		
		
	
		
	}
	
	


