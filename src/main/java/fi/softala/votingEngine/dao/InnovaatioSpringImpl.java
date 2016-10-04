package fi.softala.votingEngine.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.softala.votingEngine.bean.Innovaatio;

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

	public List<Innovaatio> haeKaikki() {

		String sql = "select id, nimi ,  aihe from innovaatio";
		RowMapper<Innovaatio> mapper = new InnovaatioRowMapper();
		List<Innovaatio> innovaatiot = jdbcTemplate.query(sql, mapper);

		return innovaatiot;
	}

}
