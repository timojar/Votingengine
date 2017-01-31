package fi.softala.votingEngine.dao.Aika;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.softala.votingEngine.bean.Aika;
import fi.softala.votingEngine.bean.Innovaatio;
import fi.softala.votingEngine.bean.Pvm;
import fi.softala.votingEngine.dao.EiLoydyPoikkeus;
import fi.softala.votingEngine.dao.innovaatio.InnovaatioRowMapper;

@Repository
public class AikaSpringImpl implements DaoAika {
	
	
	
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	
	

	
public void asetaAika(Pvm p){
	
	final String sql = "update  votedate set  alku=?, loppu=?  where id=1";	
	
	
	Object[] parametrit = new Object[] { p.getAlkuKello(), p.getLoppuKello() };

	jdbcTemplate.update(sql, parametrit);

	
	
}
	

public Aika haeAika(){
	
	String sql = "select alku, loppu from votedate where id = 1";
	
	RowMapper<Aika> mapper = new AikaRowMapper();

	Aika a;
	try {
		a = jdbcTemplate.queryForObject(sql, mapper);
	} catch (IncorrectResultSizeDataAccessException e) {
		throw new EiLoydyPoikkeus(e);
	}
	
	
	return a;
	
	
	
}
	
	
}
